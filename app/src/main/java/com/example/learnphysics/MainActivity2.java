package com.example.learnphysics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnphysics.Activity1;
import com.example.learnphysics.MainActivity;
import com.example.learnphysics.R;

public class MainActivity2 extends AppCompatActivity {
    Button back ;
    Button but1 ;
    Button but2 ;
    Button but3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
        but1 = (Button) findViewById(R.id.but1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                act1();
            }
        });
    }
    public void back(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void act1(){
        Intent i = new Intent(this, Activity1.class);
        startActivity(i);
    }
}