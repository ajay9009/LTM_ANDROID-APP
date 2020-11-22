package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Css_index_activity extends AppCompatActivity {

    private Context mContext;
    ArrayList<String> titleArrayList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_css_index_activity);
        mContext = Css_index_activity.this;
        titleArrayList = new ArrayList<String>();
        titleArrayList.add(Constants.INTRODUCTION_CSS);
        titleArrayList.add(Constants.HOW_TO_ADD_CSS);
        titleArrayList.add(Constants.TEXT_CSS);
        titleArrayList.add(Constants.COMMENTS_CSS);
        titleArrayList.add(Constants.SYNTAX_CSS);
        titleArrayList.add(Constants.TABLES_CSS);
        titleArrayList.add(Constants.SELECTORS_CSS);
        titleArrayList.add(Constants.OUTLINE_CSS);
        titleArrayList.add(Constants.PADDING_CSS);
        titleArrayList.add(Constants.NAVIGATIONS_CSS);
        titleArrayList.add(Constants.LAYOUT_OVERFLOW_CSS);
        titleArrayList.add(Constants.BACKGROUND_CSS);
        titleArrayList.add(Constants.BORDERS_CSS);
        titleArrayList.add(Constants.BOX_MODEL_CSS);
        titleArrayList.add(Constants.COMBINATORS_CSS);
        titleArrayList.add(Constants.DROPDOWNS_CSS);
        titleArrayList.add(Constants.FONTS_CSS);
        titleArrayList.add(Constants.FORMS_CSS);
        titleArrayList.add(Constants.HEIGHT_WITDH_CSS);
        titleArrayList.add(Constants.IMAGE_GALLERY_CSS);
        titleArrayList.add(Constants.IMAGE_SPRITES_CSS);
        titleArrayList.add(Constants.DISPLAY_PROPERTY_CSS);
        titleArrayList.add(Constants.POSITION_PROPERTY_CSS);
        titleArrayList.add(Constants.WIDTH_MAXWIDTH_CSS);
        titleArrayList.add(Constants.LINKS_CSS);
        titleArrayList.add(Constants.MARGINS_CSS);
        titleArrayList.add(Constants.PSEUDO_CLASSES_CSS);
        titleArrayList.add(Constants.PSEUDO_ELEMENTS_CSS);
        titleArrayList.add(Constants.PSEUDO_ELEMENTS_CSS);

        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerViewCss);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter adapter = new TitleAdapter(mContext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent desIntent = new Intent(mContext,Description_activity_css.class);
                desIntent.putExtra("titles",titleArrayList.get(position));
                startActivity(desIntent);


            }
        });


        mRecyclerView.setAdapter(adapter);

    }
}