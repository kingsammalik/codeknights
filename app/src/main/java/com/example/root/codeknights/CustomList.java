package com.example.root.codeknights;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by root on 3/20/18.
 */

public class CustomList extends ArrayAdapter<String> {
    private final Context context;
    private final String crop;
    private final Integer imageId;
    public CustomList(Context context, String crop, int imageId) {
        super(context,0);
        //super(context,0,crop,imageId);
        this.context = context;
        this.crop = crop;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        //LayoutInflater inflater = context.getLayoutInflater();
        View rowView= LayoutInflater.from(context).inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        //txtTitle.setText(crop[position]);

        //imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
