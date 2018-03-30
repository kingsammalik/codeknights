package com.example.root.codeknights;

/**
 * Created by root on 3/10/18.
 */

public class Weather {
    String date;
    String mintemp;
    String maxtemp;
    String dayforecast;
    String nightforecast;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMintemp() {
        return mintemp;
    }

    public void setMintemp(String mintemp) {
        this.mintemp = mintemp;
    }

    public String getMaxtemp() {
        return maxtemp;
    }

    public void setMaxtemp(String maxtemp) {
        this.maxtemp = maxtemp;
    }

    public String getDayforecast() {
        return dayforecast;
    }

    public void setDayforecast(String dayforecast) {
        this.dayforecast = dayforecast;
    }

    public String getNightforecast() {
        return nightforecast;
    }

    public void setNightforecast(String nightforecast) {
        this.nightforecast = nightforecast;
    }
}
