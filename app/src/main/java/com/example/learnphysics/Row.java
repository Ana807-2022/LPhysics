package com.example.learnphysics;

public class Row {
    Boolean passed;
    String name;

    int num;
    public Row(Boolean passed, String name, int num){
        this.passed = passed;
        this.name = name;
        this.num = num;

    }

    public Boolean getPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
