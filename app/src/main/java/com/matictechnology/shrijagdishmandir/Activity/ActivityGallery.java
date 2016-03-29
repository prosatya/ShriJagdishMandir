package com.matictechnology.shrijagdishmandir.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.matictechnology.shrijagdishmandir.R;
import com.matictechnology.shrijagdishmandir.Utility.ImageAdapter;

public class ActivityGallery extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        AdView adView_footer = (AdView)findViewById(R.id.adView);
// Request for Ads
        AdRequest adRequest_footer = new AdRequest.Builder().build();
// Load ads into Banner Ads
        adView_footer.loadAd(adRequest_footer);


        GridView gridview = (GridView)findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(ActivityGallery.this));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}
