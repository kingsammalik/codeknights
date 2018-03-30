package com.example.root.codeknights;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class crop_yield_calculator extends AppCompatActivity {
    EditText Area,Plants;
    TextView result;
    EditText Pods;
    EditText Seeds;
    Spinner crops;
    Spinner region;
    ArrayAdapter<CharSequence> regionadapt;
    ArrayAdapter<CharSequence> cropadapt;
    Button calculate,genrep;
    DatabaseReference databaseReference;
    String CROPS,REGION,SEASON;

    Field_data fd;
    float are,pla,seed,pod,res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_yield_calculator);
        Area=(EditText) findViewById(R.id.area);
        Plants=(EditText) findViewById(R.id.plants);
        Pods=(EditText) findViewById(R.id.pods);
        Seeds=(EditText)findViewById(R.id.seeds);
        calculate=(Button)findViewById(R.id.Calculate);
        result=(TextView) findViewById(R.id.Result);
        calculate=(Button)findViewById(R.id.Calculate);
        fd=new Field_data();
        genrep=(Button)findViewById(R.id.Report);
        crops=(Spinner)findViewById(R.id.Crops);
        region=(Spinner)findViewById(R.id.Region);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        regionadapt=ArrayAdapter.createFromResource(this,R.array.REGION,android.R.layout.simple_spinner_item);
        cropadapt= ArrayAdapter.createFromResource(this,R.array.CROPS,android.R.layout.simple_spinner_item);
        regionadapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cropadapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        region.setAdapter(regionadapt);
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
        crops.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                CROPS=(String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        calculate();
        genrep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        showdata(dataSnapshot);
                        Intent j=new Intent(crop_yield_calculator.this,report.class);
                        j.putExtra("Object",fd);
                        startActivity(j);



                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });

    }

    private void calculate(){
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                are=Float.parseFloat(Area.getText().toString());
                pla=Float.parseFloat(Plants.getText().toString());
                pod=Float.parseFloat(Pods.getText().toString());
                seed=Float.parseFloat(Seeds.getText().toString());

                res=(are*pla)*pod*seed;
                result.setText(Float.toString(res));
                fd=new Field_data();
                fd.setYield(res);
                generate();

            }
        });

    }
    private void generate(){

    }
    private void showdata(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds:dataSnapshot.getChildren()){

            if (CROPS.equals("Wheat") ||CROPS.equals("Mustard")){
                SEASON="Winter";
            }
            else if (CROPS.equals("Bajra")|| CROPS.equals("Paddy")){
                SEASON="Summer";
            }

            fd.setRate(Float.parseFloat(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getPrice()));
        }
    }
}
