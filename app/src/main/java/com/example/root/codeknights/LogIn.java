package com.example.root.codeknights;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 3/20/18.
 */

public class LogIn extends AppCompatActivity {
    Button Verify;
    Button requestOtp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        Verify=(Button)findViewById(R.id.verify);



        }
}
