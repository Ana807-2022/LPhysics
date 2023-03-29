package com.example.learnphysics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Activity1b extends AppCompatActivity {
    Button again_pass_tests;
    Button back;
    Button v;

    String read;
    int[] x = new int[5];

    int count = 0;
    int falseCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1b);

        file(0,"answer1b1.txt");
        file(1,"answer1b2.txt");
        file(2,"answer1b3.txt");
        file(3,"answer1b4.txt");
        file(4,"answer1b5.txt");

        back = (Button) findViewById(R.id.back1b);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
        Row[] item = {
                new Row(false,"упражнение номер 1",0),
                new Row(false,"упражнение номер 2",1)
        };
        for(int i = 0;i < item.length; i++){
            if(x[i]==0){
                item[i].setPassed(false);
                falseCount++;

            }else{
                item[i].setPassed(true);
            }
        }

        for(int i = 0;i < item.length; i++){
            if(item[i].getPassed()==true){
                count++;
            }
        }
        Row[] tasks = {
                new Row(false,"0",-1),
                new Row(false,"0",-1),
        };
        for(int i = 0;i < tasks.length;i++){
            if(item[i].getPassed() == false){
                for(int j = 0 ; j < falseCount ; j++){
                    if(tasks[j].getNum() == -1){
                        tasks[j] = item[i];
                        break;
                    }
                }
            }else{
                for(int j = falseCount ; j < 5 ; j++){
                    if(tasks[j].getNum() == -1){
                        tasks[j] = item[i];
                        break;
                    }
                }
            }
        }

        ListView lv = findViewById(R.id.lv1b);
        AdapterLV ad = new AdapterLV(this,tasks,2);
        lv.setAdapter(ad);


        v = (Button) findViewById(R.id.theme1b);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                act1b();
            }
        });


        again_pass_tests = (Button) findViewById(R.id.again1b);
        if(count == 2){
            again_pass_tests.setVisibility(View.VISIBLE);
        }else{
            again_pass_tests.setVisibility(View.INVISIBLE);
        }
        again_pass_tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                againPassTests();
            }
        });

    }
    public void back(){
        Intent i = new Intent(this,Activity1.class);
        startActivity(i);
    }
    public void act1b(){
        Intent i = new Intent(this,Activity1bB.class);
        startActivity(i);
    }
    public void writeInFile(String fileName,String text){
        try {
            File path = getApplicationContext().getFilesDir();
            FileOutputStream writer = new FileOutputStream(new File(path, fileName));
            writer.write(text.getBytes());
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public void file(int i,String fileName){
        try{
            File f = getApplicationContext().getFilesDir();
            File path = new File(f,fileName);
            byte[] some = new byte[(int)path.length()];
            FileInputStream s = new FileInputStream(path);
            s.read(some);
            read = new String(some);
            x[i] = read.length();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void againPassTests(){
        writeInFile("answer1b1.txt",null);
        writeInFile("answer1b2.txt",null);
        writeInFile("answer1b3.txt",null);
        writeInFile("answer1b4.txt",null);
        writeInFile("answer1b5.txt",null);
        Intent intent = new Intent(getApplicationContext(),Activity1b.class);
        startActivity(intent);

    }
}