package com.shahab.testapplication;


import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<String> imagesArray, textArray;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setHasOptionsMenu(true);

        Toolbar govToolBar = view.findViewById(R.id.govtServicesToolBar);

        govToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.workingWithGovtItem:

                    case R.id.housingPropertyItem:

                    case R.id.vehicleAndTransportItem:

                        BaseActivity.bottomNav.setSelectedItemId(R.id.btNavServices);
                        return true;
                }

                return false;
            }
        });

        imagesArray = new ArrayList<String>();
        textArray = new ArrayList<String>();


        generateNewsLayout(view, inflater);
        generateGovtServicesLayout(view, inflater);
        generatePaymentLayout(view, inflater);
        generateOtherLayout(view, inflater);

        return view;

    }

    public void generateNewsLayout(View view, LayoutInflater inflater) {

        imagesArray.clear();
        textArray.clear();
        LinearLayout newsGalleryLl = view.findViewById(R.id.newsGallery);

        //storing news images to array
        imagesArray.add("https://img.etimg.com/thumb/msid-81064562,width-650,imgsize-177910,,resizemode-4,quality-100/file-photo-file-photo-an-employee-works-inside-the-mahindra-mahindra-manufacturing-plant-in-chakan.jpg");
        imagesArray.add("https://ichef.bbci.co.uk/news/976/cpsprodpb/FDB4/production/_119184946_325e2acc-adb2-418e-8cc6-6d4d1f3748f0.jpg");
        imagesArray.add("https://img.etimg.com/thumb/msid-81064562,width-650,imgsize-177910,,resizemode-4,quality-100/file-photo-file-photo-an-employee-works-inside-the-mahindra-mahindra-manufacturing-plant-in-chakan.jpg");
        imagesArray.add("https://ichef.bbci.co.uk/news/976/cpsprodpb/172E4/production/_119184949_d724f2a3-8e5d-44ce-b10c-113381efa05f.jpg");

        //storing news text to array
        textArray.add("UptimeAI, a startup specialising in artificial intelligence-based predictive maintenance software for heavy industries, has raised $1.5 million");
        textArray.add("England captain Harry Kane (right) scores the second goal during the Uefa Euro 2020 football match against Germany at Wembley Stadium in London, securing his side's place in the quarter-finals.");
        textArray.add("UptimeAI, a startup specialising in artificial intelligence-based predictive maintenance software for heavy industries, has raised $1.5 million");
        textArray.add("Lightning crosses the sky as people look at buildings displaying a light show on the eve of the 100th anniversary of the Chinese Communist Party in Beijing");

        //setting news images to gallery
        for (int i = 0; i < imagesArray.size(); i++) {

            View view1 = inflater.inflate(R.layout.card_news, newsGalleryLl, false);
            TextView textView = view1.findViewById(R.id.newsText);
            ImageView imageView = view1.findViewById(R.id.newsImage);

            textView.setText(textArray.get(i));
            Picasso.get().load(imagesArray.get(i)).into(imageView);
            newsGalleryLl.addView(view1);

        }
    }


    public void generateGovtServicesLayout(View view, LayoutInflater inflater) {


        LinearLayout govtServicesNavLl = view.findViewById(R.id.govtServicesNavLl);


        //clearing both arrays to store new values
        imagesArray.clear();
        textArray.clear();

        //storing govt service images to array
        imagesArray.add("https://cdns.iconmonstr.com/wp-content/assets/preview/2017/240/iconmonstr-building-36.png");
        imagesArray.add("https://cdns.iconmonstr.com/wp-content/assets/preview/2016/240/iconmonstr-car-3.png");
        imagesArray.add("https://pic.onlinewebfonts.com/svg/img_453814.png");
        imagesArray.add("https://cdns.iconmonstr.com/wp-content/assets/preview/2018/240/iconmonstr-play-thin.png");

        //storing govt service text to array
        textArray.add("Working with Government");
        textArray.add("Vehicles and Transport");
        textArray.add("House and Property");
        textArray.add("Media");

        for (int i = 0; i < 4; i++) {

            View view1 = inflater.inflate(R.layout.card_center_nav, govtServicesNavLl, false);

            TextView textView = view1.findViewById(R.id.centerNavTv);
            ImageView imageView = view1.findViewById(R.id.centerNavIv);

            textView.setText(textArray.get(i));
            Picasso.get().load(imagesArray.get(i)).into(imageView);
            govtServicesNavLl.addView(view1);

        }

    }


    public void generateOtherLayout(View view, LayoutInflater inflater) {


        LinearLayout otherLl = view.findViewById(R.id.otherLl);


        //clearing both arrays to store new values
        imagesArray.clear();
        textArray.clear();

        //storing govt service images to array
        imagesArray.add("https://cdns.iconmonstr.com/wp-content/assets/preview/2017/240/iconmonstr-medical-7.png");
        imagesArray.add("https://cdns.iconmonstr.com/wp-content/assets/preview/2012/240/iconmonstr-newspaper-7.png");
        imagesArray.add("https://cdns.iconmonstr.com/wp-content/assets/preview/2017/240/iconmonstr-medical-13.png");
        imagesArray.add("https://cdns.iconmonstr.com/wp-content/assets/preview/2017/240/iconmonstr-book-28.png");

        //storing govt service text to array
        textArray.add("Utility Bills");
        textArray.add("Sharjah 24 News");
        textArray.add("Medcine App");
        textArray.add("Sharjah Library");

        for (int i = 0; i < 4; i++) {

            View view1 = inflater.inflate(R.layout.card_center_nav, otherLl, false);

            TextView textView = view1.findViewById(R.id.centerNavTv);
            ImageView imageView = view1.findViewById(R.id.centerNavIv);

            textView.setText(textArray.get(i));
            Picasso.get().load(imagesArray.get(i)).into(imageView);
            otherLl.addView(view1);

        }

    }

    public void generatePaymentLayout(View view, LayoutInflater inflater) {

        imagesArray.clear();
        textArray.clear();

        LinearLayout paymentHistoryLl = view.findViewById(R.id.paymentHistoryLl);

        //setting menu cards to payment history liner layout menu
        for (int i = 0; i < 4; i++) {

            View view1 = inflater.inflate(R.layout.card_payment_history, paymentHistoryLl, false);
            paymentHistoryLl.addView(view1);

        }

    }

}
