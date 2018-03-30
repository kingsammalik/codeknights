package com.example.root.codeknights;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by root on 3/20/18.
 */

public class DashBoardFarmer extends AppCompatActivity implements View.OnClickListener {
    private CardView weatherinformation,buyseed,insuranceclaim,help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dash_board_farmer);
        weatherinformation=(CardView)findViewById(R.id.weatherinfo);
        buyseed=(CardView)findViewById(R.id.buyseeds);
        insuranceclaim=(CardView)findViewById(R.id.insurance);
        help=(CardView)findViewById(R.id.helpcard);
        weatherinformation.setOnClickListener(this);
        buyseed.setOnClickListener(this);
        insuranceclaim.setOnClickListener(this);
        help.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId())
        {
            case R.id.weatherinfo:i=new Intent(this,SlideImageText.class);startActivity(i);break;
            case R.id.buyseeds:i=new Intent(this,SlideImageText.class);startActivity(i);break;
            case R.id.insurance:i=new Intent(this,SlideImageText.class);startActivity(i);break;
            case R.id.helpcard:i=new Intent(this,SlideImageText.class);startActivity(i);break;
        }



    }
}
