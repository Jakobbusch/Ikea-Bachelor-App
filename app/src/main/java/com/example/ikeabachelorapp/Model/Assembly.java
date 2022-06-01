package com.example.ikeabachelorapp.Model;

import java.util.ArrayList;

public class Assembly {
    private int iD;
    private String webGL;
    private int buildTime;
    private int buildDifficulty;
    private ArrayList<Instruction> instructions;

    /**
     * Assembly Constructor
     * @param iD
     * @param webGL
     * @param buildTime
     * @param buildDifficulty
     * @param instructions
     */
    public Assembly(int iD, String webGL, int buildTime, int buildDifficulty, ArrayList<Instruction> instructions) {
        this.iD = iD;
        this.webGL = webGL;
        this.buildTime = buildTime;
        this.buildDifficulty = buildDifficulty;
        this.instructions = instructions;
    }

    /**
     * Get ID
     * @return iD
     */
    public int getiD() {
        return iD;
    }

    /**
     * Set ID
     * @param iD
     */
    public void setiD(int iD) {
        this.iD = iD;
    }

    /**
     * Get WebGL
     * @return webGL
     */
    public String getWebGL() {
        return webGL;
    }

    /**
     * Set WebGL
     * @param webGL
     */
    public void setWebGL(String webGL) {
        this.webGL = webGL;
    }

    /**
     * Get Build Time
     * @return buildTime
     */
    public int getBuildTime() {
        return buildTime;
    }

    /**
     * Set Build Time
     * @param buildTime
     */
    public void setBuildTime(int buildTime) {
        this.buildTime = buildTime;
    }

    /**
     * Get Build Difficulty
     * @return buildDifficulty
     */
    public int getBuildDifficulty() {
        return buildDifficulty;
    }

    /**
     * Set Build Difficulty
     * @param buildDifficulty
     */
    public void setBuildDifficulty(int buildDifficulty) {
        this.buildDifficulty = buildDifficulty;
    }

    /**
     *  Get list of Instructions
     * @return instructions
     */
    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    /**
     * Set list of Instructions
     * @param instructions
     */
    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }
}
