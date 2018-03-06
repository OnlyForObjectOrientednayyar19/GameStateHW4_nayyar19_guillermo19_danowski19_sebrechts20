package com.example.nayyar19.gamestatehw4_nayyar19_guillermo19_danowski19_sebrechts20;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;



/**
 * This contains the state for the LUDO game.
 *
 * @author Ravi Nayyar, Avery Guillermo, Luke Danoswki, Chris Sebrechts
 * @version March 2018
 */
public class LudoState{
    protected Random gen  = new Random();
    private int playerToMove;

    private String forThePurposeofPrinting = "";
    String masterMethodOutput = " ";
    String outputDiceVal = "The Dice has yet to be rolled";
    String outputchangeplauerturn = "It is still the current player's turn";
    String outputCheckAvailableMoves = "Not able to check available moves";
    String outputSimulator = "The human simulator has yet to make a decision";
    String outputPieceInBase = "The piece is in its base";
    String outputAllPiecesInBase = "All pieces are in the base";
    String outputBase2Start = "Base2Start: All pieces are in the base";

    Piece red_piece1;
    Piece red_piece2;
    Piece red_piece3;
    Piece red_piece4;
    ArrayList<Piece> redPieceArray = new ArrayList<Piece>();
    ArrayList<Piece> greenPieceArray = new ArrayList<Piece>();
    ArrayList<Piece> bluePieceArray = new ArrayList<Piece>();
    ArrayList<Piece> yellowPieceArray = new ArrayList<Piece>();
    ArrayList<Piece> TotalPieceArray = new ArrayList<Piece>();
    Piece green_piece1;
    Piece green_piece2;
    Piece green_piece3;
    Piece green_piece4;

    Piece blue_piece1;
    Piece blue_piece2;
    Piece blue_piece3;
    Piece blue_piece4;

    Piece yellow_piece1;
    Piece yellow_piece2;
    Piece yellow_piece3;
    Piece yellow_piece4;

    Piece lastMoved;
    int DiceVal=0;
    EditText eText;
    Random rChoice = new Random();
    // to satisfy Serializable interface
    private static final long serialVersionUID = 8089703039705311997L;

