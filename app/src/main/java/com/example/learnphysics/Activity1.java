package com.example.learnphysics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity {
    Button back;
    Button a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        back = (Button) findViewById(R.id.back1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
        a = (Button) findViewById(R.id.buttonA);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a();
            }
        });
    }
    public void back(){
        Intent i = new Intent(this,MainActivity2.class);
        startActivity(i);
    }
    public void a(){
        Intent i = new Intent(this,Activity1a.class);
        startActivity(i);
    }
}