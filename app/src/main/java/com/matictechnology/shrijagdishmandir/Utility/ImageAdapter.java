package com.matictechnology.shrijagdishmandir.Utility;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.matictechnology.shrijagdishmandir.Activity.FullScreenViewActivity;
import com.matictechnology.shrijagdishmandir.R;

import java.util.ArrayList;

/**
 * Created by maticd1 on 16/3/16.
 */
public class ImageAdapter extends BaseAdapter
{
    ArrayList<Integer> image_list;

    private Context mContext;
    public int getCount()
    {
        return mThumbIds.length;
    }
    public Object getItem(int position)
    {
        return mThumbIds[position];
    }
    public long getItemId(int position)
    {
        return 0;
    }
    public ImageAdapter(Context c)
    {
        mContext = c;
        image_list=new ArrayList<>();
        image_list.add(R.drawable.haridwar1);
        image_list.add(R.drawable.haridwar2);
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

    }

    public View getView(final int position, View convertView, ViewGroup parent)
    {
        ImageView imageView;
        if (convertView == null)
        {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(155, 155));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(2, 2, 2, 2);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        final int temp=position;

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View itemView_select = inflater.inflate(R.layout.dialog_image, null);

                ImageView image = (ImageView) itemView_select.findViewById(R.id.image);
                image.setImageResource(mThumbIds[temp]);

                imageDialog=new MaterialDialog(mContext)
                        .setTitle("Gallery")
                        .setView(itemView_select )
                        .setPositiveButton("Close", new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View view)
                            {
                                imageDialog.dismiss();
                            }
                        });

                imageDialog.show();*/

                Log.e("in adapter", "in on click");

                Intent in = new Intent(mContext, FullScreenViewActivity.class);
                in.putExtra("position", temp);
                mContext.startActivity(in);
            }
        });

        return imageView;
    }

    private Integer[] mThumbIds =
    {
        R.drawable.haridwar1_thumb,
        R.drawable.haridwar2_thumb,
        R.drawable.omkareshwar1_thumb,
        R.drawable.omkareshwar3_thumb,
        R.drawable.omkareshwar2_thumb,
        R.drawable.ujjain1_thumb,
        R.drawable.ujjain2_thumb,
        R.drawable.ujjain3_thumb,
        R.drawable.ujjain4_thumb,
        R.drawable.ujjain5_thumb,
        R.drawable.ujjain6_thumb,
        R.drawable.ujjain5_thumb,
        R.drawable.ujjain6_thumb,
        R.drawable.ujjain7_thumb,
        R.drawable.ujjain8_thumb,
        R.drawable.ujjain9_thumb
    };
}
