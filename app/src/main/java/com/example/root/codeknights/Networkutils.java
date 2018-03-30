package com.example.root.codeknights;

import android.net.Uri;
import android.nfc.Tag;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by root on 3/10/18.
 */

public class Networkutils {
    private final static String TAG="NetworksUtils";
    public static final URL buildUrlforWeather(){
        URL url=null;
        try{
            url=new URL("http://api.apixu.com/v1/forecast.json?key=e74902058c274deeadd152533181003&q=Chandigarh&days=7");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.i(TAG,"buildUrlForWeather: url:"+url);
        return url;
    }
    public static String getResponseFromUrl(URL url)throws IOException{
        HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
        try{
            InputStream in=urlConnection.getInputStream();
            Scanner scanner=new Scanner(in);
            scanner.useDelimiter("\\A");
            boolean hasInput=scanner.hasNext();
            if (hasInput){
                return scanner.next();
            }
            else{
                return null;
            }

        }
        finally {
            urlConnection.disconnect();
        }
    }

}
