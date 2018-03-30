package com.example.root.codeknights;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class report extends AppCompatActivity {
    TextView Damagedarea,Rate,Yield,Cost;
    Field_data fd;
    float res;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Intent j=getIntent();
        fd=(Field_data)j.getSerializableExtra("Object");

        fd.setDamaged_area((float) 25.32);
        Damagedarea=(TextView)findViewById(R.id.damagedarea);
        Rate=(TextView)findViewById(R.id.rate);
        Yield=(TextView)findViewById(R.id.yield);
        Cost=(TextView)findViewById(R.id.cost);
        res=(fd.getYield()*fd.getRate()*fd.getDamaged_area())/1000;
        Damagedarea.setText(Float.toString(fd.getDamaged_area()));
        Rate.setText(Float.toString(fd.getRate()));
        Yield.setText(Float.toString(fd.getYield()));
        Cost.setText(Float.toString(res));

    }
}
