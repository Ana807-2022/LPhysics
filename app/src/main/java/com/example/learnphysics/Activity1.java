package com.example.learnphysics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class Activity1 extends AppCompatActivity {
    Button back;
    Button a;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        back = (Button) findViewById(R.id.back1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(MainActivity.class);
            }
        });
        a = (Button) findViewById(R.id.buttonA);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(Activity1a.class);
            }
        });
        b = (Button) findViewById(R.id.buttonB);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(Activity1b.class);
            }
        });
    }
    public void openActivity(Class openClass){
        startActivity(new Intent(this,openClass));
    }
}