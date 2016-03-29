package com.matictechnology.shrijagdishmandir.Activity;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by maticd1 on 22/3/16.
 */
public class TimeCheckService extends Service
{
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.e("Service:","Started");

        return super.onStartCommand(intent, flags, startId);
    }

    public class timecheck extends AsyncTask<String ,String,String>
    {

        @Override
        protected String doInBackground(String... strings)
        {
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
            Date currentLocalTime = cal.getTime();
            DateFormat date = new SimpleDateFormat("HH:mm");
// you can get seconds by adding  "...:ss" to it
            date.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));

            String localTime = date.format(currentLocalTime);

            if(localTime.equals("18:02"))
            {

            }
                Log.e("local time=>", "" + localTime);
            return null;
        }
    }




}
