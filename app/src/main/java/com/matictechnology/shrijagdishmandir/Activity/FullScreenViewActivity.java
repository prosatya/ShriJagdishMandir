package com.matictechnology.shrijagdishmandir.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.matictechnology.shrijagdishmandir.R;
import com.matictechnology.shrijagdishmandir.Utility.FullScreenImageAdapter;
import com.matictechnology.shrijagdishmandir.Utility.Utils;

import java.util.ArrayList;

public class FullScreenViewActivity extends Activity
{

	ArrayList<Integer> image_list;//=new ArrayList<>();
	private Utils utils;
	private FullScreenImageAdapter adapter;
	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fullscreen_view);

		viewPager = (ViewPager) findViewById(R.id.pager);

		utils = new Utils(getApplicationContext());

		image_list=new ArrayList<>();

		image_list=new ArrayList<>();
		image_list.add(R.drawable.haridwar1);
		image_list.add(R.drawable.haridwar);
		image_list.add(R.drawable.haridwar2);
		image_list.add(R.drawable.omkareshwar);
		image_list.add(R.drawable.omkareshwar1);
		image_list.add(R.drawable.omkareshwar3);
		image_list.add(R.drawable.omkareshwar2);
		image_list.add(R.drawable.ujjain1);
		image_list.add(R.drawable.ujjain2);
		image_list.add(R.drawable.ujjain3);
		image_list.add(R.drawable.ujjain4);
		image_list.add(R.drawable.ujjain5);
		image_list.add(R.drawable.ujjain6);
		image_list.add(R.drawable.ujjain5);
		image_list.add(R.drawable.ujjain6);
		image_list.add(R.drawable.ujjain7);
		image_list.add(R.drawable.ujjain8);
		image_list.add(R.drawable.ujjain9);
		image_list.add(R.drawable.awalighat);
		image_list.add(R.drawable.bhopal);
		image_list.add(R.drawable.jagdishmandir);

		Intent i = getIntent();
		int position = i.getIntExtra("position", 0);

		adapter = new FullScreenImageAdapter(FullScreenViewActivity.this,
				image_list);

		viewPager.setAdapter(adapter);

		// displaying selected image first
		viewPager.setCurrentItem(position);
	}
}
