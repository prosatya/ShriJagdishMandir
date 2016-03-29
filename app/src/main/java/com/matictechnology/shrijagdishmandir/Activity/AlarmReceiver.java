package com.matictechnology.shrijagdishmandir.Activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.matictechnology.shrijagdishmandir.R;
import com.matictechnology.shrijagdishmandir.Utility.DbHelper;

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
import java.util.Calendar;
import java.util.Date;

/**
 * Created by maticd1 on 22/3/16.
 */
public class AlarmReceiver extends BroadcastReceiver
{
    Context c;
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.e("called alarm.....","in alarm......");
        c=context;

        Notification_task task=new Notification_task();
        task.execute();
    }
    private void Notify(String notificationTitle, String notificationMessage,Context c)
    {
        NotificationManager notificationManager = (NotificationManager) c.getSystemService(c.NOTIFICATION_SERVICE);
        @SuppressWarnings("deprecation")

        Notification notification = new Notification(R.drawable.shh_logo,"New Message", System.currentTimeMillis());
        Intent notificationIntent = new Intent(c,ActivityNotification.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(c, 0,notificationIntent, 0);

        Notification.Builder builder = new Notification.Builder(c);

        builder.setAutoCancel(true);
        builder.setTicker(notificationTitle);
        builder.setVibrate(new long[]{500, 500, 500, 500, 500});
        builder.setLights(Color.RED, 3000, 3000);
        builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
        builder.setContentTitle(notificationTitle);
        builder.setContentText(notificationMessage);
        builder.setSmallIcon(R.drawable.sri);
        builder.setContentIntent(pendingIntent);
        //builder.setSubText(notificationMessage);   //API level 16
        //builder.setNumber(100);
        builder.build();

        notification = builder.getNotification();
        //manager.notify(11, myNotication);

        //notification.setLatestEventInfo(ActivityNotification.this, notificationTitle,notificationMessage, pendingIntent);
        notificationManager.notify(9999, notification);
    }

    public class Notification_task extends AsyncTask<String, String,String>
    {
        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            try
            {
                DbHelper helper=new DbHelper(c);
                SQLiteDatabase db=helper.getWritableDatabase();
                JSONArray arr=new JSONArray(s);
                for(int count=1;count<arr.length();count++)
                {
                    JSONObject obj=arr.getJSONObject(count);
                    String id=obj.getString("id");
                    String daten=obj.getString("date");
                    String headn = obj.getString("head");
                    String bodyn=obj.getString("body");

                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    String strDate = sdf.format(cal.getTime());

                    SimpleDateFormat sdf1 = new SimpleDateFormat();
                    sdf1.applyPattern("dd/MM/yyyy");
                    Date date = sdf1.parse(daten);
                    daten=sdf1.format(date);
                    Log.e("date n=>",""+daten);
                    Log.e("title n=>", "" + headn);
                    Log.e("text n=>", "" + bodyn);
                    Notify(headn, bodyn, c);
                    if(helper.checkNotification(db,id))
                        helper.insertNotifications(db,id,headn,bodyn,daten);
                }
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

}
