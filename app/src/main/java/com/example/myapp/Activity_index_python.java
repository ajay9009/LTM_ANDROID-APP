package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Activity_index_python extends AppCompatActivity {
    private static final String TAG = "Python_Index_Activity";
    private Context mContext;
    ArrayList<String> titleArrayList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_python);
        mContext = Activity_index_python.this;
        titleArrayList = new ArrayList<String>();
        titleArrayList.add(Constants.INTRODUCTION_PYTHON);
        titleArrayList.add(Constants.DATATYPES_PYTHON);
        titleArrayList.add(Constants.ARRAY_PYTHON);
        titleArrayList.add(Constants.CLASS_PYTHON);
        titleArrayList.add(Constants.COMMENTS_PYTHON);
        titleArrayList.add(Constants.BOOLEAN_PYTHON);
        titleArrayList.add(Constants.CONDITION_PYTHON);
        titleArrayList.add(Constants.CASTING_PYTHON);
        titleArrayList.add(Constants.DATETIME_PYTHON);
        titleArrayList.add(Constants.DICTIONARIES_PYTHON);
        titleArrayList.add(Constants.FOR_LOOP_PYTHON);
        titleArrayList.add(Constants.FUNCTIONS_PYTHON);
        titleArrayList.add(Constants.ITERATORS_PYTHON);
        titleArrayList.add(Constants.LAMBDA_PYTHON);
        titleArrayList.add(Constants.MATH_PYTHON);
        titleArrayList.add(Constants.NUMBERS_PYTHON);
        titleArrayList.add(Constants.PIP_PYTHON);

        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerViewPyton);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter adapter = new TitleAdapter(mContext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent desIntent = new Intent(mContext,Description_Activity_python.class);
                desIntent.putExtra("titles",titleArrayList.get(position));
                startActivity(desIntent);


            }
        });


        mRecyclerView.setAdapter(adapter);
    }
}