    /**
     * Ludo Default Constructor
     *
     * initializes all 16 ludo pieces, dice, etc and adds all the pieces into
     * thier respective arrays
     */
    public LudoState(){
        Paint redPaint = new Paint();
        Paint greenPaint = new Paint();
        Paint bluePaint = new Paint();
        Paint yellowPaint = new Paint();
        redPaint.setColor(Color.RED);
        greenPaint.setColor(Color.GREEN);
        bluePaint.setColor(Color.BLUE);
        yellowPaint.setColor(Color.YELLOW);

        red_piece1 = new Piece(0,0, redPaint, 1,1);
        red_piece2 = new Piece(0,0, redPaint, 2,1);
        red_piece3 = new Piece(0,0, redPaint, 3,1);
        red_piece4 = new Piece(0,0, redPaint, 4,1);
        //Array holding the red pieces
        redPieceArray.add(red_piece1);
        redPieceArray.add(red_piece2);
        redPieceArray.add(red_piece3);
        redPieceArray.add(red_piece4);
        
        //Array holding the green pieces
        green_piece1 = new Piece(0,0, greenPaint, 5,2);
        green_piece2 = new Piece(0,0, greenPaint, 6,2);
        green_piece3 = new Piece(0,0, greenPaint, 7,2);
        green_piece4 = new Piece(0,0, greenPaint, 8,2);
        greenPieceArray.add(green_piece1);
        greenPieceArray.add(green_piece2);
        greenPieceArray.add(green_piece3);
        greenPieceArray.add(green_piece4);

        blue_piece1 = new Piece(0,0, bluePaint, 9,3);
        blue_piece2 = new Piece(0,0, bluePaint, 10,3);
        blue_piece3 = new Piece(0,0, bluePaint, 11,3);
        blue_piece4 = new Piece(0,0, bluePaint, 12,3);

        //Array holding the blue pieces
        bluePieceArray.add(blue_piece1);
        bluePieceArray.add(blue_piece2);
        bluePieceArray.add(blue_piece3);
        bluePieceArray.add(blue_piece4);

        yellow_piece1 = new Piece(0,0, yellowPaint, 13,4);
        yellow_piece2 = new Piece(0,0, yellowPaint, 14,4);
        yellow_piece3 = new Piece(0,0, yellowPaint, 15,4);
        yellow_piece4 = new Piece(0,0, yellowPaint, 16,4);
        //Array holding the yellow pieces
        yellowPieceArray.add(yellow_piece1);
        yellowPieceArray.add(yellow_piece2);
        yellowPieceArray.add(yellow_piece3);
        yellowPieceArray.add(yellow_piece4);

        //Adding every Piece to the TotalPieceArray
        TotalPieceArray.add(red_piece1);
        TotalPieceArray.add(red_piece2);
        TotalPieceArray.add(red_piece3);
        TotalPieceArray.add(red_piece4);
        TotalPieceArray.add(green_piece1);
        TotalPieceArray.add(green_piece2);
        TotalPieceArray.add(green_piece3);
        TotalPieceArray.add(green_piece4);
        TotalPieceArray.add(blue_piece1);
        TotalPieceArray.add(blue_piece2);
        TotalPieceArray.add(blue_piece3);
        TotalPieceArray.add(blue_piece4);
        TotalPieceArray.add(yellow_piece1);
        TotalPieceArray.add(yellow_piece2);
        TotalPieceArray.add(yellow_piece3);
        TotalPieceArray.add(yellow_piece4);
        playerToMove =1;
    }
    /**
     * Ludo Deep Copy Constructor
     *
     * takes a deep copy of all 16 ludo pieces, dice, etc and takes special care to
     * copy each object in its own array.
     */
    public LudoState(LudoState original){
        red_piece1 = original.red_piece1;
        red_piece2 = original.red_piece2;
        red_piece3 = original.red_piece3;
        red_piece4 = original.red_piece4;

        green_piece1 = original.green_piece1;
        green_piece2 = original.green_piece2;
        green_piece3 = original.green_piece3;
        green_piece4 = original.green_piece4;

        blue_piece1 = original.blue_piece1;
        blue_piece2 = original.blue_piece2;
        blue_piece3 = original.blue_piece3;
        blue_piece4 = original.blue_piece4;

        yellow_piece1 = original.yellow_piece1;
        yellow_piece2 = original.yellow_piece2;
        yellow_piece3 = original.yellow_piece3;
        yellow_piece4 = original.yellow_piece4;

        playerToMove = original.playerToMove;

        for (Piece p: original.TotalPieceArray) {
            TotalPieceArray.add(p);
        }

        for (Piece p: original.redPieceArray) {
            redPieceArray.add(p);
        }

        for (Piece p: original.greenPieceArray) {
            greenPieceArray.add(p);
        }

        for (Piece p: original.bluePieceArray) {
            bluePieceArray.add(p);
        }

        for (Piece p: original.yellowPieceArray) {
            yellowPieceArray.add(p);
        }

         outputDiceVal = original.outputDiceVal;
         outputchangeplauerturn = original.outputchangeplauerturn;
         outputCheckAvailableMoves = original.outputCheckAvailableMoves;
          outputPieceInBase = original.outputPieceInBase;
          outputAllPiecesInBase = original.outputAllPiecesInBase;
         outputBase2Start = original.outputBase2Start;
    }
    /**SetPlayerToMove     *
     * @param num the player id one wants to set
     * @return the playerId
     */
    public int setPlayerToMove(int num){
        playerToMove = num;
        outputchangeplauerturn = "The current player is Player "+playerToMove;
        return playerToMove;
    }

    /**GetDiceVal
     *  gets the value of the dice
     */
    public int getDiceVal(){
        return this.DiceVal;
    }

    /**setDiceVal
     * This sets a number between 1 and six as the value of the dice
     * for testing purposes
     * @param diceVal the input dice value
     */
    public void setDiceVal(int diceVal){
        this.DiceVal = diceVal;
    }

    /**Roll Dice
     * sets a random number between 1 and 7 to simulate a dice roll
     * @param playerid the player who is rolling the dice
     * @return true of the player equasl the current player
     *          false if the player does not equal the current player
     */
     public boolean rollDice(int playerid){
        if(playerToMove == playerid){
            DiceVal = gen.nextInt(6)+1; // 0-6 + 1  = 1-7
           //  MovePiece(playerid,red_piece1);
           //  lastMoved = red_piece1;
            //   checkAvailableMoves(playerid);
            outputDiceVal = "Player "+playerid+" has rolled a "+DiceVal;
            return true;
        }
        else{
            return false;
        }
    }

    /**ChangePlayerTurn
     * This method changes the current player
     */
    public void changePlayerTurn() {

        forThePurposeofPrinting = ""+playerToMove;
        playerToMove++;
        if(playerToMove == 5) {
            playerToMove = 1;
        }
        outputchangeplauerturn = "The current player is Player "+playerToMove;
    }//changePlayerTurn

