package com.company;

import java.util.Scanner;

public class Player {
    protected String name;
    protected boolean winOrNot=false;
    protected boolean detoritMustStopThisSequence_TypeUp = false;
    protected boolean detoritMustStopThisSequence_Typedown = false;
    protected boolean detoritMustStopThisSequence_Typeright = false;
    protected boolean detoritMustStopThisSequence_Typeleft = false;
    protected boolean detoritMustStopThisSequence_TypeUpRight = false;
    protected boolean detoritMustStopThisSequence_TypeUpLeft = false;
    protected boolean detoritMustStopThisSequence_TypeDownright = false;
    protected boolean detoritMustStopThisSequence_TypeDownLeft = false;

    protected boolean detoritMustStopThisSequence_TypeBetweenUp = false;
    protected boolean detoritMustStopThisSequence_TypeBetweenDown = false;
    protected boolean detoritMustStopThisSequence_TypeBetweenRight = false;
    protected boolean detoritMustStopThisSequence_TypeBetweenLeft = false;
    protected boolean detoritMustStopThisSequence_TypeBetweenUpRight = false;
    protected boolean detoritMustStopThisSequence_TypeBetweenUpLeft = false;
    protected boolean detoritMustStopThisSequence_TypeBetweenDownRight = false;
    protected boolean detoritMustStopThisSequence_TypeBetweenDownLeft = false;

    int upCount=0, downCount=0, leftCount=0, rightCount=0, rightUpCount=0, rightDownCount=0, leftUpCount=0, lefDownCount=0;
    int BetweenUpCount=0, BetweenDownCount=0, BetweenLeftCount=0, BetweenRightCount=0, BetweenRightUpCount=0, BetweenRightDownCount=0, BetweenLeftUpCount=0, BetweenLeftDownCount=0;

    protected int winCount;

    public void setPlayerName() {
        Scanner scan = new Scanner(System.in);
        this.name=scan.nextLine();
    }

    public String getPlayerName() {
        return name;
    }

    public void winOrNotReset (){
        winOrNot=false;
    }
}
