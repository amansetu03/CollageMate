package com.example.codecore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(),"welcome "+username,Toast.LENGTH_SHORT).show();



        //for logout season
        /*
        CardView exit =findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));

            }
        });
        */


        //1
        // for clicking on Internship card it show the Some Company details
        CardView internship = findViewById(R.id.CardInternship);
        internship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,InternshipActivity.class));
            }
        });
        //2
// For Education card view
        CardView education = findViewById(R.id.CardEducation);
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,EducationActivity.class));
            }
        });
//3
//for jump on assignment page
        CardView ass = findViewById(R.id.CarAssignment);
        ass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,AssignmentActivity.class));
            }
        });
        //for jump oon student loan
        CardView  sloan =findViewById(R.id.CardStudentLoan);
        sloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,studentloanActivity.class));
            }
        });

// 5th
        CardView gtrak=findViewById(R.id.mrntalhealth);
        gtrak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,GreadesActivity.class));
            }
        });
//6th
        CardView events=findViewById(R.id.CarEvents);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,EventsActivity.class));
            }
        });



    }
}