package com.example.codecore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.ColorSpace;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class InternshipActivity extends AppCompatActivity {

    //1 widgets
    RecyclerView recyclerView;
    ArrayList<String> company_name = new ArrayList<>();
    ArrayList<String> company_domain= new ArrayList<>();
    ArrayList<String> company_location= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internship);

        recyclerView = findViewById(R.id.recycleview);
        //recycle configure
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //getting json data
        try {
            //Getting json object
            JSONObject obj = new JSONObject(loadJSONfromAssets());

            //fatch json array
            JSONArray companyArray = obj.getJSONArray("companies");
            //implemanting of loop for getting user data list
            for(int i=0;i<companyArray.length();i++){

                // creating json obj for single data
                JSONObject CompanyDetail = companyArray.getJSONObject(i);

                //fatching the name,domain,location and url
                company_name.add(CompanyDetail.getString("name"));
                company_domain.add(CompanyDetail.getString("domain"));
                company_location.add(CompanyDetail.getString("location"));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // calling the CustomAdapter to send the refrance and data

        CustomAdepter ad = new CustomAdepter(company_name,company_domain,company_location,InternshipActivity.this);
        recyclerView.setAdapter(ad);


    }
//method for loading data from json assets
    private String loadJSONfromAssets() {
        String json =null;
        try {
            InputStream is = getAssets().open("companys.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}