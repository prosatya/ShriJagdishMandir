package com.matictechnology.shrijagdishmandir.Utility;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.matictechnology.shrijagdishmandir.R;
import com.matictechnology.shrijagdishmandir.classes.ImageItem;

import java.util.ArrayList;

/**
 * Created by maticd1 on 29/3/16.
 */
public class GridViewAdapter extends ArrayAdapter
{
    private Context context;
    private int layoutResourceId;
    private ArrayList<Integer> data = new ArrayList<>();

    public GridViewAdapter(Context context, int layoutResourceId, ArrayList<Integer> data)
    {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Log.e("size of list=>",""+data.size());

        View row = convertView;
        ViewHolder holder = null;

        if (row == null)
        {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) row.findViewById(R.id.image);
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }

        //ImageItem item =
        holder.image.setImageResource(data.get(position));//ImageBitmap(data.get(position));
        return row;
    }

    static class ViewHolder {
        ImageView image;
    }
}