    /**CheckAvailableMoves
     * all decisions stem from this one class and it is broken up into 4 different cases.
     *  1) Case 1: Player does not roll a 6, no pieces out of start
     *  2) Case 2: Player rolls a 6, no pieces out of homebase
     *  3) Case 3: Player rolls the dice, 1-3 pieces out of homebase
     *  4) Case 4: Player rolls a number between 1-4 and has no pieces in the homebase
     *
     * @param playerId
     */
    public void checkAvailableMoves(int playerId) {
        //Case 1: Player does not roll a 6, no pieces out of start
        if (DiceVal != 6 && allPiecesInBase(playerId)) {
            //Change the current player to to next player.
            //changePlayerTurn();
            outputCheckAvailableMoves = "Player does not roll a 6 and has no pieces out of start";
        }

        //Case 2: Player rolls a 6, no pieces out of homebase
        else if (DiceVal == 6 && allPiecesInBase(playerId)) {
            if (playerId == 1) {
                Base2Start(playerId, red_piece1);
            }
            else if (playerId == 2) {
                Base2Start(playerId, blue_piece1);
            }
            else if (playerId == 3) {
                Base2Start(playerId, green_piece1);
            }
            else if (playerId == 4) {
                Base2Start(playerId, yellow_piece1);
            }
            outputCheckAvailableMoves = "Player rolls a 6, no pieces out of homebase";
        }

        //Case 3: Player rolls the dice, 1-3 pieces out of homebase
        else if(getPieceInBase(playerId) != null){
            if(DiceVal == 6){
                //Base2Start
                Base2Start(playerId, getPieceInBase(playerId));
                forThePurposeofPrinting = " "+playerToMove;
            }
            else if(DiceVal !=6){
                //Move onBoard Dieces
                MovePiece(playerId, getFurthestAhead(playerId));
                //changePlayerTurn();
            }
            outputCheckAvailableMoves = "Player rolls the dice, 1-3 pieces out of homebase";
         }

        //case 4: Player rolls a number between 1-4 and has no pieces in the homebase
        else if(getPieceInBase(playerId) == null){
            if(DiceVal ==6){
                MovePiece(playerId, getFurthestAhead(playerId));
                forThePurposeofPrinting = " "+playerToMove;
            }
            else{
                MovePiece(playerId, getFurthestAhead(playerId));
                //changePlayerTurn();
            }
            outputCheckAvailableMoves = "All four of the players pieces are out of the homebase";
        }
        }//checkAvailableMoves


    /** MovePiece
     * This increments the counter value that is held by each piece. The counter is incremented by the
     * value of the dice roll
     * @param playerId the id of the player whose piece is bieng moved
     * @param p the piece that is actually miving
     * @return  true if the player and the current player are the same, false if they are not.
     */
    public boolean MovePiece(int playerId, Piece p) {
        //If it is the players turn and if the piece chosen is on the player controlls
        if (playerToMove == playerId && p.getPlayerId() == playerId) {
            for(int i=0; i<this.DiceVal;i++){
                //increment the pieces counter attribute by the dice roll value
                p.setCounter(p.getCounter()+1);
                p.setXandYpos();
            }
            outputBase2Start = "A piece was not moved from Base to start";
            //setting the last moved piece equal to the piece passed in
            lastMoved = p;
            return true;
        }
        return false;
    }//movePiece

    //Simulates a human making a decision
    public int twoChoiceSimulator()
    {
        int r;
        r = rChoice.nextInt(2);
        return r;
    }

    /**GetPieceInBase
     * determines to see if given a player's id, if any of their respective pieces
     * are residing in the homebase
     *
     * @param playerId the id of the player whose piece is bieng moved
     * @return a piece that is inside the base
     */
    //If one or more pieces are in the base
    public Piece getPieceInBase(int playerId) {
        if (playerId == 1) {
            for (Piece p : redPieceArray) {
                if (!(p.isOutOfStart())) {
                    outputPieceInBase = "There is one or more red pieces in the base";
                    return p;
                }
            }
        }
        if (playerId == 2) {
            for (Piece p : greenPieceArray) {
                if (!(p.isOutOfStart())) {
                    outputPieceInBase = "There is one or more green pieces in the base";
                    return p;
                }
            }
        }
        if (playerId == 3) {
            for (Piece p : bluePieceArray) {
                if (!(p.isOutOfStart())) {
                    outputPieceInBase = "There is one or more blue pieces in the base";
                    return p;
                }
            }
        }
        if (playerId == 4) {
            for (Piece p : yellowPieceArray) {
                if (!(p.isOutOfStart())) {
                    outputPieceInBase = "There is one or more yelllow pieces in the base";
                    return p;
                }
            }
        }
        return null;
    }

