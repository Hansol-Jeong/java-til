package com.company;

public class DecideTurns {
   static Player firstPlayer,secondPlayer;//winner에서 꺼내쓸꺼야

    public void decideFirstTurn(Player A, Player B) {

        double randomValue;
        randomValue= Math.random();
            if(randomValue<0.5){
                firstPlayer = A;
                secondPlayer = B;
            }
            else {
                firstPlayer = B;
                secondPlayer = A;
            }
    }
}
