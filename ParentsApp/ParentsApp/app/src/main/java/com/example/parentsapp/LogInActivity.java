package com.example.parentsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import javax.annotation.Nullable;

public class LogInActivity extends AppCompatActivity {

    EditText etN;
    EditText etP;
    String userName;
    String password;
    FirebaseFirestore firestore;
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etN = findViewById(R.id.etName);
        etP = findViewById(R.id.etPassword);
        firestore = FirebaseFirestore.getInstance();
    }

    public void logIn(View view) {



        firestore.collection("users").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e == null){
                    int count =0;
                    for(DocumentSnapshot doc : queryDocumentSnapshots){
                        userName = doc.getString("username");
                        password = doc.getString("password");
                        if(etN.getText().toString().matches(userName) && etP.getText().toString().matches(password))
                        {
                            Profile pro = new Profile();
                            pro.setUserName(doc.getString("user name"));
                            pro.setEmail(doc.getString("email"));
                            pro.setChildName(doc.getString("child_name"));
                            pro.setClassNo(doc.getString("classname"));
                            pro.setFullName(doc.getString("full_name"));
                            pro.setSchool(doc.getString("school"));
                            pro.setPhone(doc.getString("mobile"));
                            pro.setRoundno(doc.getString("round"));
                            pro.setBusno(doc.getString("bus_no"));
                            pro.setPic(doc.getString("pic"));
                            pro.setDrivername(doc.getString("drivername"));
                            ProfileActivity.pro = pro;
                            Intent i=new Intent(LogInActivity.this, ProfileActivity.class);
                            startActivity(i);
                        }
                        else {
                            count++;
                            if (queryDocumentSnapshots.size()<=count){
                            Toast.makeText(LogInActivity.this,"Invalid user name or password", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
            }
        });
        }}