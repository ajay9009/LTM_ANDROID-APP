package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.CategoriesAdapter;
import com.example.myapp.CategoriesHelperClass;
import com.example.myapp.FeaturedAdapter;
import com.example.myapp.FeaturedHelperClass;
import com.example.myapp.MostViewedAdpater;
import com.example.myapp.MostViewedHelperClass;
import com.example.myapp.R;
import com.google.android.material.navigation.NavigationView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;
import java.util.ArrayList;


public class DashboardScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth firebaseAuth;

    //Variables
    static final float END_SCALE = 0.7F;
    RecyclerView FeatureRecycler, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    RelativeLayout relativeLayout;
    ImageView menuIcon;
    //Draew Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    LinearLayout contentView;
    private TextView categoryview;
    ImageView textc,videoc,audioc,plus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.dashboard_screen);
        firebaseAuth = FirebaseAuth.getInstance();
categoryview = findViewById(R.id.category_viewall);
        //Hooks
        FeatureRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);
        textc = findViewById(R.id.textcategories);
        videoc = findViewById(R.id.videocategories);
        audioc = findViewById(R.id.audiocategories);
        relativeLayout = findViewById(R.id.SearchPage);
        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        plus = findViewById(R.id.plus);


        navigationDrawer();

        //Recycler View Functions Calls
        feature_recycler();
        mostViewedRecycler();
        categoriesRecycler();

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardScreen.this, MainActivity.class));

            }
        });


        categoryview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardScreen.this, AllCategories.class));

            }
        });

      textc.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(DashboardScreen.this, TextCard.class));
          }
      });
        videoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardScreen.this, VideoCard.class));
            }
        });
        audioc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardScreen.this, AudioCard.class));
            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardScreen.this, SearchCategory.class));
            }
        });

    }
    private void Logout(){
        firebaseAuth.signOut();
        Toast.makeText(DashboardScreen.this,"Logged out",Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(DashboardScreen.this, DashboardScreen.class));
    }
    public void shareApp(){
        try{
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "LTM");
            String shareMessage = "Download LTM from play store for getting better learning experience: https://play.google.com/store/apps/details?id="+BuildConfig.APPLICATION_ID+"\n\n";
            intent.putExtra(Intent.EXTRA_TEXT,shareMessage);
            startActivity(Intent.createChooser(intent,"Share via"));}
        catch (Exception e){
            Toast.makeText(DashboardScreen.this,"Error occurred",Toast.LENGTH_SHORT).show();
        }
    }

    //Navigation Drawer Functions
    private void navigationDrawer() {
        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();
    }


    private void animateNavigationDrawer() {

        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.setScrimColor(getResources().getColor(R.color.menu_backgorund));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder builder = new  AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            DashboardScreen.super.onBackPressed();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FirebaseUser log_user = firebaseAuth.getCurrentUser();
        switch(item.getItemId()){
            case R.id.nav_logout:{
                Logout();
                break;
            }
            case R.id.nav_login:{
                if(log_user == null) {
                    startActivity(new Intent(DashboardScreen.this, MainActivity.class));
                }
                else{
                    Toast.makeText(DashboardScreen.this,"You are already logged in",Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.nav_categories:{
                startActivity(new Intent(DashboardScreen.this, AllCategories.class));
                break;
            }
            case R.id.nav_share:{
                shareApp();
                break;
            }
            case R.id.nav_search:{
                startActivity(new Intent(DashboardScreen.this, SearchCategory.class));
                break;
            }
            case R.id.nav_home:{
                startActivity(new Intent(DashboardScreen.this, DashboardScreen.class));
                break;
            }
            case R.id.nav_rateus:{
                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.sololearn");
                Intent i = new Intent(Intent.ACTION_VIEW,uri);
                try {
                    startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(this, "Unable to open\n"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    private void categoriesRecycler() {

        //All Gradients
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff81C784, 0xffB9F6CA});
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.java_icon, "JAVA", "here you can improve your skills with LTM"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2, R.drawable.html_icon, "HTML5", "here you can improve your skills with LTM"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient3, R.drawable.css_icon, "CSS3", "here you can improve your skills with LTM"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient4, R.drawable.python_icon, "PYTHON", "here you can improve your skills with LTM"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.c_icon, "C PROGRAMMING", "here you can improve your skills with LTM"));


        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);
    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.study1, "java", "study hard to grow your skills with our LTM"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.study2, "c++", "study hard to grow your skills with our LTM"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.study3, "python", "study hard to grow your skills with our LTM"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.study1, "node.js", "study hard to grow your skills with our LTM"));

        adapter = new MostViewedAdpater(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);

    }

    private void feature_recycler() {

        FeatureRecycler.setHasFixedSize(true);
        FeatureRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> FeaturedLocations = new ArrayList<>();
        FeaturedLocations.add(new FeaturedHelperClass(R.drawable.study1, "PYTHON", "Study hard to grow your skills to the sky with LTM"));
        FeaturedLocations.add(new FeaturedHelperClass(R.drawable.study2, "JAVA", "Study hard to grow your skills to the sky with LTM"));
        FeaturedLocations.add(new FeaturedHelperClass(R.drawable.study3, "NODE.JS", "Study hard to grow your skills to the sky with LTM"));
        FeaturedLocations.add(new FeaturedHelperClass(R.drawable.study1, "REACT.JS", "Study hard to grow your skills to the sky with LTM"));

        //passing arrayList
        adapter = new FeaturedAdapter(FeaturedLocations);
        FeatureRecycler.setAdapter(adapter);


    }

}