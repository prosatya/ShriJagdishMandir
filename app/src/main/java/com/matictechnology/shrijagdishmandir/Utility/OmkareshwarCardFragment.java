package com.matictechnology.shrijagdishmandir.Utility;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.matictechnology.shrijagdishmandir.Activity.ActivityTemple;
import com.matictechnology.shrijagdishmandir.R;

import java.util.ArrayList;

/**
 * Created by maticd1 on 19/3/16.
 */
public class OmkareshwarCardFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    ArrayList<String> darshan_templename,darshan_text,darshan_text_full;
    ArrayList<Integer> darshan_imagename,darshan_imagename1;

    ArrayList<String> ghat_name,ghat_text,ghat_text_full;
    ArrayList<Integer> ghat_imagename,ghat_imagename1;

    TextView page_text;
    ListView darshan_list;


    private int position;

    public static OmkareshwarCardFragment newInstance(int position) {
        OmkareshwarCardFragment f = new OmkareshwarCardFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        LayoutInflater inflater1 = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View itemView1=null;
        if(position==0)
        {
            itemView1=inflater1.inflate(R.layout.pager_omkareshwar1, null);

            AdView adView = (AdView)itemView1.findViewById(R.id.adView);
// Request for Ads
            AdRequest adRequest = new AdRequest.Builder().build();
// Load ads into Banner Ads
            adView.loadAd(adRequest);

            //GridView gridview = (GridView)itemView1.findViewById(R.id.gridview);
            //gridview.setAdapter(new ImageAdapter(getContext()));
        }
        else if(position==1)
        {

        }
        else if(position==2)
        {

        }
        else if(position==3)
        {
        }


        return itemView1;
    }

}