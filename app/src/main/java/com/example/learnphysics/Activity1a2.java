package com.example.learnphysics;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Activity1a2 extends AppCompatActivity {
    //image.setImageDrawable(getDrawable(R.d.picture));

    int red;
    int green;
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
    EditText editText;

    AutoCompleteTextView autoCompleteTextView;
    com.google.android.material.textfield.TextInputLayout drop;

    String[] array1 = {"м","км","см","кг"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1a2);

        red = getColor(R.color.red);
        green = getColor(R.color.green);



        p = getIntent().getIntExtra("position",0);

        ////////////////////////
        try{
            File f = getApplicationContext().getFilesDir();
            File path;
            if (p == 3){
                path = new File(f,"answer1a4.txt");
            }else{
                path = new File(f,"answer1a5.txt");
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
        TextView t = findViewById(R.id.question1a2);
        try {
            InputStream is;
            if(p == 3){
                is = getAssets().open("exercise1a4.txt");
            }else{
                is = getAssets().open("exercise1a5.txt");
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
        answer = findViewById(R.id.answer1a2);
        try {
            InputStream is;
            if(p == 3){
                is = getAssets().open("answer1a4.txt");
            }else{
                is = getAssets().open("answer1a5.txt");
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


        editText = findViewById(R.id.answerOfquestion);

        drop = findViewById(R.id.dropdawn_1a2);

        autoCompleteTextView = findViewById(R.id.answer_1a2);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.dropdawn_menu,array1);

        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setDropDownBackgroundResource(R.drawable.filter_spinner_dropdawn);





        ///////////////////////////
        back = findViewById(R.id.back7);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back1a2();
            }
        });


        ///////////////////////////
        submit = findViewById(R.id.submit1a2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(x == 0){
                    submit1a2();
                }else{
                    Toast.makeText(getApplicationContext(),"Вы уже прошли это задание",Toast.LENGTH_SHORT).show();
                }


            }
        });




        ///////////////////////////
        next = findViewById(R.id.next1a2);
        if(p == 4){
            next.setVisibility(View.GONE);
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next1a2();
            }
        });
    if(x != 0){
        notClickable();
        submit.setVisibility(View.GONE);

        String[] answers = read.split(",");
        if(p == 3){
            if(answers[0].equals("10") && answers[1].equals("м")|| answers[0].equals("0.01")  && answers[1].equals("км")||answers[0].equals("1000")  && answers[1].equals("см")){
                editText.setBackgroundTintList(ColorStateList.valueOf(green));
                editText.setTextColor(green);
                drop.setBackgroundResource(R.drawable.r_answer);
            }else{
                editText.setBackgroundTintList(ColorStateList.valueOf(red));
                editText.setTextColor(red);
                drop.setBackgroundResource(R.drawable.f_answer);
            }
        }else{
            if(answers[0].equals("9") && answers[1].equals("м")|| answers[0].equals("0.009")  && answers[1].equals("км")||answers[0].equals("900")  && answers[1].equals("см")){
                editText.setBackgroundTintList(ColorStateList.valueOf(green));
                editText.setTextColor(green);
                drop.setBackgroundResource(R.drawable.r_answer);
            }else{
                editText.setBackgroundTintList(ColorStateList.valueOf(red));
                editText.setTextColor(red);
                drop.setBackgroundResource(R.drawable.f_answer);
            }
        }

        editText.setText(answers[0]);
        autoCompleteTextView.setText(answers[1]);
        String pt = answers[2];
        answer.append(pt + "/1 баллов.");
        answer.setVisibility(View.VISIBLE);
        }else{
        submit.setVisibility(View.VISIBLE);
    }
    }


    public void notClickable(){
        editText.setEnabled(false);
    }


    public void back1a2() {
        Intent i = new Intent(this, Activity1a.class);
        startActivity(i);
    }

    public void submit1a2() {
        if (editText.getText().toString().equals("") && autoCompleteTextView.getText().toString().equals("") ) {
            Toast.makeText(getApplicationContext(), "Заполните поля", Toast.LENGTH_SHORT).show();
        } else if (editText.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Заполните первое поле", Toast.LENGTH_SHORT).show();
            } else if(autoCompleteTextView.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Заполните второе поле", Toast.LENGTH_SHORT).show();
        } else{
                if(check(editText.getText().toString(), autoCompleteTextView.getText().toString()) == 2){
                }else {
                    try {
                        File path = getApplicationContext().getFilesDir();
                        FileOutputStream writer;
                        if(p == 3){
                            writer = new FileOutputStream(new File(path, "answer1a4.txt"));
                        }else {
                            writer = new FileOutputStream(new File(path, "answer1a5.txt"));
                        }
                        String w = editText.getText().toString() + ","+autoCompleteTextView.getText().toString() + ","+point;
                        writer.write(w.getBytes());
                        writer.close();

                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                    submit.setVisibility(View.GONE);
                    if(check(editText.getText().toString(), autoCompleteTextView.getText().toString()) == 0){
                        point++;
                        editText.setBackgroundTintList(ColorStateList.valueOf(green));
                        editText.setTextColor(green);
                        drop.setBackgroundResource(R.drawable.r_answer);
                    } else if (check(editText.getText().toString(), autoCompleteTextView.getText().toString()) == 1) {
                        editText.setBackgroundTintList(ColorStateList.valueOf(red));
                        editText.setTextColor(red);
                        drop.setBackgroundResource(R.drawable.f_answer);
                    }
                    answer.append(point + "/1 баллов.");
                    point = 0;
                    answer.setVisibility(View.VISIBLE);
                    notClickable();
                }
            }


    }
    public void next1a2() {
        Intent i = new Intent(getApplicationContext(),Activity1a2.class);
        i.putExtra("position",p+1);
        startActivity(i);

    }
    public int check(String value,String unit) {
        try{
            Float.parseFloat(value);
            if (p == 3) {
                if (unit.equals("км") && value.equals("0.01") || unit.equals("м") && value.equals("10") || unit.equals("см") && value.equals("1000")) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (unit.equals("км") && value.equals("0.009") || unit.equals("м") && value.equals("9") || unit.equals("см") && value.equals("900")) {
                    return 0;
                } else {
                    return 1;
                }
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "на первом поле напишите только цифру", Toast.LENGTH_SHORT).show();
            return 2;
        }
    }
}