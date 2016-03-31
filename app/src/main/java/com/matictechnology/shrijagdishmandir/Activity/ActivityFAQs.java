package com.matictechnology.shrijagdishmandir.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;

import com.matictechnology.shrijagdishmandir.R;
import com.matictechnology.shrijagdishmandir.Utility.AnimatorUtils;
import com.matictechnology.shrijagdishmandir.Utility.ClipRevealFrame;
import com.matictechnology.shrijagdishmandir.Utility.DbHelper;
import com.ogaclejapan.arclayout.ArcLayout;

import java.util.ArrayList;
import java.util.List;

public class ActivityFAQs extends AppCompatActivity implements View.OnClickListener
{
    int pause_flag=-1;  //for fab hide and show on pause and resume of activity
    View rootLayout;    //layout to show fab on
    ClipRevealFrame menuLayout;     //hidden full fab menu
    ArcLayout arcLayout;    //  fab menu buttons
    View centerItem;        //fab center button
    int x;  //x coordinate on the layout to show and hide fab menu buttons
    int y;  //y coordinate on the layout to show and hide fab menu buttons
    float radiusOfFab;  //radius of fab
    float radiusFromFabToRoot;  //radius for hiding and showing the fab full menu
    int center_item_flag=-1;    //flag variable to check for two buttons on center fab full menu button
    Button center_item; //fab full menu center button
    String ci;  //string for the center button of fab full menu
    DbHelper dbhelper;  //Database helper class for storing and accessing the data
    SQLiteDatabase db;  //SQLiteDatabase object to gain read or write access to the DB
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rootLayout = findViewById(R.id.rootlayout);
        menuLayout = (ClipRevealFrame) findViewById(R.id.menu_layout);
        arcLayout = (ArcLayout) findViewById(R.id.arc_layout);
        centerItem = findViewById(R.id.center_item);
        center_item= (Button)findViewById(R.id.center_item);
        //initializing all the required elements from the xml to use them in the java class

        centerItem.setOnClickListener(this);

        DbHelper dbhelper = new DbHelper(ActivityFAQs.this);
        //initialising dh helper class
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        //getting write acces to the database

        //checking for user registration
        if(dbhelper.Login(db))
        {
            //if done show contact us fab center button
            center_item_flag=1;
            ci="Contact Us";
            center_item.setText(ci);
            Log.e("login check","logged in");
            //catlog message to show the current status of user login
        }
        else
        {
            //if not done show register fab center button
            center_item_flag=0;
            ci="Register";
            center_item.setText(ci);
            Log.e("login check", "not logged in");

            //catlog message to show the current status of user login
        }


        //on click listener for fab full menu center button

        for (int i = 0, size = arcLayout.getChildCount(); i < size; i++)
            arcLayout.getChildAt(i).setOnClickListener(this);
        //setting onclick listener for all the fab full menu buttons other then center button

