package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Description_Activity_Html extends AppCompatActivity {

    private static final String TAG = "Description_Activity_Html";
    private Context mContext;
    private Bundle extras;
    private WebView webView;

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description___html);

        mContext = Description_Activity_Html.this;

        webView = (WebView) findViewById(R.id.simpleWebView_html);

        extras = getIntent().getExtras();
        if(!extras.equals(null)){
            String data = extras.getString("titles");
            Log.d(TAG, "onCreate: the coming data is "+data);
            String url = "file:///android_asset/html/"+data+".html";

            webView.loadUrl(url);
            WebSettings webSettings = webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setJavaScriptEnabled(true);
        }
    }
}