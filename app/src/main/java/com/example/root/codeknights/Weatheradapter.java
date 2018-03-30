package com.example.root.codeknights;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by root on 3/10/18.
 */

public class Weatheradapter extends ArrayAdapter<Weather> {
    public Weatheradapter(@NonNull Context context, ArrayList<Weather> weatherArrayList) {
        super(context, 0,weatherArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Weather weather=getItem(position);

        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        TextView dateTextView=convertView.findViewById(R.id.Date);
        TextView minTextView=convertView.findViewById(R.id.temp_low);
        TextView maxTextView=convertView.findViewById(R.id.temp_high);
        TextView dayTextVew=convertView.findViewById(R.id.day_forecast_value);
        dateTextView.setText(weather.getDate());
        minTextView.setText(weather.getMintemp());
        maxTextView.setText(weather.getMaxtemp());
        dayTextVew.setText(weather.getDayforecast());


        return  convertView;
    }
}
