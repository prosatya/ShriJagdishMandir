package com.matictechnology.shrijagdishmandir.Activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.matictechnology.shrijagdishmandir.R;
import com.matictechnology.shrijagdishmandir.Utility.GridViewAdapter;
import com.matictechnology.shrijagdishmandir.Utility.ImageAdapter;
import com.matictechnology.shrijagdishmandir.classes.ImageItem;

import java.util.ArrayList;

public class ActivityGallery extends AppCompatActivity
{
    ArrayList<Integer> image_list;
    private GridView gridView;
    private GridViewAdapter gridAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        gridView = (GridView) findViewById(R.id.gridview);

        image_list=new ArrayList<>();
        image_list.add(R.drawable.haridwar1_thumb);
        image_list.add(R.drawable.haridwar);
        image_list.add(R.drawable.haridwar2_thumb);
        image_list.add(R.drawable.omkareshwar);
        image_list.add(R.drawable.omkareshwar1_thumb);
        image_list.add(R.drawable.omkareshwar3_thumb);
        image_list.add(R.drawable.omkareshwar2_thumb);
        image_list.add(R.drawable.ujjain1_thumb);
        image_list.add(R.drawable.ujjain2_thumb);
        image_list.add(R.drawable.ujjain3_thumb);
        image_list.add(R.drawable.ujjain4_thumb);
        image_list.add(R.drawable.ujjain5_thumb);
        image_list.add(R.drawable.ujjain6_thumb);
        image_list.add(R.drawable.ujjain5_thumb);
        image_list.add(R.drawable.ujjain6_thumb);
        image_list.add(R.drawable.ujjain7_thumb);
        image_list.add(R.drawable.ujjain8_thumb);
        image_list.add(R.drawable.ujjain9_thumb);
        image_list.add(R.drawable.awalighat);
        image_list.add(R.drawable.bhopal);
        image_list.add(R.drawable.jagdishmandir_thumb);

        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, image_list);

        gridView.setAdapter(gridAdapter);

        AdView adView_footer = (AdView)findViewById(R.id.adView);
// Request for Ads
        AdRequest adRequest_footer = new AdRequest.Builder().build();
// Load ads into Banner Ads
        adView_footer.loadAd(adRequest_footer);


        //GridView gridview = (GridView)findViewById(R.id.gridview);
        //gridview.setAdapter(new ImageAdapter(ActivityGallery.this));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                //Create intent
                Intent in = new Intent(ActivityGallery.this, FullScreenViewActivity.class);
                in.putExtra("position", position);
                startActivity(in);
            }
        });


    }
    private ArrayList<ImageItem> getData()
    {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++)
        {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + i));
        }
        return imageItems;
    }

}
