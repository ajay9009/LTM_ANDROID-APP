package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Cplus_Index_Activity extends AppCompatActivity {
    private static final String TAG = "Cplus_Index_Activity";
    private Context mContext;
    ArrayList<String> cppArrayList;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cplus__index_);
        mContext = Cplus_Index_Activity.this;
        cppArrayList = new ArrayList<String>();
        cppArrayList.add(Constants.INTRODUCTION_OF_CPP);
        cppArrayList.add(Constants.OVERVIEW_OF_CPP);
        cppArrayList.add(Constants.BASICS_OF_CPP);
        cppArrayList.add(Constants.BASIC_SYNTAX_OF_CPP);
        cppArrayList.add(Constants.FUNCTION_OF_CPP);
        cppArrayList.add(Constants.CLASSOBJECT_OF_CPP);
        cppArrayList.add(Constants.DATATYPES_OF_CPP);
        cppArrayList.add(Constants.VARIABLES_OF_CPP);
        cppArrayList.add(Constants.OPERATORS_OF_CPP);
        cppArrayList.add(Constants.STRINGS_OF_CPP);
        cppArrayList.add(Constants.SCOPES_OF_CPP);
        cppArrayList.add(Constants.REFVSPOINT_OF_CPP);
        cppArrayList.add(Constants.POLYMORPHISM_OF_CPP);
        cppArrayList.add(Constants.POINTERS_OF_CPP);
        cppArrayList.add(Constants.OVERLOADING_OF_CPP);
        cppArrayList.add(Constants.NUMBERS_OF_CPP);
        cppArrayList.add(Constants.NAMESPACE_OF_CPP);
        cppArrayList.add(Constants.MULTITHREADING_OF_CPP);
        cppArrayList.add(Constants.LOOPS_OF_CPP);
        cppArrayList.add(Constants.INTERFACES_OF_CPP);
        cppArrayList.add(Constants.INHERITENCE_OF_CPP);
        cppArrayList.add(Constants.INCAPSULATION_OF_CPP);
        cppArrayList.add(Constants.FILESTREAM_OF_CPP);
        cppArrayList.add(Constants.EXCEPTION_OF_CPP);
        cppArrayList.add(Constants.DYNAMICBINDING_OF_CPP);
        cppArrayList.add(Constants.DECISIONS_OF_CPP);
        cppArrayList.add(Constants.DATETIME_OF_CPP);
        cppArrayList.add(Constants.DATASTRUCTURE_OF_CPP);
        cppArrayList.add(Constants.CONSTRAINTS_OF_CPP);
        cppArrayList.add(Constants.ABSTRACTION_OF_CPP);
        cppArrayList.add(Constants.STORAGE_OF_CPP);
        cppArrayList.add(Constants.ARRAY_OF_CPP);

        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerViewCplus);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter adapter = new TitleAdapter(mContext, cppArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent cppIntent = new Intent(mContext,Description_Activity_Cplus.class);
                cppIntent.putExtra("titles",cppArrayList.get(position));
                startActivity(cppIntent);


            }
        });

        mRecyclerView.setAdapter(adapter);

    }
}