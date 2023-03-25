package com.example.learnphysics;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import java.io.InputStream;

public class Activity1Aa extends AppCompatActivity {
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_aa);
        String text = " ";
        TextView textA = (TextView) findViewById(R.id.textttA);
        try {
            InputStream is = getAssets().open("text1Aa1.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);

        } catch (Exception e) {
            e.printStackTrace();
            text+=e;
        }
        textA.setText(text);

        TextView textB = (TextView) findViewById(R.id.textttB);
        try {
            InputStream ist = getAssets().open("text1Aa2.txt");
            int size = ist.available();
            byte[] buff = new byte[size];
            ist.read(buff);
            ist.close();
            text = new String(buff);

        } catch (Exception e) {
            e.printStackTrace();
            text+=e;
        }
        textB.setText(text);

        TextView textC = (TextView) findViewById(R.id.textttC);
        try {
            InputStream ist = getAssets().open("text1Aa3.txt");
            int size = ist.available();
            byte[] buff = new byte[size];
            ist.read(buff);
            ist.close();
            text = new String(buff);

        } catch (Exception e) {
            e.printStackTrace();
            text+=e;
        }
        textC.setText(text);

        TextView textD = (TextView) findViewById(R.id.textttD);
        try {
            InputStream ist = getAssets().open("text1Aa4.txt");
            int size = ist.available();
            byte[] buff = new byte[size];
            ist.read(buff);
            ist.close();
            text = new String(buff);

        } catch (Exception e) {
            e.printStackTrace();
            text+=e;
        }
        textD.setText(text);




        back = (Button) findViewById(R.id.back5);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
    }
    public void back(){
        Intent i = new Intent(this,Activity1a.class);
        startActivity(i);
    }
}