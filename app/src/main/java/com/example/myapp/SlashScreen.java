package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;



public class SlashScreen extends AppCompatActivity {
    private static int SPLASH_TIMER = 5000;
    //variables
    ImageView backgroundImage;
    TextView poweredByLine;

    //Animations
    Animation topAnim,bottomAnim;
    SharedPreferences onBoardingScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //Hooks
        backgroundImage=findViewById(R.id.background_image);
        poweredByLine=findViewById(R.id.powered_by_line);

        //Animations
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //set animations on elements
        backgroundImage.setAnimation(topAnim);
        poweredByLine.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingScreen = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);

                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime",true);
                if(isFirstTime){
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();

                    Intent intent=new Intent(getApplicationContext(), OnBoarding.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    Intent intent=new Intent(getApplicationContext(), DashboardScreen.class);
                    startActivity(intent);
                    finish();
                }

            }
        },SPLASH_TIMER);

    }
}