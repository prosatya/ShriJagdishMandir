package com.matictechnology.shrijagdishmandir.Utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.matictechnology.shrijagdishmandir.R;

import java.util.ArrayList;

/**
 * Created by maticd1 on 17/3/16.
 */
public class GhatListAdapter extends ArrayAdapter<String>
{
    Context context;
    ArrayList<String> darshan_templename=new ArrayList<>();
    ArrayList<String> darshan_text=new ArrayList<>();
    ArrayList<Integer> darshan_imagename=new ArrayList<>();

    public GhatListAdapter(Context c, int resource, ArrayList<String> templename, ArrayList<String> text, ArrayList<Integer> imagename)
    {
        super(c, resource, templename);
        context=c;
        darshan_templename=templename;
        darshan_text=text;
        darshan_imagename=imagename;
    }

    public View getView(final int position,View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View itemView=inflater.inflate(R.layout.item_ghat, null);

        ImageView darshan_image=(ImageView)itemView.findViewById(R.id.darshan_image);
        TextView darshan_head=(TextView)itemView.findViewById(R.id.darshan_head);
        TextView darshan_text1=(TextView)itemView.findViewById(R.id.darshan_text);

        darshan_image.setImageResource(darshan_imagename.get(position));
        darshan_head.setText(darshan_templename.get(position));
        darshan_text1.setText(darshan_text.get(position));

        return itemView;
    }

}
