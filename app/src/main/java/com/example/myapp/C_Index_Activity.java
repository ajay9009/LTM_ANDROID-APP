package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class C_Index_Activity extends AppCompatActivity {
    private static final String TAG = "C_Index_Activity";
    private Context mContext;
    ArrayList<String> titleArrayList;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c__index_);
        mContext = C_Index_Activity.this;
        titleArrayList = new ArrayList<String>();
        titleArrayList.add(Constants.ABOUT_C_LANGUAGE);
        titleArrayList.add(Constants.INTRODUCTION);
        titleArrayList.add(Constants.BASIC);
        titleArrayList.add(Constants.PREPROCESSOR_AND_HEADER_FILES);
        titleArrayList.add(Constants.VARIABLES_IN_C);
        titleArrayList.add(Constants.DATA_TYPES_IN_C);
        titleArrayList.add(Constants.STRINGS_IN_C);
        titleArrayList.add(Constants.INPUT_AND_OUTPUT_IN_C);
        titleArrayList.add(Constants.OPERATORS_IN_C);
        titleArrayList.add(Constants.COMMAND_LINE_ARGUMENT);
        titleArrayList.add(Constants.TYPECASTING);
        titleArrayList.add(Constants.ARRAY_IN_C);
        titleArrayList.add(Constants.DECISION_MAKING_AND_LOOPS);
        titleArrayList.add(Constants.STRUCTURE_IN_C);
        titleArrayList.add(Constants.RECURSION);
        titleArrayList.add(Constants.POINTERS);
        titleArrayList.add(Constants.FILES_IN_C);
        titleArrayList.add(Constants.ERROR_HANDLING);

        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerViewC);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter adapter = new TitleAdapter(mContext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent desIntent = new Intent(mContext,Description_Activity_C.class);
                desIntent.putExtra("titles",titleArrayList.get(position));
                startActivity(desIntent);


            }
        });


        mRecyclerView.setAdapter(adapter);


    }
}