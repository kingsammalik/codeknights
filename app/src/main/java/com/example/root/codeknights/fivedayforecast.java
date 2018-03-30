package com.example.root.codeknights;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class fivedayforecast extends AppCompatActivity {
    private static final String TAG=fivedayforecast.class.getSimpleName();
    private ArrayList<Weather> weatherArrayList=new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fivedayforecast);
        listView= (ListView) findViewById(R.id.idlistview);
        URL weatherUrl=Networkutils.buildUrlforWeather();
        new FetchWeatherDetails().execute(weatherUrl);
        Log.i(TAG,"onCreate: weatherUrl:"+weatherUrl);


    }
    private class FetchWeatherDetails extends AsyncTask<URL,Void,String>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL weatherUrl=urls[0];
            String weatherSearchResults=null;
            try {
                weatherSearchResults=Networkutils.getResponseFromUrl(weatherUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.i(TAG,"doInBackground: weatherSearchResults:"+weatherSearchResults);
            return weatherSearchResults;
        }

        @Override
        protected void onPostExecute(String weatherSearchResults) {
            if (weatherSearchResults !=null && !weatherSearchResults.equals(""))    {
            weatherArrayList=parseJSON(weatherSearchResults);
            }

            super.onPostExecute(weatherSearchResults);
        }
    }

    private ArrayList<Weather> parseJSON(String weatherSearchResults) {
        if (weatherArrayList!=null){
            weatherArrayList.clear();
        }
        if (weatherSearchResults!=null){
            try{
                JSONObject rootObject= new JSONObject(weatherSearchResults);
                /*JSONArray results= rootObject.getJSONArray("DailyForecasts");*/
                JSONObject results1=rootObject.getJSONObject("forecast");
                JSONArray results=results1.getJSONArray("forecastday");
                for (int i=0;i<results.length();i++){
                    Weather weather=new Weather();
                    JSONObject resultObj=results.getJSONObject(i);
                    String date=resultObj.getString("date");
                    weather.setDate(date);
                    Log.i(TAG,"parseJSON:date:"+date);
                    JSONObject temperatureObj=resultObj.getJSONObject("day");
                    String minTemperature=temperatureObj.getString("mintemp_c");
                    weather.setMintemp(minTemperature);
                    String maxTemperature=temperatureObj.getString("maxtemp_c");
                    weather.setMaxtemp(maxTemperature);
                    JSONObject dayObj=resultObj.getJSONObject("day");
                    String day=dayObj.getJSONObject("condition").getString("text");
                    weather.setDayforecast(day);
                    weatherArrayList.add(weather);


                }
                if (weatherArrayList!=null){
                    Weatheradapter weatheradapter=new Weatheradapter(this,weatherArrayList);
                    listView.setAdapter(weatheradapter);

                }
                return weatherArrayList;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
