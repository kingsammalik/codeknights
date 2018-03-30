package com.example.root.codeknights;

import java.io.Serializable;

/**
 * Created by root on 3/17/18.
 */

public class Field_data implements Serializable {
    private float Damaged_area;
    private float yield;
    private float rate;


    public Field_data() {
    }

    public float getDamaged_area() {
        return Damaged_area;
    }

    public void setDamaged_area(float damaged_area) {Damaged_area = damaged_area;}

    public float getYield() {
        return yield;
    }

    public void setYield(float yield) {
        this.yield = yield;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
