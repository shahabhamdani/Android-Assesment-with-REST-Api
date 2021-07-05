package com.shahab.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsFragment extends Fragment {

    private List<Users> usersList = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);


        //fetch Button Event
        Button fetchBtn = view.findViewById(R.id.btnFetchData);
        fetchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //getting data from api
                getUsers(view);

            }
        });
        return view;

    }

    public void getUsers(View view) {


        Call<List<Users>> call = RetrofitClient.getInstance().getMyApi().getUsers();
        call.enqueue(new Callback<List<Users>>() {

            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                usersList = response.body();

                AdapterUser adapterUser = new AdapterUser(getContext(), (ArrayList<Users>) usersList);

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);

                RecyclerView usersRv = view.findViewById(R.id.usersDataRv);
                usersRv.setLayoutManager(gridLayoutManager);
                //set adapter to recyclerview
                usersRv.setAdapter(adapterUser);
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

            }
        });

    }
}
