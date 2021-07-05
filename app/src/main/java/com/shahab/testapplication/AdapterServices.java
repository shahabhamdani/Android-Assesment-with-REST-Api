package com.shahab.testapplication;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterServices extends RecyclerView.Adapter<AdapterServices.HolderServices> {

    private Context context;
    public int num;

    public AdapterServices(Context context, int num) {
        this.context = context;
        this.num = num;
    }

    @NonNull
    @Override
    public HolderServices onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout
        View view = LayoutInflater.from(context).inflate(R.layout.row_services, parent, false);
        return new HolderServices(view);
    }


    @Override
    public void onBindViewHolder(@NonNull HolderServices holder, int position) {


    }

    @Override
    public int getItemCount() {
        return num;
    }

    //Hold views of recyclerview
    class HolderServices extends RecyclerView.ViewHolder {


        public HolderServices(@NonNull View itemView) {
            super(itemView);

        }
    }
}