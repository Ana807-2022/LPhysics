package com.example.learnphysics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.InputStream;

public class Activity1bB extends AppCompatActivity {
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1b_b);
        text1 = (TextView) findViewById(R.id.text1bB_1);
        text2 = (TextView) findViewById(R.id.text1bB_2);
        text3 = (TextView) findViewById(R.id.text1bB_3);
        text4 = (TextView) findViewById(R.id.text1bB_4);
        text5 = (TextView) findViewById(R.id.text1bB_5);
        String text = "";
        try {
            InputStream is = getAssets().open("text1bB.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);

        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] d = text.split("//#");
        text1.setText(d[0]);
        text2.setText(d[1]);
        text3.setText(d[2]);
        text4.setText(d[3]);
        text5.setText(d[4]);

        Button back = (Button) findViewById(R.id.back1bB);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Activity1b.class));
            }
        });

    }
}