package com.example.ikeabachelorapp;

import java.util.ArrayList;

public class Assembly {
    private int iD;
    private String webGL;
    private int buildTime;
    private int buildDifficulty;
    private ArrayList<Instruction> instructions;

    public Assembly(int iD, String webGL, int buildTime, int buildDifficulty, ArrayList<Instruction> instructions) {
        this.iD = iD;
        this.webGL = webGL;
        this.buildTime = buildTime;
        this.buildDifficulty = buildDifficulty;
        this.instructions = instructions;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getWebGL() {
        return webGL;
    }

    public void setWebGL(String webGL) {
        this.webGL = webGL;
    }

    public int getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(int buildTime) {
        this.buildTime = buildTime;
    }

    public int getBuildDifficulty() {
        return buildDifficulty;
    }

    public void setBuildDifficulty(int buildDifficulty) {
        this.buildDifficulty = buildDifficulty;
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }
}
