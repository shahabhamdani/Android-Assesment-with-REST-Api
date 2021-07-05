package com.shahab.testapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        checkStoragePermission();
        checkCameraPermission();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, BaseActivity.class));
                finish();
            }
        }, 5000);

    }

   public void checkStoragePermission(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (getApplicationContext().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(SplashScreenActivity.this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
            else{
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        }
        else{
            Toast.makeText(SplashScreenActivity.this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkCameraPermission(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (getApplicationContext().checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(SplashScreenActivity.this, "Camera Permission Granted", Toast.LENGTH_SHORT).show();
            else{
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
            }
        }
        else{
            Toast.makeText(SplashScreenActivity.this, "Camera Permission Granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1){
            Toast.makeText(SplashScreenActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
        }
        else {

            Toast.makeText(SplashScreenActivity.this, "Permission Not Granted", Toast.LENGTH_SHORT).show();

        }
    }
}


