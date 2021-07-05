package com.shahab.testapplication;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.HolderUser> {

    private Context context;
    public ArrayList<Users> usersArrayList;

    public AdapterUser(Context context, ArrayList<Users> usersArrayList) {
        this.context = context;
        this.usersArrayList = usersArrayList;
    }

    @NonNull
    @Override
    public HolderUser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout
        View view = LayoutInflater.from(context).inflate(R.layout.row_users, parent, false);
        return new HolderUser(view);
    }


    @Override
    public void onBindViewHolder(@NonNull HolderUser holder, int position) {
        //get data
        final Users users = usersArrayList.get(position);

        int userId = users.getUserId();
        int id = users.getId();
        String title = users.getTitle();
        String body = users.getBody();


        //set data
        holder.userIdTv.setText("" + userId);
        holder.idTv.setText("" + id);
        holder.titleTv.setText(title);
        holder.bodyTv.setText(body);
    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    //Hold views of recyclerview
    class HolderUser extends RecyclerView.ViewHolder {

        private TextView userIdTv, idTv, titleTv, bodyTv;

        public HolderUser(@NonNull View itemView) {
            super(itemView);

            userIdTv = itemView.findViewById(R.id.userIdTv);
            idTv = itemView.findViewById(R.id.idTv);
            titleTv = itemView.findViewById(R.id.titleTV);
            bodyTv = itemView.findViewById(R.id.bodyTv);

        }
    }
}