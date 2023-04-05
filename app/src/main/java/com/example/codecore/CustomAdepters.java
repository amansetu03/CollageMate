package com.example.codecore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdepters extends RecyclerView.Adapter<CustomAdepters.MyViewHolder> {

    ArrayList<String> subject_name;
    ArrayList<String> start_date;
    ArrayList<String> end_date;

    Context cnx;

    public CustomAdepters(ArrayList<String> subject_name, ArrayList<String> start_date, ArrayList<String> end_date, Context cnx) {
        this.subject_name = subject_name;
        this.start_date = start_date;
        this.end_date = end_date;

        this.cnx = cnx;
    }

    @NonNull
    @Override
    public CustomAdepters.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow2,parent,false);
        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdepters.MyViewHolder holder, int position) {
        holder.name.setText(subject_name.get(position));
        holder.startdate.setText(start_date.get(position));
        holder.enddate.setText(end_date.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cnx, subject_name.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return subject_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, startdate, enddate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.displaysubjectname);
            startdate = itemView.findViewById(R.id.displaystartdate);
            enddate = itemView.findViewById(R.id.displayenddate);
        }
    }
}
