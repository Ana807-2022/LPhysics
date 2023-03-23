package com.example.learnphysics;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
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

public class Activity1a1 extends AppCompatActivity {
    int red;
    int green;
    //image.setImageDrawable(getDrawable(R.d.picture));
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
    String[] items1 = {"движется", "не движется"};
    String[] items2 = {"движутся", "не движутся"};
    String[] items3var1 = {"балкона в четвёртом этаже", "пола лифта" , "ступенек"};
    String[] items3var2 = {"кассы", "Земли" , "ступенек"};
    String[] items3var3 = {"колёс автомобиля", "сиденья автомобиля" , "дороги"};
    String[] items3var4 = {"сиденья велосипеда" , "деревьев", "домов"};
    String[] items3var5 = {"скамейки" , "человека на скамейке" , "ремня карусели"};
    AutoCompleteTextView actv1;
    AutoCompleteTextView actv2;
    AutoCompleteTextView actv3;
    AutoCompleteTextView actv4;
    AutoCompleteTextView actv5;

    com.google.android.material.textfield.TextInputLayout drop1;
    com.google.android.material.textfield.TextInputLayout drop2;
    com.google.android.material.textfield.TextInputLayout drop3;
    com.google.android.material.textfield.TextInputLayout drop4;
    com.google.android.material.textfield.TextInputLayout drop5;

