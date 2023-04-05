package com.example.codecore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class studentloanActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentloan);
        webView = findViewById(R.id.wb);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.7nishchay-yuvaupmission.bihar.gov.in/");
    }
}