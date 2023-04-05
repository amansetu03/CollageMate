package com.example.codecore;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdepter  extends RecyclerView.Adapter<CustomAdepter.MyViewHolder> {

    ArrayList<String> company_name;
    ArrayList<String> company_domain;
    ArrayList<String> company_location;

    Context cnx;

    public CustomAdepter(ArrayList<String> company_name, ArrayList<String> company_domain, ArrayList<String> company_location, Context cnx) {
        this.company_name = company_name;
        this.company_domain = company_domain;
        this.company_location = company_location;

        this.cnx = cnx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(company_name.get(position));
        holder.domain.setText(company_domain.get(position));
        holder.location.setText(company_location.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cnx, company_name.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return company_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,domain,location;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.displaycname);
            domain=itemView.findViewById(R.id.displaycdomain);
            location=itemView.findViewById(R.id.displayclocation);
        }
    }

}
