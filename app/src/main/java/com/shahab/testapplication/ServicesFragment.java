package com.shahab.testapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ServicesFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services, container, false);

        RecyclerView serviceRv = view.findViewById(R.id.servicesRv);
        AdapterServices adapterServices = new AdapterServices(view.getContext(), 5);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 1, GridLayoutManager.VERTICAL, false);

        serviceRv.setLayoutManager(gridLayoutManager);
        //set adapter to recyclerview
        serviceRv.setAdapter(adapterServices);

        return view;
    }
}