    /**getFurthestAhead
     * find the piece in a given array that has travelled the farthest along its specific color path
     * @param playerId the id of the player whose piece is bieng moved
     * @return the piece that is the farthest along
     */
    public Piece getFurthestAhead(int playerId) {
        String outputFurthestAhead = "This has determined the piece that is furthest along";
        if (playerId == 1) {
            return greaterthan(greaterthan(red_piece1, red_piece2), greaterthan(red_piece3, red_piece4));
        }
        if (playerId == 2) {
            return greaterthan(greaterthan(green_piece1, green_piece2), greaterthan(green_piece3, green_piece4));
        }
        if (playerId == 3) {
            return greaterthan(greaterthan(blue_piece1, blue_piece2), greaterthan(blue_piece3, blue_piece4));
        }
        if (playerId == 4) {
            return greaterthan(greaterthan(yellow_piece1, yellow_piece2), greaterthan(yellow_piece3, yellow_piece4));
        }
        return null;
    }

    /**greatherThan
     *
     * works as the underlying basis for the getFurthestAhead method
     * finds the largest counter value between two pieces
     *
     * @param p1 the first piece to compare
     * @param p2 the second piece to compare
     * @return the greater of the two pieces
     */
    //returns the furthest piece along.
    public Piece greaterthan(Piece p1, Piece p2){
        int x = p1.getCounter();
        int y = p2.getCounter();
        if(x>y){return p1;}
        else{return p2;}
    }

    /**AllPiecesInBase
     * This determines if all of the pieces are in the base
     * @param playerId the id of the player whose piece is bieng viewed
     * @return false if the base is not filled with pieces
     *          true if the base is filled with pieces
     */
     //If the specified base is filled with all the pieces
    public boolean allPiecesInBase(int playerId){
          for (Piece p: TotalPieceArray) {
            if (p.playerId == playerId && p.isOutOfStart() == true) {
                outputAllPiecesInBase = "The base is not filled with all its pieces";
                return false;
            }
        }
        outputAllPiecesInBase = "The base is filled with its pieces";
        return true;
    }

    /**Base2Start
     *
     * This method brings a piece from the homebase to the hardcoded start tile (based on the pieces
     * color)
     *
     * @param playerId the id of the player whose piece is bieng moved
     * @param p the piece that will be moved
     * @return it always returns false
     */
    private boolean Base2Start(int playerId, Piece p){
        if(playerId==1){
            p.setCounter(1);
            p.setOutOfStart(true);
        }
        if(playerId==2){
            p.setCounter(1);
            p.setOutOfStart(true);
        }
        if(playerId==3){
            p.setCounter(1);
            p.setOutOfStart(true);
        }
        if(playerId==4){
            p.setCounter(1);
            p.setOutOfStart(true);
        }
        outputBase2Start = "A piece was moved from Base to start";
        return false;

    }

    /**toString
     *
     * this method takes strings that have been inserted throughout the code
     * strings the strings together and outputs them to an EditText textbox.
     *
     * @return returns the string that is outputted to the textbox
     */
    @Override
       public String toString(){
        outputDiceVal = "" + this.getDiceVal();
        String methodOutputs = outputchangeplauerturn +"\n"+ outputCheckAvailableMoves+"\n"+ outputPieceInBase+"\n"+ outputAllPiecesInBase+"\n"+ outputBase2Start+"\n\n";

         String players = "It is the turn of Player "+(""+playerToMove)+" who rolled a "+DiceVal+"\n";
         String open = " ";//"RED: \t\t\t 1, 2, 3, 4: ";
         String redPos = "R1: "+red_piece1.getCounter() +" \tR2: "+red_piece2.getCounter()+" \tR3: " +red_piece3.getCounter() +" \tR4: "+red_piece4.getCounter();
         String open1 = "\n\n ";//"\nGREEN:\t 1, 2, 3, 4: ";
         String greenPos = "G1: "+green_piece1.getCounter() +" \tG2: "+green_piece2.getCounter() +" \tG3: "+green_piece3.getCounter()+" \tG4: " +green_piece4.getCounter();
         String open2 = "\n\n ";//"\nBLUE: \t\t 1, 2, 3, 4: ";
         String bluePos = "B1: "+blue_piece1.getCounter()+" \tB2: " +blue_piece2.getCounter()+" \tB3: " +blue_piece3.getCounter() +" \tB4: "+blue_piece4.getCounter();
         String open3 = "\n\n ";//"\nYELLOW: \t 1, 2, 3, 4: ";
         String yellowPos = "Y1: "+yellow_piece1.getCounter() +" \tY2: "+yellow_piece2.getCounter()+" \tY3: " +yellow_piece3.getCounter() +" \tY4: "+yellow_piece4.getCounter();

        return  methodOutputs+players+open+redPos+open1+greenPos+open2+bluePos+open3+yellowPos+"\n";
    }

} //LudoState

