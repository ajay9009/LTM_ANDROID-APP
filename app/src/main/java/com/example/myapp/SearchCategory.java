package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class SearchCategory extends AppCompatActivity {
SearchView mySearchView;
ListView myList;
ArrayList<String> list;
ArrayAdapter<String> adapter;
private FirebaseAuth firebaseAuth;
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
        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser useraccess = firebaseAuth.getCurrentUser();
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

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0) {
                    if (useraccess == null) {
                        Toast.makeText(SearchCategory.this, "Please login to access", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(view.getContext(), C_Index_Activity.class);
                        startActivity(intent);
                    }
                }
                if (i == 1){
                    if (useraccess == null) {
                        Toast.makeText(SearchCategory.this, "Please login to access", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(view.getContext(), Cplus_Index_Activity.class);
                        startActivity(intent);
                    }
                }
                if (i == 2){
                    if (useraccess == null) {
                        Toast.makeText(SearchCategory.this, "Please login to access", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(view.getContext(), Subject_Index_Activity.class);
                        startActivity(intent);
                    }
                }
                if (i == 3){
                    Toast.makeText(SearchCategory.this,"This Course Will Available Soon", Toast.LENGTH_SHORT).show();
                }
                if (i == 4){
                    Toast.makeText(SearchCategory.this,"This Course Will Available Soon", Toast.LENGTH_SHORT).show();
                }
                if (i == 5){
                    if (useraccess == null) {
                        Toast.makeText(SearchCategory.this, "Please login to access", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(view.getContext(), Activity_index_python.class);
                        startActivity(intent);
                    }
                }
                if (i == 6) {
                    if (useraccess == null) {
                        Toast.makeText(SearchCategory.this, "Please login to access", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(view.getContext(), Html_index_activity.class);
                        startActivity(intent);
                    }
                }
                if (i == 7){
                    if (useraccess == null) {
                        Toast.makeText(SearchCategory.this, "Please login to access", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(view.getContext(), Css_index_activity.class);
                        startActivity(intent);
                    }
                }
                if (i == 8){
                    if (useraccess == null) {
                        Toast.makeText(SearchCategory.this, "Please login to access", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(view.getContext(), Js_index_activity.class);
                        startActivity(intent);
                    }
                }
                if (i == 9){
                    Toast.makeText(SearchCategory.this,"This Course Will Available Soon", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}