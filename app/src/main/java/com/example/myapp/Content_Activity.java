package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Content_Activity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_);
        listView =(ListView)findViewById(R.id.listview);
        final ArrayList<String> arrayList=new ArrayList<>();


        arrayList.add("Introduction");
        arrayList.add("About Language");
        arrayList.add("Content");
        arrayList.add("history");
        arrayList.add("Origin");
        arrayList.add("Types");
        arrayList.add("Blank");
        arrayList.add("then");
        arrayList.add("many");
        arrayList.add("other");
        arrayList.add("operating system.");
        arrayList.add("android");
        arrayList.add("is");
        arrayList.add("great");

        arrayList.add("operating system.");


        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);


        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Content_Activity.this,"You have selected:"+position+" "+arrayList.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });



    }
}