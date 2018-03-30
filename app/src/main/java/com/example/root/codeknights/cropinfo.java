package com.example.root.codeknights;

import java.io.Serializable;

/**
 * Created by root on 3/13/18.
 */

public class cropinfo implements Serializable {
    private String Harvesting;
    private String Maxph;
    private String Maxrain;
    private String Maxtemp;
    private String Minrain;
    private String Mintemp;
    private String Soiltype;
    private String Price;

    public cropinfo() {
    }

    public String getHarvesting() {
        return Harvesting;
    }

    public void setHarvesting(String harvesting) {
        Harvesting = harvesting;
    }

    public String getMaxph() {
        return Maxph;
    }

    public void setMaxph(String maxph) {
        Maxph = maxph;
    }

    public String getMaxrain() {
        return Maxrain;
    }

    public void setMaxrain(String maxrain) {
        Maxrain = maxrain;
    }

    public String getMaxtemp() {
        return Maxtemp;
    }

    public void setMaxtemp(String maxtemp) {
        Maxtemp = maxtemp;
    }

    public String getMinrain() {
        return Minrain;
    }

    public void setMinrain(String minrain) {
        Minrain = minrain;
    }

    public String getMintemp() {
        return Mintemp;
    }

    public void setMintemp(String mintemp) {
        Mintemp = mintemp;
    }

    public String getSoiltype() {
        return Soiltype;
    }

    public void setSoiltype(String soiltype) {
        Soiltype = soiltype;
    }

    public String getPrice() {return Price;}

    public void setPrice(String price) {Price = price;}
}
