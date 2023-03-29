package com.example.learnphysics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView howToUseApp;
    private ImageView aboutApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(Activity1.class);
            }
        });
        howToUseApp = (ImageView) findViewById(R.id.imageView_HowToUseApp);
        howToUseApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(HowToUseApp.class);
            }
        });
        aboutApp = (ImageView) findViewById(R.id.imageView_aboutApp);
        aboutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(AboutApp.class);
            }
        });
    }


    public void openActivity(Class cl){
        Intent intent = new Intent(getApplicationContext(),cl);
        startActivity(intent);
    }
}
