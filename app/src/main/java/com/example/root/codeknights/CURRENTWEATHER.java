package com.example.root.codeknights;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CURRENTWEATHER extends Fragment {
    private String temp,city,humidity,mintemp,maxtemp,weathertype;
    public static CURRENTWEATHER newInstance(String temp, String city, String humidity, String mintemp, String maxtemp, String weathertype) {
        CURRENTWEATHER fragment = new CURRENTWEATHER();
        Bundle args = new Bundle();
        args.putString("temperature", temp);
        args.putString("city", city);
        args.putString("humidity", humidity);
        args.putString("mintemp", mintemp);
        args.putString("maxtemp", maxtemp);
        args.putString("weathertype", weathertype);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        temp=getArguments().getString("temperature");
        city=getArguments().getString("city");
        humidity=getArguments().getString("humidity");
        mintemp=getArguments().getString("mintemp");
        maxtemp=getArguments().getString("maxtemp");
        weathertype=getArguments().getString("weathertype");


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_with_one_image, container, false);
        TextView TEMP =  view.findViewById(R.id.Temperature);
        TEMP.setText(temp);
        TextView CITY =  view.findViewById(R.id.City);
        CITY.setText(city);
        TextView HUMIDITY = view.findViewById(R.id.Humidity);
        HUMIDITY.setText(humidity);
        TextView DATE = view.findViewById(R.id.Date);
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-mm-yyyy");
        String formatted_date=simpleDateFormat.format(calendar.getTime());
        DATE.setText(formatted_date);
        TextView MINTEMP = view.findViewById(R.id.Mintemp);
        MINTEMP.setText(mintemp);
        TextView MAXTEMP =  view.findViewById(R.id.Maxtemp);
        MAXTEMP.setText(maxtemp);
        TextView WEATHERTYPE =  view.findViewById(R.id.Weathertype);
        WEATHERTYPE.setText(weathertype);
        return view;
    }
}
