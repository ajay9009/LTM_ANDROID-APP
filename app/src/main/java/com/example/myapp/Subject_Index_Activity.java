package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Subject_Index_Activity extends AppCompatActivity {
    private static final String TAG = "Subject_Index_Activity";
    private Context mContext;
    ArrayList<String> titleArrayList;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject__index_);

        mContext = Subject_Index_Activity.this;

        titleArrayList = new ArrayList<String>();
        titleArrayList.add(Constants.WHAT_IS_JAVA);
        titleArrayList.add(Constants.WHY_JAVA);
        titleArrayList.add(Constants.INSTALLATION_OF_JAVA);
        titleArrayList.add(Constants.BASIC_PROGRAM);
        titleArrayList.add(Constants.COMMENTS);
        titleArrayList.add(Constants.VARIABLES);
        titleArrayList.add(Constants.DATA_TYPES);
        titleArrayList.add(Constants.TYPE_CASTING);
        titleArrayList.add(Constants.OPERATORS);
        titleArrayList.add(Constants.STRINGS);
        titleArrayList.add(Constants.MATH);
        titleArrayList.add(Constants.BOOLEANS);
        titleArrayList.add(Constants.IF_ELSE);
        titleArrayList.add(Constants.SWITCH);
        titleArrayList.add(Constants.WHILE_lOOP);
        titleArrayList.add(Constants.FOR_LOOP);
        titleArrayList.add(Constants.BREAK_CONTINUE);
        titleArrayList.add(Constants.ARRAYS);

        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter adapter = new TitleAdapter(mContext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent desIntent = new Intent(mContext,Description_Activity_Java.class);
                desIntent.putExtra("titles",titleArrayList.get(position));
                startActivity(desIntent);


            }
        });


        mRecyclerView.setAdapter(adapter);



    }
}