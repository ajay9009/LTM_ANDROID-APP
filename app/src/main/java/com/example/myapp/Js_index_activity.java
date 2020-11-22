package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Js_index_activity extends AppCompatActivity {

    private Context mContext;
    ArrayList<String> titleArrayList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_index_activity);

        mContext = Js_index_activity.this;
        titleArrayList = new ArrayList<String>();
        titleArrayList.add(Constants.INTRODUCTION_JS);
        titleArrayList.add(Constants.LET_JS);
        titleArrayList.add(Constants.SYNTAX_JS);
        titleArrayList.add(Constants.WHERE_TO_JS);
        titleArrayList.add(Constants.COMMENTS_JS);
        titleArrayList.add(Constants.VARIABLES_JS);
        titleArrayList.add(Constants.FUNCTIONS_JS);
        titleArrayList.add(Constants.ARROW_FUNCTION_JS);
        titleArrayList.add(Constants.CONST_JS);
        titleArrayList.add(Constants.DATA_TYPES_JS);
        titleArrayList.add(Constants.CLASSES_JS);
        titleArrayList.add(Constants.OBJECTS_JS);
        titleArrayList.add(Constants.BOOLEANS_JS);
        titleArrayList.add(Constants.ASSIGNMENT_JS);
        titleArrayList.add(Constants.ARRAY_JS);
        titleArrayList.add(Constants.ARRAY_METHODS_JS);
        titleArrayList.add(Constants.ARRAY_ITERATION_JS);
        titleArrayList.add(Constants.SORTING_ARRAY_JS);
        titleArrayList.add(Constants.COMPARISON_OPERATORS_JS);
        titleArrayList.add(Constants.DEBUGGING_JS);
        titleArrayList.add(Constants.ERRORS_JS);
        titleArrayList.add(Constants.EVENTS_JS);
        titleArrayList.add(Constants.IF_ELSE_JS);
        titleArrayList.add(Constants.FOR_LOOP_JS);
        titleArrayList.add(Constants.NUMBERS_JS);
        titleArrayList.add(Constants.NUMBER_METHODS_JS);
        titleArrayList.add(Constants.OPERATORS_JS);
        titleArrayList.add(Constants.OUTPUT_JS);
        titleArrayList.add(Constants.RANDOM_JS);
        titleArrayList.add(Constants.REGULAR_EXP_JS);
        titleArrayList.add(Constants.SCOPES_JS);
        titleArrayList.add(Constants.STATEMENTS_JS);
        titleArrayList.add(Constants.STRING_JS);
        titleArrayList.add(Constants.STRING_METHODS_JS);
        titleArrayList.add(Constants.STYLES_CODING_JS);
        titleArrayList.add(Constants.SWITCH_STATEMENT_JS);
        titleArrayList.add(Constants.TYPE_CONVERSION_JS);
        titleArrayList.add(Constants.USE_STRICT_JS);
        titleArrayList.add(Constants.WHILE_LOOP_JS);
        titleArrayList.add(Constants.THIS_KEYWORD_LOOP_JS);
        titleArrayList.add(Constants.HOSTING_JS);

        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerViewJs);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter adapter = new TitleAdapter(mContext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent desIntent = new Intent(mContext,Description_activity_js.class);
                desIntent.putExtra("titles",titleArrayList.get(position));
                startActivity(desIntent);


            }
        });


        mRecyclerView.setAdapter(adapter);

    }
}