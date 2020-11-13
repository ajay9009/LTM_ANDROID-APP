package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TextCard extends AppCompatActivity {
    ImageView javaL ,cL,cpL;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_card);
        javaL = findViewById(R.id.javatext);
        cL = findViewById(R.id.clanguage);
        cpL = findViewById(R.id.cplanguage);
        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser useraccess = firebaseAuth.getCurrentUser();

        javaL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(useraccess == null){
                    Toast.makeText(TextCard.this,"login to access",Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(new Intent(TextCard.this, Subject_Index_Activity.class));
                }
            }
        });
        cL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(useraccess == null){
                    Toast.makeText(TextCard.this,"login to access",Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(new Intent(TextCard.this, C_Index_Activity.class));
                }
            }
        });

        cpL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(useraccess == null){
                    Toast.makeText(TextCard.this,"login to access",Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(new Intent(TextCard.this, Cplus_Index_Activity.class));
                }
            }
        });

    }
}