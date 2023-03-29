package com.example.learnphysics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Objects;

public class Activity1b1 extends AppCompatActivity {

    int p = 0;
    int x;
    String text;
    String text2;
    String read;
    TextView answer;
    Button back;
    Button submit;
    Button next;
    int point = 0;
    String[] exeption = {"resource not found :)"};
    String[] items1var1 = {"100Н", "1000Н", "10000Н"};
    String[] items1var2 = {"7500Н", "1500Н", "15000Н"};
    String[] items1var3 = {"0.05Н", "0.005Н", "0.1Н"};
    String[] items2var1 = {"30Н", "150Н" , "15Н"};
    String[] items2var2 = {"250Н", "5Н" , "2.5Н"};
    String[] items2var3 = {"25000Н", "250Н" , "5000Н"};
    String[] items2var4 = {"2Н" , "0.002Н", "0.2Н"};
    AutoCompleteTextView actv1;
    AutoCompleteTextView actv2;
    AutoCompleteTextView actv3;
    AutoCompleteTextView actv4;

    com.google.android.material.textfield.TextInputLayout drop1;
    com.google.android.material.textfield.TextInputLayout drop2;
    com.google.android.material.textfield.TextInputLayout drop3;
    com.google.android.material.textfield.TextInputLayout drop4;

