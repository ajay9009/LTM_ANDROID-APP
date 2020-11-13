package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class SearchCategory extends AppCompatActivity {
SearchView mySearchView;
ListView myList;
ArrayList<String> list;
ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_category);
        mySearchView = findViewById(R.id.searchView);
        myList = findViewById(R.id.myList);
        list = new ArrayList<String>();
        list.add("C Programming");
        list.add("C++ Programming/ Oops");
        list.add("Java Programming");
        list.add("Java Advance/ Eclipse");
        list.add("PHP");
        list.add("Python");
        list.add("HTML");
        list.add("CSS");
        list.add("Java Script");
        list.add("Visual Basic");
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        myList.setAdapter(adapter);
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });



    }
}