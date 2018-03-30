package com.example.root.codeknights;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Displaycrop extends AppCompatActivity {
    TextView Harvesting,Maxtemp,Mintemp,Maxrain,Maxph,Minrain,Soiltype;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaycrop);
        Intent i=getIntent();
        cropinfo ci= (cropinfo)i.getSerializableExtra("object");
        Harvesting=(TextView)findViewById(R.id.harvesting);
        Mintemp=(TextView)findViewById(R.id.Mintemp);
        Maxrain=(TextView)findViewById(R.id.maxrain);
        Minrain=(TextView)findViewById(R.id.minrain);
        Maxph=(TextView)findViewById(R.id.maxph);
        Soiltype=(TextView)findViewById(R.id.soiltype);
        Maxtemp=(TextView)findViewById(R.id.Maxtemp);
        Harvesting.setText(ci.getHarvesting());
        Mintemp.setText(ci.getMintemp());
        Maxtemp.setText(ci.getMaxtemp());
        Minrain.setText(ci.getMinrain());
        Maxrain.setText(ci.getMaxrain());
        Maxph.setText(ci.getMaxph());
        Soiltype.setText(ci.getSoiltype());



    }
}
