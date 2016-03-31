package com.matictechnology.shrijagdishmandir.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.matictechnology.shrijagdishmandir.R;

public class ActivityNotiMsg extends AppCompatActivity
{
    TextView head,body,date;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti_msg);

        head=(TextView)findViewById(R.id.head);
        body=(TextView)findViewById(R.id.body);
        date=(TextView)findViewById(R.id.date);

        Intent in=getIntent();
        head.setText(in.getStringExtra("head"));
        body.setText(in.getStringExtra("body"));
        date.setText(in.getStringExtra("date"));


    }
}
