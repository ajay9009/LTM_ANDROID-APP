package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

public class VideoCard extends AppCompatActivity {

    ImageView c,cpp,java,java_adv,python,php,html,css,js,vb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_card);

        c = findViewById(R.id.img_c);
        cpp = findViewById(R.id.img_cpp);
        java = findViewById(R.id.img_java);
        java_adv = findViewById(R.id.img_java_adv);
        python = findViewById(R.id.img_python);
        php = findViewById(R.id.img_php);
        html = findViewById(R.id.img_html);
        css = findViewById(R.id.img_css);
        js = findViewById(R.id.img_js);
        vb = findViewById(R.id.img_vb);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(VideoCard.this, VideoApp.class);
                intent.putExtra("lng", "cl");
                startActivity(intent);
            }
        });
        cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(VideoCard.this, VideoApp.class);
                intent.putExtra("lng", "cpl");
                startActivity(intent);
            }
        });

    }
}