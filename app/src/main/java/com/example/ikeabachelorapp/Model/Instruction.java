package com.example.ikeabachelorapp.Model;

public class Instruction {
    private int iD;
    private int stepNumber;
    private String text;

    /**
     * Constructor Instruction
     * @param iD
     * @param stepNumber
     * @param text
     */
    public Instruction(int iD, int stepNumber, String text) {
        this.iD = iD;
        this.stepNumber = stepNumber;
        this.text = text;
    }

    /**
     * Get iD
     * @return iD
     */
    public int getiD() {
        return iD;
    }

    /**
     * Set iD
     * @param iD
     */
    public void setiD(int iD) {
        this.iD = iD;
    }

    /**
     * Get Step Number
     * @return stepNumber
     */
    public int getStepNumber() {
        return stepNumber;
    }

    /**
     * Set Step Number
     * @param stepNumber
     */
    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    /**
     * Get text
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Set text
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }
}