    TextView case1;
    TextView case2;
    TextView case3;
    TextView case4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1b1);

        p = getIntent().getIntExtra("position",0);

        ////////////////////////
        try{
            File f = getApplicationContext().getFilesDir();
            File path;
            if(p == 0){
                path = new File(f,"answer1b1.txt");
            }else{
                path = new File(f,"answer1b2.txt");
            }

            byte[] some = new byte[(int)path.length()];
            FileInputStream s = new FileInputStream(path);
            s.read(some);
            read = new String(some);
            x = read.length();


        }catch (Exception e){
            e.printStackTrace();
        }


        ///////////////////////////
        text = " ";
        TextView t = (TextView) findViewById(R.id.question1b1);
        answer = (TextView) findViewById(R.id.answer1b1);
        try {
            InputStream is;
            if(p == 0){
                is = getAssets().open("exercise1b1.txt");
            }else{
                is = getAssets().open("exercise1b2.txt");
            }
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);

        } catch (Exception e) {
            e.printStackTrace();
            text += e;
        }
        String[] d = text.split("//#");
        t.setText(d[0]);
        answer.setText(d[1]);
        answer.setVisibility(View.GONE);


        ///////////////////////////
        ArrayAdapter<String> adp1 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, exeption);
        ArrayAdapter<String> adp2 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, exeption);
        ArrayAdapter<String> adp3 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, exeption);
        ArrayAdapter<String> adp4 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, exeption);

        if(p == 0){
            adp1 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, items1var1);
            adp2 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, items1var2);
            adp3 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, items1var3);
        }else{
            adp1 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, items2var1);
            adp2 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, items2var2);
            adp3 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, items2var3);
            adp4 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, items2var4);
        }


        actv1 = (AutoCompleteTextView) findViewById(R.id.answer1b1_1);
        actv2 = (AutoCompleteTextView) findViewById(R.id.answer1b1_2);
        actv3 = (AutoCompleteTextView) findViewById(R.id.answer1b1_3);
        actv4 = (AutoCompleteTextView) findViewById(R.id.answer1b1_4);

        actv1.setDropDownBackgroundResource(R.drawable.filter_spinner_dropdawn);
        actv2.setDropDownBackgroundResource(R.drawable.filter_spinner_dropdawn);
        actv3.setDropDownBackgroundResource(R.drawable.filter_spinner_dropdawn);
        actv4.setDropDownBackgroundResource(R.drawable.filter_spinner_dropdawn);

        case1 = (TextView) findViewById(R.id.quest1b1_1);
        case2 = (TextView) findViewById(R.id.quest1b1_2);
        case3 = (TextView) findViewById(R.id.quest1b1_3);
        case4 = (TextView) findViewById(R.id.quest1b1_4);

        drop1 = findViewById(R.id.dropdawn1b1_1);
        drop2 = findViewById(R.id.dropdawn1b1_2);
        drop3 = findViewById(R.id.dropdawn1b1_3);
        drop4 = findViewById(R.id.dropdawn1b1_4);



        if(p == 0){
            drop4.setVisibility(View.GONE);
            case4.setVisibility(View.GONE);

            case1.setText("m = 100 кг");
            case2.setText("М = 1.5 т");
            case3.setText("m = 5 г");
        }else{
            case1.setText("m = 1.5 кг");
            case2.setText("m = 500г");
            case3.setText("m = 2.5 т");
            case4.setText("m = 20г");
        }




        ///////////////////////////
        back = (Button) findViewById(R.id.back1b1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });


        ///////////////////////////
        submit = (Button) findViewById(R.id.submit1b1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });




        ///////////////////////////
        next = (Button) findViewById(R.id.next1b1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });



        if(x == 0){
            if(p == 0){
                actv1.setAdapter(adp1);
                actv2.setAdapter(adp2);
                actv3.setAdapter(adp3);
                actv4.setAdapter(adp4);
            } else  {
                actv1.setAdapter(adp1);
                actv2.setAdapter(adp2);
                actv3.setAdapter(adp3);
                actv4.setAdapter(adp4);
            }
            submit.setVisibility(View.VISIBLE);

        }else{
            notClickable();
            submit.setVisibility(View.GONE);
            String[] answers = read.split(",");
            if(p == 0){
                if(Objects.equals(answers[0], "1000Н")){
                    drop1.setBackgroundResource(R.drawable.r_answer);
                    actv1.setText("1000Н");
                }else if(Objects.equals(answers[0], "100Н")){
                    drop1.setBackgroundResource(R.drawable.f_answer);
                    actv1.setText("100Н");
                }else {
                    drop1.setBackgroundResource(R.drawable.f_answer);
                    actv1.setText("10000Н");
                }

                if(Objects.equals(answers[1], "15000Н")){
                    drop2.setBackgroundResource(R.drawable.r_answer);
                    actv2.setText("15000Н");
                }else if(Objects.equals(answers[1], "7500Н")){
                    drop2.setBackgroundResource(R.drawable.f_answer);
                    actv2.setText("7500Н");
                }else {
                    drop2.setBackgroundResource(R.drawable.f_answer);
                    actv2.setText("1500Н");
                }
                if(Objects.equals(answers[2], "0.05Н")){
                    drop3.setBackgroundResource(R.drawable.r_answer);
                    actv3.setText("0.05Н");
                }else if(Objects.equals(answers[2], "0.005Н")){
                    drop3.setBackgroundResource(R.drawable.f_answer);
                    actv3.setText("0.005Н");
                }else {
                    drop3.setBackgroundResource(R.drawable.f_answer);
                    actv3.setText("0.1Н");
                }
                String pt = answers[3];
                answer.append(pt + "/3 баллов.");
            }else{
                if(Objects.equals(answers[0], "15Н")){
                    drop1.setBackgroundResource(R.drawable.r_answer);
                    actv1.setText("15Н");
                }else if(Objects.equals(answers[0], "150Н")){
                    drop1.setBackgroundResource(R.drawable.f_answer);
                    actv1.setText("150Н");
                }else {
                    drop1.setBackgroundResource(R.drawable.f_answer);
                    actv1.setText("30Н");
                }

                if(Objects.equals(answers[1], "5Н")){
                    drop2.setBackgroundResource(R.drawable.r_answer);
                    actv2.setText("5Н");
                }else if(Objects.equals(answers[1], "30Н")){
                    drop2.setBackgroundResource(R.drawable.f_answer);
                    actv2.setText("30Н");
                }else {
                    drop2.setBackgroundResource(R.drawable.f_answer);
                    actv2.setText("2.5Н");
                }
                //String[] items2var3 = {"25000Н", "250Н" , "5000Н"};
                //String[] items2var4 = {"2Н" , "0.002Н", "0.2Н"};

                if(Objects.equals(answers[2], "25000Н")){
                    drop3.setBackgroundResource(R.drawable.r_answer);
                    actv3.setText("25000Н");
                }else if(Objects.equals(answers[2], "250Н")){
                    drop3.setBackgroundResource(R.drawable.f_answer);
                    actv3.setText("250Н");
                }else {
                    drop3.setBackgroundResource(R.drawable.f_answer);
                    actv3.setText("0.2Н");
                }

                if(Objects.equals(answers[3], "0.2Н")){
                    drop4.setBackgroundResource(R.drawable.r_answer);
                    actv4.setText("0.2Н");
                }else if(Objects.equals(answers[3], "0.002Н")){
                    drop4.setBackgroundResource(R.drawable.f_answer);
                    actv4.setText("0.002Н");
                }else {
                    drop4.setBackgroundResource(R.drawable.f_answer);
                    actv4.setText("2Н");
                }

                String pt = answers[4];
                answer.append(pt + "/4 баллов.");
            }


            answer.setVisibility(View.VISIBLE);

        }


    }

    public void notClickable(){
        drop1.setEnabled(false);
        drop2.setEnabled(false);
        drop3.setEnabled(false);
        drop4.setEnabled(false);
    }


    public void back() {
        Intent i = new Intent(this, Activity1b.class);
        startActivity(i);
    }

    public void submit() {
        if(p == 0){
            if(actv1.getText().toString().equals("")||actv2.getText().toString().equals("")||actv3.getText().toString().equals("")){
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            }else{
                notClickable();
                submit.setVisibility(View.GONE);
                if (actv1.getText().toString().equals("1000Н")) {
                    drop1.setBackgroundResource(R.drawable.r_answer);
                    point++;
                } else {
                    drop1.setBackgroundResource(R.drawable.f_answer);
                }
                if (actv2.getText().toString().equals("15000Н")) {
                    drop2.setBackgroundResource(R.drawable.r_answer);
                    point++;
                } else {
                    drop2.setBackgroundResource(R.drawable.f_answer);
                }
                if (actv3.getText().toString().equals("0.05Н")) {
                    drop3.setBackgroundResource(R.drawable.r_answer);
                    point++;
                } else {
                    drop3.setBackgroundResource(R.drawable.f_answer);
                }

                try {
                    File path = getApplicationContext().getFilesDir();
                    FileOutputStream writer = new FileOutputStream(new File(path, "answer1b1.txt"));
                    String w = actv1.getText().toString() + "," + actv2.getText().toString() + "," + actv3.getText().toString() + "," +point;
                    writer.write(w.getBytes());
                    writer.close();


                } catch (Exception e) {
                    e.printStackTrace();

                }

                answer.append(point + "/3 баллов.");
                point = 0;
                answer.setVisibility(View.VISIBLE);
            }

        }else{
            if(actv1.getText().toString().equals("")||actv2.getText().toString().equals("")||actv3.getText().toString().equals("")||actv4.getText().toString().equals("")){
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            }else{
                notClickable();
                submit.setVisibility(View.GONE);
                if (actv1.getText().toString().equals("15Н")) {
                    drop1.setBackgroundResource(R.drawable.r_answer);
                    point++;
                } else {
                    drop1.setBackgroundResource(R.drawable.f_answer);
                }
                if (actv2.getText().toString().equals("5Н")) {
                    drop2.setBackgroundResource(R.drawable.r_answer);
                    point++;
                } else {
                    drop2.setBackgroundResource(R.drawable.f_answer);
                }
                if (actv3.getText().toString().equals("25000Н")) {
                    drop3.setBackgroundResource(R.drawable.r_answer);
                    point++;
                } else {
                    drop3.setBackgroundResource(R.drawable.f_answer);
                }
                if (actv4.getText().toString().equals("0.2Н")) {
                    drop4.setBackgroundResource(R.drawable.r_answer);
                    point++;
                } else {
                    drop4.setBackgroundResource(R.drawable.f_answer);
                }

                try {
                    File path = getApplicationContext().getFilesDir();
                    FileOutputStream writer = new FileOutputStream(new File(path, "answer1b2.txt"));
                    String w = actv1.getText().toString() + ","+
                            actv2.getText().toString() + ","+
                            actv3.getText().toString() + ","+
                            actv4.getText().toString() + ","+point;
                    writer.write(w.getBytes());
                    writer.close();

                } catch (Exception e) {
                    e.printStackTrace();

                }

                answer.append(point + "/4 баллов.");
                point = 0;
                answer.setVisibility(View.VISIBLE);
            }

        }

    }
    public void next() {
        Intent i;
        if(p < 1){
            i = new Intent(getApplicationContext(),Activity1b1.class);
        }else{
            i = new Intent(getApplicationContext(),Activity1b2.class);
        }

        i.putExtra("position",p+1);
        startActivity(i);

    }
}