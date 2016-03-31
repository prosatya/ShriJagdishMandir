package com.matictechnology.shrijagdishmandir.Utility;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;

import com.matictechnology.shrijagdishmandir.Activity.ActivityNotification;
import com.matictechnology.shrijagdishmandir.R;
import com.matictechnology.shrijagdishmandir.classes.Notifications;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by maticd1 on 31/3/16.
 */
public class AlarmService extends Service
{

    int size=0;
    ArrayList<Notifications> list;
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;

    }

    @Override
    public void onCreate()
    {

        super.onCreate();
        Log.e("service","started");

        list=new ArrayList<>();

        TimeCheck t=new TimeCheck();
        t.execute();
    }

    public void call_itnow()
    {
        Notification_task task=new Notification_task();
        task.execute();
    }


    public class TimeCheck extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids)
        {
            String currentDateandTime="";
            while(!currentDateandTime.equals("060000")||!currentDateandTime.equals("180000"))
            {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
                currentDateandTime = sdf.format(new Date());
                Log.e("time=>", "" + currentDateandTime);
            }
            try
            {
                Log.e("time=>", "" + currentDateandTime);
                Log.e("got the time=>", "" + currentDateandTime);
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            call_itnow();

            return null;
        }
    }


    public class Notification_task extends AsyncTask<String, String,String>
    {
        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            String strDate="";
            try
            {
                DbHelper helper=new DbHelper(getApplicationContext());
                SQLiteDatabase db=helper.getWritableDatabase();
                JSONArray arr=new JSONArray(s);
                size=arr.length();
                for(int count=0;count<arr.length();count++)
                {
                    JSONObject obj=arr.getJSONObject(count);
                    String id=obj.getString("id");
                    String daten=obj.getString("date");
                    String headn = obj.getString("head");
                    String bodyn=obj.getString("body");



                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    strDate = sdf.format(cal.getTime());


                    SimpleDateFormat sdf1 = new SimpleDateFormat();
                    sdf1.applyPattern("dd/MM/yyyy");
                    Date date = sdf1.parse(daten);
                    daten=sdf1.format(date);

                    Notifications n=new Notifications();
                    n.setId(id);
                    n.setHead(headn);
                    n.setBody(bodyn);
                    n.setDate(daten);
                    if(strDate.equals(daten))
                        list.add(n);
                    Log.e("date n=>", "" + daten);
                    Log.e("title n=>", "" + headn);
                    Log.e("text n=>", "" + bodyn);
                    Log.e("size of list=>", "" + list.size());

                    if(!helper.checkNotification(db,id))
                        helper.insertNotifications(db,id,headn,bodyn,daten);
                }


                Notify(list, getApplicationContext(),strDate);
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(String... strings)
        {
            String result="";
            try
            {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://jagdishmandirujjain.in/androidcode/shreejagdishmandir.json");

                HttpResponse response = httpclient.execute(httppost);

                InputStream is = response.getEntity().getContent();
                InputStreamReader reader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(reader);
                while (true)
                {
                    String str = br.readLine();
                    if (str == null)
                        break;
                    result = result + str;
                }
                br.close();
                Log.e("nitification result=>", "" + result);
            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
            return result;
        }
    }

    private void Notify(ArrayList<Notifications> list,Context c,String strdate)
    {
        DbHelper helper=new DbHelper(getApplicationContext());
        SQLiteDatabase db=helper.getWritableDatabase();

        ArrayList<Notifications> list1=new ArrayList<>();
        list1=helper.getNotification(db, strdate);

        for(int count=0;count<list1.size();count++)
        {
            int check_flag=-1;
            for(int count1=0;count1<list.size();count1++)
            {
                if(list.get(count1).getId().equals(list1.get(count).getId()))
                {
                    check_flag=1;
                    break;
                }
                else
                    check_flag=0;
            }
            if(check_flag==0)
                list.add(list1.get(count));
        }


        Notification notification;
        Intent notificationIntent;
        PendingIntent pendingIntent;
        Notification.Builder builder;
        Log.e("size=>",""+list.size());
        for(int count=0;count<list.size();count++)
        {
            NotificationManager notificationManager = (NotificationManager) c.getSystemService(c.NOTIFICATION_SERVICE);

            //notification = new Notification(R.drawable.shh_logo,"New Message", System.currentTimeMillis());
            notificationIntent = new Intent(c,ActivityNotification.class);
            pendingIntent = PendingIntent.getActivity(c, 0,notificationIntent, 0);

            builder = new Notification.Builder(c);

            builder.setAutoCancel(true);
            builder.setTicker(list.get(count).getHead());
            builder.setVibrate(new long[]{500, 500, 500, 500, 500});
            builder.setLights(Color.RED, 3000, 3000);
            builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
            builder.setContentTitle(list.get(count).getHead());
            builder.setContentText(list.get(count).getBody());
            Bitmap largeIcon = BitmapFactory.decodeResource(c.getResources(), R.drawable.sri);
            builder.setLargeIcon(largeIcon);
            builder.setSmallIcon(R.drawable.sri);
            builder.setContentIntent(pendingIntent);
            //builder.setSubText(notificationMessage);   //API level 16
            //builder.setNumber(100);
            builder.build();

            notification = builder.getNotification();
            //manager.notify(11, myNotication);

            //notification.setLatestEventInfo(ActivityNotification.this, notificationTitle,notificationMessage, pendingIntent);
            notificationManager.notify(count+1001, notification);
        }

        TimeCheck t=new TimeCheck();
        t.execute();

    }


}
