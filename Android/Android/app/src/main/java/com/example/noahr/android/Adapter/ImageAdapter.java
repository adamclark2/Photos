package com.example.noahr.android.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.noahr.android.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noahr on 3/16/2018.
 */

public class ImageAdapter extends BaseAdapter {

    private ArrayList<String> urls;
    private Context mContext;
    private static LayoutInflater inflater = null;

    public ImageAdapter(Context c, ArrayList<String> urlList) {
        this.mContext = c;
        this.urls = urlList;
        inflater = ( LayoutInflater)mContext.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return urls.size();
    }

    public Bitmap getItem(int position) {

        return null;
    }

    public long getItemId(int position) {

        return position;
    }

    /*
        Class to contain UI elements to be displayed
     */
    public class Holder
    {
        TextView sender;
        ImageView imgV;
        Button button;
    }

    /*
        create a new ImageView for each item referenced by the Adapter
    */
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder = new Holder();
        View rowV;

        rowV = inflater.inflate(R.layout.scroll_row, null);
        holder.sender = rowV.findViewById(R.id.captionXML);
        holder.imgV = rowV.findViewById(R.id.imgXML);
        System.out.println(urls.get(position));
        Picasso.get()
                .load(urls.get(position))
                .into(holder.imgV);

        holder.sender.setText("AnimeBoi247");
        holder.button = rowV.findViewById(R.id.voteButton);
        holder.button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO!
            }
        });
        return rowV;
    }
}
