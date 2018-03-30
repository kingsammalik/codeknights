package com.example.root.codeknights;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Recommendation extends AppCompatActivity {
    Spinner region;
    Spinner season;
    Spinner crops;
    cropinfo ci;
    ArrayAdapter<CharSequence> regionadapt;
    ArrayAdapter<CharSequence> seasonadapt;
    ArrayAdapter<CharSequence> cropadapt;
    String REGION,SEASON,CROPS;
    DatabaseReference databaseReference;
    Button showinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);
        showinfo=(Button)findViewById(R.id.Show);
        region=(Spinner)findViewById(R.id.Region);
        season=(Spinner)findViewById(R.id.Season);
        crops=(Spinner)findViewById(R.id.Crops);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        regionadapt=ArrayAdapter.createFromResource(this,R.array.REGION,android.R.layout.simple_spinner_item);
        seasonadapt=ArrayAdapter.createFromResource(this,R.array.SEASON,android.R.layout.simple_spinner_item);
        cropadapt=ArrayAdapter.createFromResource(this,R.array.CROPS,android.R.layout.simple_spinner_item);

        regionadapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seasonadapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cropadapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        region.setAdapter(regionadapt);
        season.setAdapter(seasonadapt);
        crops.setAdapter(cropadapt);
        region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                REGION=(String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        season.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                SEASON=(String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        crops.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                CROPS=(String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        showinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        databaseReference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                showdata(dataSnapshot);
                                Intent intent=new Intent(Recommendation.this,Displaycrop.class);
                                intent.putExtra("object",ci);

                                startActivity(intent);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });



        }

    private void showdata(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds:dataSnapshot.getChildren()){
            ci=new cropinfo();
            ci.setHarvesting(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getHarvesting());
            ci.setMaxph(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getMaxph());
            ci.setMaxrain(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getMaxrain());
            ci.setMaxtemp(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getMaxtemp());
            ci.setMinrain(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getMinrain());
            ci.setMintemp(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getMintemp());
            ci.setSoiltype(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getSoiltype());
            ci.setPrice(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getPrice());
        }
    }
}

