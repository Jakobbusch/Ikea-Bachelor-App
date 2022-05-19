package com.example.ikeabachelorapp;

public class Instruction {
    private int iD;
    private int stepNumber;
    private String text;

    public Instruction(int iD, int stepNumber, String text) {
        this.iD = iD;
        this.stepNumber = stepNumber;
        this.text = text;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
