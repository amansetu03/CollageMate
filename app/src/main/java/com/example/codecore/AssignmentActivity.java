package com.example.codecore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AssignmentActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> subject_name = new ArrayList<>();
    ArrayList<String> start_date= new ArrayList<>();
    ArrayList<String> end_date= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        recyclerView = findViewById(R.id.recycleviewassignment);
        //recycle configure
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //getting json data
        try {
            //Getting json object
            JSONObject obj = new JSONObject(loadJSONfromAssets());

            //fatch json array
            JSONArray studentArray = obj.getJSONArray("subject");
            //implemanting of loop for getting user data list
            for(int i=0;i<studentArray.length();i++){

                // creating json obj for single data
                JSONObject CompanyDetail = studentArray.getJSONObject(i);

                //fatching the name,domain,location and url
                subject_name.add(CompanyDetail.getString("name"));
                start_date.add(CompanyDetail.getString("assigndate"));
                end_date.add(CompanyDetail.getString("enddate"));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // calling the CustomAdapter to send the refrance and data

        CustomAdepters ad = new CustomAdepters(subject_name,start_date,end_date,AssignmentActivity.this);
        recyclerView.setAdapter(ad);


    }
    //method for loading data from json assets
    private String loadJSONfromAssets() {
        String json =null;
        try {
            InputStream is = getAssets().open("subject.json");
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