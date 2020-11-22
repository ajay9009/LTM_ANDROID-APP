package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AllCategories extends AppCompatActivity {

     Button cbtn,cplusbtn,javacorebtn,javaadvbtn,phpbtn,pythonbtn,htmlbtn,cssbtn,jsbtn,vbnetbtn;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);

        cbtn = findViewById(R.id.c_btn);
        cplusbtn = findViewById(R.id.cplus_press);
        javacorebtn= findViewById(R.id.javacore_press);
        javaadvbtn= findViewById(R.id.javaadv_press);
        phpbtn= findViewById(R.id.php_press);
        pythonbtn= findViewById(R.id.python_press);
        htmlbtn= findViewById(R.id.html_press);
        cssbtn= findViewById(R.id.css_press);
        jsbtn= findViewById(R.id.js_press);
        vbnetbtn= findViewById(R.id.vbnet_press);
        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser useraccess = firebaseAuth.getCurrentUser();

        cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(useraccess == null){
                    Toast.makeText(AllCategories.this,"login to access",Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(new Intent(AllCategories.this, C_Index_Activity.class));
                }
            }
        });
        cplusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (useraccess == null) {
                    Toast.makeText(AllCategories.this, "login to access", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(AllCategories.this, Cplus_Index_Activity.class));
                }
            }
        });
        javacorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(useraccess == null){
                    Toast.makeText(AllCategories.this,"login to access",Toast.LENGTH_SHORT).show();
                }
                else{
                startActivity(new Intent(AllCategories.this, Subject_Index_Activity.class));
                }
            }
        });
        javaadvbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AllCategories.this,"You have selected JavaAdvance",Toast.LENGTH_SHORT).show();
            }
        });
        phpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AllCategories.this,"You have selected PHP",Toast.LENGTH_SHORT).show();

            }
        });
        pythonbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(useraccess == null){
                    Toast.makeText(AllCategories.this,"login to access",Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(new Intent(AllCategories.this, Activity_index_python.class));
                }
            }
        });
        htmlbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (useraccess == null) {
                    Toast.makeText(AllCategories.this, "login to access", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(AllCategories.this, Html_index_activity.class));
                }
            }
        });
        cssbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(useraccess == null){
                    Toast.makeText(AllCategories.this,"login to access",Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(new Intent(AllCategories.this, Css_index_activity.class));
                }
            }
        });
        jsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(useraccess == null){
                    Toast.makeText(AllCategories.this,"login to access",Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(new Intent(AllCategories.this, Js_index_activity.class));
                }
            }
        });
        vbnetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AllCategories.this,"You have selected VB.net",Toast.LENGTH_SHORT).show();
            }
        });

    }
}