package com.example.parentsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    public static Profile pro;

    TextView fullName;


    TextView studentName;
    TextView classNo;
    TextView school;
    TextView drivername;
    TextView phone,roundnum,busnumber;
    ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        fullName = findViewById(R.id.fullName);
        studentName = findViewById(R.id.childName);
        classNo = findViewById(R.id.childClass);
        // school = findViewById(R.id.school);
        // phone = findViewById(R.id.phone);
        roundnum = findViewById(R.id.rouno);
        busnumber = findViewById(R.id.busno);
        pic = findViewById(R.id.pic);
        fullName.setText(pro.getFullName());
        studentName.setText(pro.getChildName());
        classNo.setText(pro.getClassNo());
        // school.setText(pro.getSchool());
        // phone.setText(pro.getPhone());
        roundnum.setText(pro.getRoundno());
        busnumber.setText(pro.getBusno());

        drivername = findViewById(R.id.drivername);
        drivername.setText(pro.getDrivername());


        LoadImageFromUrl(pro.getPic());


    }
    public void showPositionOnMap(View view) {
        Intent in = new Intent(this, MapsActivity.class);
        in.putExtra("roundno",roundnum.getText().toString());
        in.putExtra("busno",busnumber.getText().toString());
        startActivity(in);
    }
    public void singout (View view) {
        Intent home = new Intent(ProfileActivity.this, LogInActivity.class);
        startActivity(home);
        finish();
    }
    public void schoolhotline(View view){
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:0780696980"));
        startActivity(i);
        finish();
    }
    private void LoadImageFromUrl(String url) {
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher).resize(150, 150)
                .error(R.drawable.profile)
                .into(pic, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess(){
                    }
                    @Override
                    public void onError(){
                    }
                });
    }
}