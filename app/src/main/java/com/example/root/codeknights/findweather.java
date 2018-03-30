package com.example.root.codeknights;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by root on 3/30/18.
 */

public class findweather extends AppCompatActivity{

    public String temp,city,humidity,mintemp,maxtemp,description;
    private Context cont;

    public findweather() {

        find_weather();
    }

    private void find_weather() {
        String url="http://api.openweathermap.org/data/2.5/com.example.root.codeknights.weather?q=Chandigarh&appid=bdd499df13e9c13bc62b354be85fbd2e&units=metric";
        JsonObjectRequest jor=new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject main_object=response.getJSONObject("main");
                    JSONArray array=response.getJSONArray("com.example.root.codeknights.weather");
                    JSONObject object=array.getJSONObject(0);
                    temp=String.valueOf(main_object.getDouble("temp"));
                    description=object.getString("description");
                    city=response.getString("name");
                    humidity=String.valueOf(main_object.getInt("humidity"));
                    mintemp=String.valueOf(main_object.getDouble("temp_min"));
                    maxtemp=String.valueOf(main_object.getDouble("temp_max"));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            public void onErrorResponse (VolleyError error){

            }
        });
        cont=getApplicationContext();

        RequestQueue requestQueue= Volley.newRequestQueue(cont);
        requestQueue.add(jor);

    }

}
