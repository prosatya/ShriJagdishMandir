package com.matictechnology.shrijagdishmandir.Activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;
import com.matictechnology.shrijagdishmandir.R;
import com.matictechnology.shrijagdishmandir.Utility.DbHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ActivityNotification extends AppCompatActivity
{
    ListView noti_list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        noti_list=(ListView)findViewById(R.id.noti_list);
        DbHelper helper=new DbHelper(ActivityNotification.this);
        SQLiteDatabase db=helper.getWritableDatabase();

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());

        helper.getNotification(db,formattedDate);
    }
}
