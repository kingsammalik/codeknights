package com.example.root.codeknights;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class otpverification extends AppCompatActivity {
    FirebaseAuth auth;
    EditText number,otp;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    String verificationcode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);
        number=(EditText)findViewById(R.id.Number);
        otp=(EditText)findViewById(R.id.OTP);
        auth=FirebaseAuth.getInstance();
        mCallback=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationcode=s;
                Toast.makeText(getApplicationContext(),"Code has been sent to this number",Toast.LENGTH_SHORT).show();
            }
        };

    }
    public void send_sms (View v){
        String Number=number.getText().toString();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                Number,60, TimeUnit.SECONDS,this,mCallback
        );
    }
    public void signInWithPhone(PhoneAuthCredential credential){
        auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                   startActivity(new Intent(otpverification.this,DashBoardFarmer.class));
                }
            }
        });
    }
    public void verify(View v)
    {
        String Otp=otp.getText().toString();
        if (Otp!=null)
        {
            verifyPhoneNumber (verificationcode,Otp);
        }

    }
    public void verifyPhoneNumber (String verificationcode,String otp)
    {
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationcode,otp);
        signInWithPhone(credential);
    }
}
