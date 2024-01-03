package com.example.healthcaremain;

public class Exercise {
    String exename;
    String exekal;

    public Exercise(){

    }
    public Exercise(String exename, String exekal){
        this.exename = exename;
        this.exekal = exekal;
    }

    public String getexeName() {
        return exename;
    }

    public String getexeKal() {
        return exekal;
    }
}
