package com.matictechnology.shrijagdishmandir.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.matictechnology.shrijagdishmandir.R;

public class ActivityTemple extends AppCompatActivity
{
    ImageView image;
    TextView head;
    TextView full_text;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temple);



        image=(ImageView)findViewById(R.id.image);
        head=(TextView)findViewById(R.id.head);
        full_text=(TextView)findViewById(R.id.full_text);

        AdView adView = (AdView)findViewById(R.id.adView);
// Request for Ads
        AdRequest adRequest = new AdRequest.Builder().build();
// Load ads into Banner Ads
        adView.loadAd(adRequest);

        Intent in=getIntent();
        String name=in.getStringExtra("darshan_templename");
        String text=in.getStringExtra("darshan_text_full");
        int imagenm=in.getIntExtra("darshan_imagename",-1);

        Log.e("Got..", "" + name + "," + text + "," + imagenm + "!");
        image.setImageResource(imagenm);
        head.setText(name);
        //text="<html><body><p align=\"justify\">               "+text+"</p> </body></html>";

        //full_text.loadData(text, "text/html", "utf-8");
        full_text.setText(text);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}
