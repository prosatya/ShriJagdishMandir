package com.matictechnology.shrijagdishmandir.Activity;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.matictechnology.shrijagdishmandir.R;
import com.matictechnology.shrijagdishmandir.Utility.DbHelper;
import com.matictechnology.shrijagdishmandir.Utility.NotificationAdapter;
import com.matictechnology.shrijagdishmandir.classes.Notifications;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ActivityNotification extends AppCompatActivity
{
    ListView noti_list;
    ArrayList<Notifications> list;

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



        list=new ArrayList<>();
        list=helper.getAllNotification(db);
        Log.e("notification","list size="+list.size());
        NotificationAdapter adapter=new NotificationAdapter(ActivityNotification.this,R.layout.item_notification,list);
        noti_list.setAdapter(adapter);

        noti_list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent in=new Intent(ActivityNotification.this,ActivityNotiMsg.class);
                in.putExtra("head", list.get(i).getHead());
                in.putExtra("body",list.get(i).getBody());
                in.putExtra("date",list.get(i).getDate());
                startActivity(in);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        Intent in=new Intent(ActivityNotification.this,ActivityMain.class);
        startActivity(in);
        finish();
    }
}
