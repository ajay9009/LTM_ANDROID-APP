package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Html_index_activity extends AppCompatActivity {
    private static final String TAG = "Html_Index_Activity";
    private Context mContext;
    ArrayList<String> titleArrayList;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_index_activity);
        mContext = Html_index_activity.this;
        titleArrayList = new ArrayList<String>();
        titleArrayList.add(Constants.INTRODUCTION_HTML);
        titleArrayList.add(Constants.BASIC_HTML);
        titleArrayList.add(Constants.HEAD_ELEMENT_HTML);
        titleArrayList.add(Constants.CLASS_HTML);
        titleArrayList.add(Constants.ID_HTML);
        titleArrayList.add(Constants.ATTRIBUTES_HTML);
        titleArrayList.add(Constants.COLORS_HTML);
        titleArrayList.add(Constants.ELEMENTS_HTML);
        titleArrayList.add(Constants.FILE_PATHS_HTML);
        titleArrayList.add(Constants.FORMS_HTML);
        titleArrayList.add(Constants.HEADINGS_HTML);
        titleArrayList.add(Constants.IMAGES_HTML);
        titleArrayList.add(Constants.LINKS_HTML);
        titleArrayList.add(Constants.LISTS_HTML);
        titleArrayList.add(Constants.PARAGRAPHS_HTML);
        titleArrayList.add(Constants.QUOTATION_HTML);
        titleArrayList.add(Constants.STYLES_HTML);
        titleArrayList.add(Constants.TABLES_HTML);
        titleArrayList.add(Constants.TEXT_FORMATTING_HTML);

        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerViewHtml);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter adapter = new TitleAdapter(mContext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent desIntent = new Intent(mContext,Description_Activity_Html.class);
                desIntent.putExtra("titles",titleArrayList.get(position));
                startActivity(desIntent);


            }
        });


        mRecyclerView.setAdapter(adapter);


    }
}