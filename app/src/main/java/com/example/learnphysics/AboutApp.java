package com.example.learnphysics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;

public class AboutApp extends AppCompatActivity {
    TextView information;
    TextView thanks;

    Button back;

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        information = (TextView) findViewById(R.id.text_about_app);
        thanks = (TextView) findViewById(R.id.text_about_app_thanks);

        back = (Button) findViewById(R.id.back_about_app);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

        try {
            InputStream ist = getAssets().open("about_app.txt");
            int size = ist.available();
            byte[] buff = new byte[size];
            ist.read(buff);
            ist.close();
            text = new String(buff);

        } catch (Exception e) {
            e.printStackTrace();
            text+=e;
        }
        String[] del = text.split("//#");
        information.setText(del[0]);
        thanks.setText(del[1]);

    }
    public void back(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}