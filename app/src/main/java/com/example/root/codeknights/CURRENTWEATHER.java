package com.example.root.codeknights;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CURRENTWEATHER extends Fragment {
    private String temp,city,humidity,mintemp,maxtemp,weathertype;
    TextView TEMP,CITY,HUMIDITY,DATE,MINTEMP,MAXTEMP,WEATHERTYPE;
    public static CURRENTWEATHER newInstance() {
        CURRENTWEATHER fragment = new CURRENTWEATHER();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*temp=getArguments().getString("temperature");
        city=getArguments().getString("city");
        humidity=getArguments().getString("humidity");
        mintemp=getArguments().getString("mintemp");
        maxtemp=getArguments().getString("maxtemp");
        weathertype=getArguments().getString("weathertype");*/


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_with_one_image, container, false);

        find_weather();
         TEMP =  view.findViewById(R.id.Temperature);

         CITY =  view.findViewById(R.id.City);

         HUMIDITY = view.findViewById(R.id.Humidity);

         DATE = view.findViewById(R.id.Date);

         MINTEMP = view.findViewById(R.id.Mintemp);

         MAXTEMP =  view.findViewById(R.id.Maxtemp);

         WEATHERTYPE =  view.findViewById(R.id.Weathertype);

        return view;
    }

    private void find_weather() {
        String url="http://api.openweathermap.org/data/2.5/weather?q=Chandigarh&appid=bdd499df13e9c13bc62b354be85fbd2e&units=metric";
        JsonObjectRequest jor=new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject main_object=response.getJSONObject("main");
                    JSONArray array=response.getJSONArray("weather");
                    JSONObject object=array.getJSONObject(0);
                    temp=String.valueOf(main_object.getDouble("temp"));
                    weathertype=object.getString("description");
                    city=response.getString("name");
                    humidity=String.valueOf(main_object.getInt("humidity"));
                    mintemp=String.valueOf(main_object.getDouble("temp_min"));
                    maxtemp=String.valueOf(main_object.getDouble("temp_max"));
                    setUI();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            public void onErrorResponse (VolleyError error){

            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        requestQueue.add(jor);

    }

    private void setUI() {
        TEMP.setText(temp);
        CITY.setText(city);
        HUMIDITY.setText(humidity);
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-mm-yyyy");
        String formatted_date=simpleDateFormat.format(calendar.getTime());
        DATE.setText(formatted_date);
        MINTEMP.setText(mintemp);
        MAXTEMP.setText(maxtemp);
        WEATHERTYPE.setText(weathertype);
    }
}