    TextView case1;
    TextView case2;
    TextView case3;
    TextView case4;
    TextView case5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1a1);

        red = getColor(R.color.red);
        green = getColor(R.color.green);


        p = getIntent().getIntExtra("position",0);

        ////////////////////////
        try{
            File f = getApplicationContext().getFilesDir();
            File path;
            if(p == 0){
                path = new File(f,"answer1a1.txt");
            }else if(p == 1){
                path = new File(f,"answer1a2.txt");
            }else{
                path = new File(f,"answer1a3.txt");
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
        TextView t = (TextView) findViewById(R.id.question1a1);
        try {
            InputStream is;
            if(p == 0){
                is = getAssets().open("exercise1a1.txt");
            }else if(p == 1){
                is = getAssets().open("exercise1a2.txt");
            }else{
                is = getAssets().open("exercise1a3.txt");
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
        t.setText(text);


        ////////////////////////
        text2 = " ";
        answer = (TextView) findViewById(R.id.answer1a1);
        try {
            InputStream is;
            if(p == 0){
                is = getAssets().open("answer1a1.txt");
            }else if(p == 1){
                is = getAssets().open("answer1a2.txt");
            }else{
                is = getAssets().open("answer1a3.txt");
            }
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text2 = new String(buffer);

        } catch (Exception e) {
            e.printStackTrace();
            text2 += e;
        }
        answer.setText(text2);
        answer.setVisibility(View.GONE);


        ///////////////////////////
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, R.layout.dropdawn_menu, exeption);
        ArrayAdapter<String> adp1 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, exeption);
        ArrayAdapter<String> adp2 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, exeption);
        ArrayAdapter<String> adp3 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, exeption);
        ArrayAdapter<String> adp4 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, exeption);
        ArrayAdapter<String> adp5 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, exeption);

        if(p == 0){
            adp = new ArrayAdapter<>(this, R.layout.dropdawn_menu, items1);
        }else if(p == 1){
            adp = new ArrayAdapter<>(this, R.layout.dropdawn_menu, items2);
        }else{
            adp1 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, items3var1);
            adp2 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, items3var2);
            adp3 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, items3var3);
            adp4 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, items3var4);
            adp5 = new ArrayAdapter<>(this, R.layout.dropdawn_menu, items3var5);
        }


        actv1 = (AutoCompleteTextView) findViewById(R.id.answer1);
        actv2 = (AutoCompleteTextView) findViewById(R.id.answer2);
        actv3 = (AutoCompleteTextView) findViewById(R.id.answer3);
        actv4 = (AutoCompleteTextView) findViewById(R.id.answer4);
        actv5 = (AutoCompleteTextView) findViewById(R.id.answer5);

        case1 = (TextView) findViewById(R.id.quest1);
        case2 = (TextView) findViewById(R.id.quest2);
        case3 = (TextView) findViewById(R.id.quest3);
        case4 = (TextView) findViewById(R.id.quest4);
        case5 = (TextView) findViewById(R.id.quest5);

        drop1 = findViewById(R.id.dropdawn1);
        drop2 = findViewById(R.id.dropdawn2);
        drop3 = findViewById(R.id.dropdawn3);
        drop4 = findViewById(R.id.dropdawn4);
        drop5 = findViewById(R.id.dropdawn5);



        if(p == 0){
            drop5.setVisibility(View.GONE);
            case5.setVisibility(View.GONE);

           case1.setText(R.string.quest1_1);
           case2.setText(R.string.quest1_2);
           case3.setText(R.string.quest1_3);
           case4.setText(R.string.quest1_4);
        }else if (p == 1){
            drop2.setVisibility(View.GONE);
            case2.setVisibility(View.GONE);
            drop3.setVisibility(View.GONE);
            case3.setVisibility(View.GONE);
            drop4.setVisibility(View.GONE);
            case4.setVisibility(View.GONE);
            drop5.setVisibility(View.GONE);
            case5.setVisibility(View.GONE);

            case1.setText(R.string.quest2);
        }else{
            case1.setText(R.string.quest3_1);
            case2.setText(R.string.quest3_2);
            case3.setText(R.string.quest3_3);
            case4.setText(R.string.quest3_4);
            case5.setText(R.string.quest3_5);
        }




        ///////////////////////////
        back = (Button) findViewById(R.id.back6);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });


        ///////////////////////////
        submit = (Button) findViewById(R.id.submit1a1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(x == 0){
                    submit();
                    notClickable();
                }else{
                    Toast.makeText(getApplicationContext(),"Вы уже прошли это задание",Toast.LENGTH_SHORT).show();
                }


            }
        });




        ///////////////////////////
        next = (Button) findViewById(R.id.next1a1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });



        if(x == 0){
            if(p == 0|| p == 1){
                actv1.setAdapter(adp);
                actv2.setAdapter(adp);
                actv3.setAdapter(adp);
                actv4.setAdapter(adp);
            } else  {
                actv1.setAdapter(adp1);
                actv2.setAdapter(adp2);
                actv3.setAdapter(adp3);
                actv4.setAdapter(adp4);
                actv5.setAdapter(adp5);
            }
            submit.setVisibility(View.VISIBLE);

        }else{
            notClickable();
            submit.setVisibility(View.GONE);
           String[] answers = read.split(",");

           if(p == 0){
               if(answers[0].equals("не движется")){
                   drop1.setBackgroundColor(green);
                   actv1.setText("не движется");
               }else{
                   drop1.setBackgroundColor(red);
                   actv1.setText("движется");
               }
               if (answers[1].equals("движется")){
                   drop2.setBackgroundColor(green);
                   actv2.setText("движется");
               }else{
                   drop2.setBackgroundColor(red);
                   actv2.setText("не движется");
               }
               if(answers[2].equals("не движется")){
                   drop3.setBackgroundColor(green);
                   actv3.setText("не движется");
               }else{
                   drop3.setBackgroundColor(red);
                   actv3.setText("движется");
               }
               if(answers[3].equals("движется")){
                   drop4.setBackgroundColor(green);
                   actv4.setText("движется");
               }else{
                   drop4.setBackgroundColor(red);
                   actv4.setText("не движется");
               }
               String pt = answers[4];
               answer.append(pt + "/4 баллов.");
           } else if (p == 1) {
               if(answers[0].equals("не движутся")){
                   drop1.setBackgroundColor(green);
                   actv1.setText("не движутся");
               }else{
                   drop1.setBackgroundColor(red);
                   actv1.setText("движутся");
               }

               String pt = answers[1];
               answer.append(pt + "/1 баллов.");
           }else{
               if(Objects.equals(answers[0], "пола лифта")){
                   drop1.setBackgroundColor(green);
                   actv1.setText("пола лифта");
               }else if(Objects.equals(answers[0], "ступенек")){
                   drop1.setBackgroundColor(red);
                   actv1.setText("ступенек");
               }else {
                   drop1.setBackgroundColor(red);
                   actv1.setText("балкона в четвёртом этаже");
               }

               if(Objects.equals(answers[1], "ступенек")){
                   drop2.setBackgroundColor(green);
                   actv2.setText("ступенек");
               }else if(Objects.equals(answers[1], "Земли")){
                   drop2.setBackgroundColor(red);
                   actv2.setText("Земли");
               }else {
                   drop2.setBackgroundColor(red);
                   actv2.setText("кассы");
               }

               if(Objects.equals(answers[2], "сиденья автомобиля")){
                   drop3.setBackgroundColor(green);
                   actv3.setText("сиденья автомобиля");
               }else if(Objects.equals(answers[2], "дороги")){
                   drop3.setBackgroundColor(red);
                   actv3.setText("дороги");
               }else {
                   drop3.setBackgroundColor(red);
                   actv3.setText("колёс автомобиля");
               }

               if(Objects.equals(answers[3], "сиденья велосипеда")){
                   drop4.setBackgroundColor(green);
                   actv4.setText("сиденья велосипеда");
               }else if(Objects.equals(answers[3], "деревьев")){
                   drop4.setBackgroundColor(red);
                   actv4.setText("деревьев");
               }else {
                   drop4.setBackgroundColor(red);
                   actv4.setText("домов");
               }
               if(Objects.equals(answers[4], "ремня карусели")){
                   drop5.setBackgroundColor(green);
                   actv5.setText("ремня карусели");
               }else if(Objects.equals(answers[4], "скамейки")){
                   drop5.setBackgroundColor(red);
                   actv5.setText("скамейки");
               }else {
                   drop5.setBackgroundColor(red);
                   actv5.setText("человека на скамейке");
               }

               String pt = answers[5];
               answer.append(pt + "/5 баллов.");
           }


           answer.setVisibility(View.VISIBLE);

       }


    }

    public void notClickable(){
        drop1.setEnabled(false);
        drop2.setEnabled(false);
        drop3.setEnabled(false);
        drop4.setEnabled(false);
        drop5.setEnabled(false);
    }


    public void back() {
        Intent i = new Intent(this, Activity1a.class);
        startActivity(i);
    }

    public void submit() {
        submit.setVisibility(View.GONE);
        if(p == 0){
            if (actv1.getText().toString().equals("не движется")) {
                drop1.setBackgroundColor(green);
                point++;
            } else {
                drop1.setBackgroundColor(red);
            }
            if (actv2.getText().toString().equals("движется")) {
                drop2.setBackgroundColor(green);
                point++;
            } else {
                drop2.setBackgroundColor(red);
            }
            if (actv3.getText().toString().equals("не движется")) {
                drop3.setBackgroundColor(green);
                point++;
            } else {
                drop3.setBackgroundColor(red);
            }
            if (actv4.getText().toString().equals("движется")) {
                drop4.setBackgroundColor(green);
                point++;
            } else {
                drop4.setBackgroundColor(red);
            }

            try {
                File path = getApplicationContext().getFilesDir();
                FileOutputStream writer = new FileOutputStream(new File(path, "answer1a1.txt"));
                String w = actv1.getText().toString() + "," + actv2.getText().toString() + "," + actv3.getText().toString() + "," + actv4.getText().toString()+","+point;
                writer.write(w.getBytes());
                writer.close();


            } catch (Exception e) {
                e.printStackTrace();

            }

            answer.append(point + "/4 баллов.");
        }else if (p == 1){
            if (actv1.getText().toString().equals("не движутся")) {
                drop1.setBackgroundColor(green);
                point++;
            } else {
                drop1.setBackgroundColor(red);
            }

            try {
                File path = getApplicationContext().getFilesDir();
                FileOutputStream writer = new FileOutputStream(new File(path, "answer1a2.txt"));
                String w = actv1.getText().toString() + ","+point;
                writer.write(w.getBytes());
                writer.close();

            } catch (Exception e) {
                e.printStackTrace();

            }

            answer.append(point + "/1 баллов.");
        }else{
            if (actv1.getText().toString().equals("пола лифта")) {
                drop1.setBackgroundColor(green);
                point++;
            } else {
                drop1.setBackgroundColor(red);
            }
            if (actv2.getText().toString().equals("ступенек")) {
                drop2.setBackgroundColor(green);
                point++;
            } else {
                drop2.setBackgroundColor(red);
            }
            if (actv3.getText().toString().equals("сиденья автомобиля")) {
                drop3.setBackgroundColor(green);
                point++;
            } else {
                drop3.setBackgroundColor(red);
            }
            if (actv4.getText().toString().equals("сиденья велосипеда")) {
                drop4.setBackgroundColor(green);
                point++;
            } else {
                drop4.setBackgroundColor(red);
            }
            if (actv5.getText().toString().equals("ремня карусели")) {
                drop5.setBackgroundColor(green);
                point++;
            } else {
                drop5.setBackgroundColor(red);
            }

            try {
                File path = getApplicationContext().getFilesDir();
                FileOutputStream writer = new FileOutputStream(new File(path, "answer1a3.txt"));
                String w = actv1.getText().toString() + ","+
                        actv2.getText().toString() + ","+
                        actv3.getText().toString() + ","+
                        actv4.getText().toString() + ","+
                        actv5.getText().toString() + ","+point;
                writer.write(w.getBytes());
                writer.close();

            } catch (Exception e) {
                e.printStackTrace();

            }

            answer.append(point + "/5 баллов.");
        }

        point = 0;
        answer.setVisibility(View.VISIBLE);
        submit.setClickable(false);

    }
    public void next() {
        Intent i;
        if(p < 2){
            i = new Intent(getApplicationContext(),Activity1a1.class);
        }else{
            i = new Intent(getApplicationContext(),Activity1a2.class);
        }

        i.putExtra("position",p+1);
        startActivity(i);

    }
}