package com.example.root.codeknights;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VegetationInfrmationDetail extends AppCompatActivity {


    ListView list;
    String crop;
    int imageId;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetation_infrmation_detail);
        Intent i=getIntent();
        int parent=i.getIntExtra("group",0);
        int child=i.getIntExtra("child",0);
        choose_crop(parent,child);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        //CustomList adapter = new
          //      CustomList(VegetationInfrmationDetail.this, crop, imageId);
        list=(ListView)findViewById(R.id.list);
        //list.setAdapter(adapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                crop(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void crop(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            cropinfo ci = new cropinfo();
           /* ci.setHarvesting(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getHarvesting());
            ci.setMaxph(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getMaxph());
            ci.setMaxrain(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getMaxrain());
            ci.setMaxtemp(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getMaxtemp());
            ci.setMinrain(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getMinrain());
            ci.setMintemp(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getMintemp());
            ci.setSoiltype(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getSoiltype());
            ci.setPrice(ds.child(REGION).child(SEASON).child(CROPS).getValue(cropinfo.class).getPrice());*/
        }
    }

    private void choose_crop(int parent, int child) {
        cropinfo ch1,ch2;
        if (parent==0 && child==0)
        {

        }
    }

}
