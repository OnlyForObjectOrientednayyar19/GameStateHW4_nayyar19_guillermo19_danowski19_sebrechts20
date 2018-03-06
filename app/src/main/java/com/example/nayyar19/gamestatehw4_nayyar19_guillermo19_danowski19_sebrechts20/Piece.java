package com.example.nayyar19.gamestatehw4_nayyar19_guillermo19_danowski19_sebrechts20;


import android.graphics.Paint;

/**
 * Created by ravin on 2/28/2018.
 */

public class Piece {
    private int xPos;
    private int yPos;
    private int counter;
    private Paint paint;
    private int pieceId;
    int playerId;
    private boolean outOfStart;


    int[][] greenPath = {   {0,0},       { 8, 1 }, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 },
            { 9, 6 }, { 10, 6 }, { 11, 6 }, { 12, 6 }, { 13, 6 }, { 14, 6 },
            { 14, 7 }, { 14, 8 }, { 13, 8 }, { 12, 8 }, { 11, 8 }, { 10, 8 },
            { 9, 8 }, { 8, 9 }, {8, 10 }, { 8, 11 }, { 8, 12 }, { 8, 13 },
            { 8, 14 }, { 7, 14 }, { 6, 14 }, { 6, 13 }, { 6, 12 }, { 6, 11 },
            { 6, 10 }, { 6, 9 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 },
            { 1, 8}, { 0, 8 }, { 0, 7 }, { 0, 6 }, { 1, 6 }, { 2, 6 },
            { 3, 6 }, { 4, 6 }, { 5, 6 }, { 6, 5 }, { 6, 4}, { 6, 3 },
            { 6, 2 }, { 6, 1 }, { 6, 0 }, { 7, 0 }, { 7, 1 }, { 7, 2 },
            { 7, 3 }, { 7, 4 }, { 7, 5 }, { 7, 6 } };

    int[][] yellowPath = {{0,0},    { 13, 8 }, { 12, 8 }, { 11, 8 }, { 10, 8 },
            { 9, 8 }, { 8, 9 }, {8, 10 }, { 8, 11 }, { 8, 12 }, { 8, 13 },
            { 8, 14 }, { 7, 14 }, { 6, 14 }, { 6, 13 }, { 6, 12 }, { 6, 11 },
            { 6, 10 }, { 6, 9 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 },
            { 1, 8}, { 0, 8 }, { 0, 7 }, { 0, 6 }, { 1, 6 }, { 2, 6 },
            { 3, 6 }, { 4, 6 }, { 5, 6 }, { 6, 5 }, { 6, 4}, { 6, 3 },
            { 6, 2 }, { 6, 1 }, { 6, 0 }, { 7, 0 },{ 8, 0 },
            { 8, 1 }, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 },
            { 9, 6 }, { 10, 6 }, { 11, 6 }, { 12, 6 }, { 13, 6 }, { 14, 6 },
            { 14, 7 }, { 13, 7 }, { 12, 7 }, { 11, 7 }, { 10, 7 }, { 9, 7 }, { 8, 7 }};

    int[][] bluePath = {{0,0},  { 6, 13 }, { 6, 12 }, { 6, 11 },
            { 6, 10 }, { 6, 9 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 },
            { 1, 8}, { 0, 8 }, { 0, 7 }, { 0, 6 }, { 1, 6 }, { 2, 6 },
            { 3, 6 }, { 4, 6 }, { 5, 6 }, { 6, 5 }, { 6, 4}, { 6, 3 },
            { 6, 2 }, { 6, 1 }, { 6, 0 }, { 7, 0 },{ 8, 0 },
            { 8, 1 }, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 },
            { 9, 6 }, { 10, 6 }, { 11, 6 }, { 12, 6 }, { 13, 6 }, { 14, 6 },
            { 14, 7 }, { 14, 8 }, { 13, 8 }, { 12, 8 }, { 11, 8 }, { 10, 8 },
            { 9, 8 }, { 8, 9 }, {8, 10 }, { 8, 11 }, { 8, 12 }, { 8, 13 },
            { 8, 14 }, { 7, 14 }, { 7, 13 }, { 7, 12 }, { 7, 11 }, { 7, 10 }, { 7, 9 }, { 7, 8 }};

    int[][] redPath = {{0,0},   { 1, 6 }, { 2, 6 },
            { 3, 6 }, { 4, 6 }, { 5, 6 }, { 6, 5 }, { 6, 4}, { 6, 3 },
            { 6, 2 }, { 6, 1 }, { 6, 0 }, { 7, 0 },{ 8, 0 },
            { 8, 1 }, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 },
            { 9, 6 }, { 10, 6 }, { 11, 6 }, { 12, 6 }, { 13, 6 }, { 14, 6 },
            { 14, 7 }, { 14, 8 }, { 13, 8 }, { 12, 8 }, { 11, 8 }, { 10, 8 },
            { 9, 8 }, { 8, 9 }, {8, 10 }, { 8, 11 }, { 8, 12 }, { 8, 13 },
            { 8, 14 }, { 7, 14 }, { 6, 14 },{ 6, 13 }, { 6, 12 }, { 6, 11 },
            { 6, 10 }, { 6, 9 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 },
            { 1, 8}, { 0, 8 }, { 0, 7 }, { 1, 7 }, { 2, 7 }, { 3, 7 }, { 4, 7 }, { 5, 7 }, { 6, 7 }};

    /**
     The following below initializes all the variables that are going to be used in the
     piece class. These pieces are to be used on the board of Ludo.

     @param xPos
     @param yPos
     @param paint
     @param pieceId
     */
    public Piece(int xPos, int yPos, Paint paint, int pieceId, int playerId) {
        this.outOfStart = false;
        this.xPos=xPos;
        this.yPos=yPos;
        this.counter = 0;
        this.paint=paint;
        this.pieceId = pieceId;
        this.playerId = playerId;

        setXandYpos();

    }


    //Getters
    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getCounter() {
        return counter;
    }

    public Paint getPaint() {
        return paint;
    }

    public int getPieceId() {
        return pieceId;
    }

    public int getPlayerId(){
        return playerId;
    }

    public boolean isOutOfStart() {
        return outOfStart;
    }


    //Setters
    public void setXandYpos() {
        if(counter>58) {counter=58;}
            if(this.playerId ==1){
            this.xPos = redPath[counter][0];
            this.yPos = redPath[counter][1];
        }
        else if(this.playerId == 2){
            this.xPos = greenPath[counter][0];
            this.yPos = greenPath[counter][1];

        }
        else if (this.playerId ==3){
            this.xPos = bluePath[counter][0];
            this.yPos = bluePath[counter][1];
        }
        else if (this.playerId ==4){
            this.xPos = yellowPath[counter][0];
            this.yPos = yellowPath[counter][1];
        }
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public void setPieceId(int pieceId) {
        this.pieceId = pieceId;
    }

    public void setPlayerId(int playerId){
        this.playerId = playerId;
    }

    public void setOutOfStart(boolean outOfStart) {
        this.outOfStart = outOfStart;
    }



}
