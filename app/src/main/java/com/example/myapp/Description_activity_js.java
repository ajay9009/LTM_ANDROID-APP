package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Description_activity_js extends AppCompatActivity {
    private static final String TAG = "Description_Activity_js";
    private Context mContext;
    private Bundle extras;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_js);

        mContext = Description_activity_js.this;

        webView = (WebView) findViewById(R.id.simpleWebView_js);

        extras = getIntent().getExtras();
        if(!extras.equals(null)){
            String data = extras.getString("titles");
            Log.d(TAG, "onCreate: the coming data is "+data);
            String url = "file:///android_asset/javascript/"+data+".html";

            webView.loadUrl(url);
            WebSettings webSettings = webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setJavaScriptEnabled(true);
        }
    }
}