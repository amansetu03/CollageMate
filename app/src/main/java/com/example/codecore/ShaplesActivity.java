package com.example.codecore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class ShaplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shaples);
        Intent iHome = new Intent(ShaplesActivity.this,LoginActivity.class);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(iHome);
                getSupportActionBar().hide();
            }
        },500);


    }
}