        findViewById(R.id.fab).setOnClickListener(this);
        //onclick listener for fab

    }


    @Override
    public void onClick(View v)
    {
        //setting on click operation for all the click buttons

        if (v.getId() == R.id.fab)
        {
            //fab button
            onFabClick(v);
            return;
        }

        if (v.getId() == R.id.ujjain)
        {
            //starting ujjain activity
            Intent in=new Intent(ActivityFAQs.this, ActivityUjjain.class);
            startActivity(in);

        }
        if (v.getId() == R.id.haridwar)
        {
            //starting haridwar activity
            Intent in=new Intent(ActivityFAQs.this,ActivityHaridwar.class);
            startActivity(in);

        }
        if (v.getId() == R.id.bhopal)
        {
            //starting bhopal activity
            Intent in=new Intent(ActivityFAQs.this, ActivityBhopal.class);
            startActivity(in);


        }
        if (v.getId() == R.id.awlighat)
        {
            //starting awlighat activity
            Intent in=new Intent(ActivityFAQs.this,ActivityAvlighat.class);
            startActivity(in);

        }
        if (v.getId() == R.id.omkareshwar)
        {
            //starting omkareshwar activity
            Intent in=new Intent(ActivityFAQs.this,ActivityOmkareshwar.class);
            startActivity(in);

        }
        if (v.getId() == R.id.center_item)
        {
            //checking for the current status flag
            if(center_item_flag==1)
            {
                //starting contact us
                Intent in=new Intent(ActivityFAQs.this,ActivityContactUs.class);
                startActivity(in);

            }
            else if(center_item_flag==0)
            {
                //starting registration page
                Intent in=new Intent(ActivityFAQs.this,ActivityRegister.class);
                startActivity(in);
            }
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        //setting the flag for fab hide and close management
        pause_flag=1;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        //checking the current activity state and hiding the open fab full menu
        if(pause_flag==1)
            hideMenu(x, y, radiusFromFabToRoot, radiusOfFab);
    }

    private void onFabClick(View v)
    {
        //controlling fab button click operation
        dbhelper = new DbHelper(ActivityFAQs.this);
        db = dbhelper.getWritableDatabase();
        //getting the write access for the DB

        //checking for registered status of user
        if(dbhelper.Login(db))
        {
            //setting the the fab full menu center button to contact us
            center_item_flag=1;
            ci="Contact Us";
            center_item.setText(ci);
            Log.e("login check", "logged in");
        }
        else
        {
            //setting the the fab full menu center button to Register
            center_item_flag=0;
            ci="Register";
            center_item.setText(ci);
            Log.e("login check", "not logged in");
        }

        //setting x and y coordinates for fab full menu
        x = (v.getLeft() + v.getRight()) / 2;
        y = (v.getTop() + v.getBottom()) / 2;
        radiusOfFab = 1f * v.getWidth() / 2f;
        radiusFromFabToRoot = (float) Math.hypot(
                Math.max(x, rootLayout.getWidth() - x),
                Math.max(y, rootLayout.getHeight() - y));

        //checking for the select operation and hiding and showing the menu accordingly
        if (v.isSelected())
        {
            hideMenu(x, y, radiusFromFabToRoot, radiusOfFab);
        }
        else
        {
            showMenu(x, y, radiusOfFab, radiusFromFabToRoot);
        }
        v.setSelected(!v.isSelected());
    }

    private void showMenu(int cx, int cy, float startRadius, float endRadius)
    {
        //showing the hidden fab full menu
        menuLayout.setVisibility(View.VISIBLE);

        List<Animator> animList = new ArrayList<>();

        //creating animation for showing fab full menu
        Animator revealAnim = createCircularReveal(menuLayout, cx, cy, startRadius, endRadius);
        revealAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        revealAnim.setDuration(200);

        animList.add(revealAnim);
        animList.add(createShowItemAnimator(centerItem));

        for (int i = 0, len = arcLayout.getChildCount(); i < len; i++)
            animList.add(createShowItemAnimator(arcLayout.getChildAt(i)));

        AnimatorSet animSet = new AnimatorSet();
        animSet.playSequentially(animList);
        animSet.start();
    }

    private Animator createShowItemAnimator(View item)
    {
        //method to show animation for the fab full menu items
        float dx = centerItem.getX() - item.getX();
        float dy = centerItem.getY() - item.getY();

        item.setScaleX(0f);
        item.setScaleY(0f);
        item.setTranslationX(dx);
        item.setTranslationY(dy);

        Animator anim = ObjectAnimator.ofPropertyValuesHolder(
                item,
                AnimatorUtils.scaleX(0f, 1f),
                AnimatorUtils.scaleY(0f, 1f),
                AnimatorUtils.translationX(dx, 0f),
                AnimatorUtils.translationY(dy, 0f)
        );

        anim.setInterpolator(new DecelerateInterpolator());
        anim.setDuration(50);
        return anim;
    }

    private void hideMenu(int cx, int cy, float startRadius, float endRadius)
    {
        //hide fab full menu method
        List<Animator> animList = new ArrayList<>();

        for (int i = arcLayout.getChildCount() - 1; i >= 0; i--)
            animList.add(createHideItemAnimator(arcLayout.getChildAt(i)));

        animList.add(createHideItemAnimator(centerItem));

        Animator revealAnim = createCircularReveal(menuLayout, cx, cy, startRadius, endRadius);
        revealAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        revealAnim.setDuration(200);
        revealAnim.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                super.onAnimationEnd(animation);
                menuLayout.setVisibility(View.INVISIBLE);
            }
        });

        animList.add(revealAnim);

        AnimatorSet animSet = new AnimatorSet();
        animSet.playSequentially(animList);
        animSet.start();

    }

    private Animator createHideItemAnimator(final View item)
    {
        //creating hide fab full menu animation
        final float dx = centerItem.getX() - item.getX();
        final float dy = centerItem.getY() - item.getY();

        Animator anim = ObjectAnimator.ofPropertyValuesHolder(
                item,
                AnimatorUtils.scaleX(1f, 0f),
                AnimatorUtils.scaleY(1f, 0f),
                AnimatorUtils.translationX(0f, dx),
                AnimatorUtils.translationY(0f, dy)
        );

        anim.setInterpolator(new DecelerateInterpolator());
        anim.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                super.onAnimationEnd(animation);
                item.setTranslationX(0f);
                item.setTranslationY(0f);
            }
        });
        anim.setDuration(50);
        return anim;
    }

    private Animator createCircularReveal(final ClipRevealFrame view, int x, int y, float startRadius,float endRadius)
    {
        //method creating circular movement in animation of fab full menu
        final Animator reveal;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            reveal = ViewAnimationUtils.createCircularReveal(view, x, y, startRadius, endRadius);
        }
        else
        {
            view.setClipOutLines(true);
            view.setClipCenter(x, y);
            reveal = ObjectAnimator.ofFloat(view, "ClipRadius", startRadius, endRadius);
            reveal.addListener(new Animator.AnimatorListener()
            {
                @Override
                public void onAnimationStart(Animator animation)
                {

                }

                @Override
                public void onAnimationEnd(Animator animation)
                {
                    view.setClipOutLines(false);

                }

                @Override
                public void onAnimationCancel(Animator animation)
                {

                }

                @Override
                public void onAnimationRepeat(Animator animation)
                {

                }
            });
        }
        return reveal;
    }
}
