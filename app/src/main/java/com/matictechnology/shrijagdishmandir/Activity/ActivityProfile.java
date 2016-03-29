package com.matictechnology.shrijagdishmandir.Activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.matictechnology.shrijagdishmandir.R;
import com.matictechnology.shrijagdishmandir.Utility.DbHelper;

import java.util.ArrayList;

public class ActivityProfile extends AppCompatActivity
{
    TextView profile_name,profile_mobile,profile_email,profile_blood,profile_village,profile_tehsil,profile_district,profile_gotra;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_name=(TextView)findViewById(R.id.profile_name);
        profile_mobile=(TextView)findViewById(R.id.profile_mobile);
        profile_email=(TextView)findViewById(R.id.profile_email);
        profile_blood=(TextView)findViewById(R.id.profile_blood);
        profile_village=(TextView)findViewById(R.id.profile_village);
        profile_tehsil=(TextView)findViewById(R.id.profile_tehsil);
        profile_district=(TextView)findViewById(R.id.profile_district);
        profile_gotra=(TextView)findViewById(R.id.profile_gotra);

        DbHelper dbhelper=new DbHelper(ActivityProfile.this);
        SQLiteDatabase db=dbhelper.getWritableDatabase();

        ArrayList<String> user_data=new ArrayList<>();
        user_data=dbhelper.selectAll(db);
        //name,email,blood,village,tehsil,district,gotra,mobile;

        profile_name.setText(user_data.get(0));
        profile_email.setText(user_data.get(1));
        profile_blood.setText(user_data.get(2));
        profile_village.setText(user_data.get(3));
        profile_tehsil.setText(user_data.get(4));
        profile_district.setText(user_data.get(5));
        profile_gotra.setText(user_data.get(6));
        profile_mobile.setText(user_data.get(7));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

}
