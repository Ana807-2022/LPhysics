package com.example.learnphysics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;

public class HowToUseApp extends AppCompatActivity {
    Button back;
    TextView howToUseApp1;
    TextView howToUseApp2;
    TextView howToUseApp3;
    TextView howToUseApp4;

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_use_app);

        back = (Button) findViewById(R.id.back_how_to_use_app);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        howToUseApp1 = (TextView) findViewById(R.id.text_how_to_use_App_1);
        howToUseApp2 = (TextView) findViewById(R.id.text_how_to_use_App_2);
        howToUseApp3 = (TextView) findViewById(R.id.text_how_to_use_App_3);
        howToUseApp4 = (TextView) findViewById(R.id.text_how_to_use_App_4);

        try {
            InputStream ist = getAssets().open("how_to_use_app.txt");
            int size = ist.available();
            byte[] buff = new byte[size];
            ist.read(buff);
            ist.close();
            text = new String(buff);

        } catch (Exception e) {
            e.printStackTrace();
            text+=e;
        }
        String[] divided = text.split("//#");

        howToUseApp1.setText(divided[0]);
        howToUseApp2.setText(divided[1]);
        howToUseApp3.setText(divided[2]);
        howToUseApp4.setText(divided[3]);
    }
}