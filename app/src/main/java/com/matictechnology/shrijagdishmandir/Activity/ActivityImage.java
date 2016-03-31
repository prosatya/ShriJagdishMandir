package com.matictechnology.shrijagdishmandir.Activity;

import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.matictechnology.shrijagdishmandir.R;

import java.util.ArrayList;

public class ActivityImage extends AppCompatActivity implements View.OnTouchListener
{
    private static final String TAG = "Touch";
    @SuppressWarnings("unused")
    private static final float MIN_ZOOM = 1f,MAX_ZOOM = 1f;

    // These matrices will be used to scale points of the image
    Matrix matrix = new Matrix();
    Matrix savedMatrix = new Matrix();

    // The 3 states (events) which the user is trying to perform
    static final int NONE = 0;
    static final int DRAG = 1;
    static final int ZOOM = 2;
    int mode = NONE;

    // these PointF objects are used to record the point(s) the user is touching
    PointF start = new PointF();
    PointF start1 = new PointF();
    PointF mid = new PointF();
    float oldDist = 1f;

    MotionEvent event1;


    ImageSwitcher imageSwitcher;
    ImageView myView;
    TextView p,n;
    ArrayList<Integer> image_list;
    int size,curr;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        p=(TextView)findViewById(R.id.p);
        n=(TextView)findViewById(R.id.n);

        myView=(ImageView)findViewById(R.id.image);

        AdView adView_footer = (AdView)findViewById(R.id.adView);
// Request for Ads
        AdRequest adRequest_footer = new AdRequest.Builder().build();
// Load ads into Banner Ads
        adView_footer.loadAd(adRequest_footer);


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


        p.setText("  <");
        n.setText(">  ");
        Intent in=getIntent();
        position=in.getIntExtra("position", -1);


        size=image_list.size();
        myView.setImageResource(image_list.get(position));
        curr=position;
        Log.e("current=>", "" + curr);
        Log.e("position=>", "" + position);
        myView.setOnTouchListener(this);

        Log.e("current=>", "" + curr);
        Log.e("size=>", "" + size);

        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("current=>", "" + curr);
                if (curr < size - 1)
                {
                    Log.e("current=>", "" + curr);
                    curr++;
                    myView.setImageResource(image_list.get(curr));
                    Log.e("current=>", "after change");
                    Log.e("current=>", "" + curr);
                }
                else
                {
                    Log.e("current=>", "" + curr);
                    curr=0;
                    myView.setImageResource(image_list.get(curr));
                    Log.e("current=>", "after change");
                    Log.e("current=>", "" + curr);
                }

            }
        });

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("current=>", "" + curr);
                if (curr > 0) {
                    Log.e("current=>", "" + curr);
                    curr--;
                    myView.setImageResource(image_list.get(curr));
                    Log.e("current=>", "after change");
                    Log.e("current=>", "" + curr);
                } else {
                    Log.e("current=>", "" + curr);
                    curr = size - 1;
                    myView.setImageResource(image_list.get(curr));
                    Log.e("current=>", "after change");
                    Log.e("current=>", "" + curr);
                }

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.back1));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        getActionBar().setDisplayHomeAsUpEnabled(true);


    }



    @Override
    public boolean onTouch(View view1, MotionEvent event)
    {
        if(event1==null)
            event1=event;
        ImageView view = (ImageView) view1;
        view.setScaleType(ImageView.ScaleType.MATRIX);
        float scale;

        dumpEvent(event);
        // Handle touch events here...

        switch (event.getAction() & MotionEvent.ACTION_MASK)
        {
            case MotionEvent.ACTION_DOWN:   // first finger down only
                savedMatrix.set(matrix);
                start.set(event.getX(), event.getY());
                Log.d(TAG, "mode=DRAG"); // write to LogCat
                mode = DRAG;
                break;

            case MotionEvent.ACTION_UP: // first finger lifted

            case MotionEvent.ACTION_POINTER_UP: // second finger lifted

                mode = NONE;
                Log.d(TAG, "mode=NONE");
                break;

            case MotionEvent.ACTION_POINTER_DOWN: // first and second finger down

                oldDist = spacing(event);
                Log.d(TAG, "oldDist=" + oldDist);
                if (oldDist > 5f) {
                    savedMatrix.set(matrix);
                    midPoint(mid, event);
                    mode = ZOOM;
                    Log.d(TAG, "mode=ZOOM");
                }
                break;

            case MotionEvent.ACTION_MOVE:

                if (mode == DRAG)
                {
                    matrix.set(savedMatrix);
                    matrix.postTranslate(event.getX() - start.x, event.getY() - start.y); // create the transformation in the matrix  of points
                }
                else if (mode == ZOOM)
                {
                    // pinch zooming
                    float newDist = spacing(event);
                    Log.d(TAG, "newDist=" + newDist);
                    if (newDist > 5f)
                    {
                        matrix.set(savedMatrix);
                        scale = newDist / oldDist; // setting the scaling of the
                        // matrix...if scale > 1 means
                        // zoom in...if scale < 1 means
                        // zoom out
                        matrix.postScale(scale, scale, mid.x, mid.y);
                    }
                }
                break;
        }

        view.setImageMatrix(matrix); // display the transformation on screen

        return true; // indicate event was handled
    }


    /*
     * --------------------------------------------------------------------------
     * Method: spacing Parameters: MotionEvent Returns: float Description:
     * checks the spacing between the two fingers on touch
     * ----------------------------------------------------
     */


    private float spacing(MotionEvent event)
    {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float)Math.sqrt(x * x + y * y);
    }

    /*
     * --------------------------------------------------------------------------
     * Method: midPoint Parameters: PointF object, MotionEvent Returns: void
     * Description: calculates the midpoint between the two fingers
     * ------------------------------------------------------------
     */

    private void midPoint(PointF point, MotionEvent event)
    {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }

    /** Show an event in the LogCat view, for debugging */
    private void dumpEvent(MotionEvent event)
    {
        String names[] = { "DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE","POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?" };
        StringBuilder sb = new StringBuilder();
        int action = event.getAction();
        int actionCode = action & MotionEvent.ACTION_MASK;
        sb.append("event ACTION_").append(names[actionCode]);

        if (actionCode == MotionEvent.ACTION_POINTER_DOWN || actionCode == MotionEvent.ACTION_POINTER_UP)
        {
            sb.append("(pid ").append(action >> MotionEvent.ACTION_POINTER_ID_SHIFT);
            sb.append(")");
        }

        sb.append("[");
        for (int i = 0; i < event.getPointerCount(); i++)
        {
            sb.append("#").append(i);
            sb.append("(pid ").append(event.getPointerId(i));
            sb.append(")=").append((int) event.getX(i));
            sb.append(",").append((int) event.getY(i));
            if (i + 1 < event.getPointerCount())
                sb.append(";");
        }

        sb.append("]");
        Log.d("Touch Events ---------", sb.toString());
    }


}
