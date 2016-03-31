package com.matictechnology.shrijagdishmandir.Utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.matictechnology.shrijagdishmandir.R;
import com.matictechnology.shrijagdishmandir.classes.Notifications;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maticd1 on 30/3/16.
 */
public class NotificationAdapter extends ArrayAdapter<Notifications>
{
    Context c;
    ArrayList<Notifications> list;
    public NotificationAdapter(Context context, int resource, ArrayList<Notifications> objects)
    {
        super(context, resource, objects);
        this.c=context;
        list=new ArrayList<>();
        this.list=objects;
    }

    public View getView(final int position,View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View itemView=inflater.inflate(R.layout.item_notification, null);

        TextView head=(TextView)itemView.findViewById(R.id.head);
        TextView body=(TextView)itemView.findViewById(R.id.body);
        TextView date=(TextView)itemView.findViewById(R.id.date);


        head.setText(list.get(position).getHead());
        body.setText(list.get(position).getBody());
        date.setText(list.get(position).getDate());

        return itemView;
    }
}
