package com.example.driverapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class splach extends AppCompatActivity {
private static int sptimeout=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent homea = new Intent(splach.this,MainActivity.class);
               startActivity(homea);
                finish();

            }

        },sptimeout);


    }
}
