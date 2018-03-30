package com.example.root.codeknights;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by root on 3/10/18.
 */

public class Weatheradapter extends ArrayAdapter<Weather> {

    private Context context;

    public Weatheradapter(@NonNull Context context, ArrayList<Weather> weatherArrayList) {
        super(context, 0,weatherArrayList);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Weather weather=getItem(position);

        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        TextView dateTextView=convertView.findViewById(R.id.Date);
        TextView minTextView=convertView.findViewById(R.id.low_value);
        TextView maxTextView=convertView.findViewById(R.id.high_value);
        ImageView weatherstatus=convertView.findViewById(R.id.weatherstatus);
        dateTextView.setText(weather.getDate());
        minTextView.setText(weather.getMintemp());
        maxTextView.setText(weather.getMaxtemp());

            Picasso.with(context).load("http:"+weather.getDayforecast()).into(weatherstatus);


        return  convertView;
    }
}
