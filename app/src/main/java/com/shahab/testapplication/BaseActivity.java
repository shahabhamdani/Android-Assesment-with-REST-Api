package com.shahab.testapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

public class BaseActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    Toolbar govtServicesToolbar;
    public static BottomNavigationView bottomNav;
    FrameLayout frameLayout = null;
    Fragment selectedFragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        //setting up toolbar
        setUpToolbar();

        frameLayout = findViewById(R.id.fragmentContainer);

        //init components
        bottomNav = findViewById(R.id.bottomNavigation);
        bottomNav.setOnNavigationItemSelectedListener(navListner);
        bottomNav.setSelectedItemId(R.id.btNavHome);

    }

    public void setUpToolbar() {
        try {
            drawerLayout = findViewById(R.id.drawerLayout);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //creating bottom navigation click listner
    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @SuppressLint("WrongViewCast")
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    selectedFragment = null;

                    switch (item.getItemId()) {

                        case R.id.btNavHome:
                            selectedFragment = new HomeFragment();
                            break;

                        case R.id.btNavServices:
                            selectedFragment = new ServicesFragment();

                            break;

                        case R.id.btNavPosts:
                            selectedFragment = new PostsFragment();
                            break;
                    }


                    //setting selected fragment to fragment container
                    getSupportFragmentManager().beginTransaction().replace(frameLayout.getId(), selectedFragment).commit();
                    return true;
                }
            };

}