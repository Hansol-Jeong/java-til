package com.company;

public class BattlePhase {
    Player player;
    Character character;
    Character attacker;
    String state;
    int playerSpeedBar=0;
    int characterSpeedBar=0;
    public BattlePhase(Player player, Character character) {
        this.player = player; this.character = character;
        int random= (int) (Math.random()*10%2);
        if(random>5)
            state="조우";
        else
            state="기습";
    }
    public void exe(String state) {
        if(state.equals("조우"))  {
            while(player.getHealth()>0||character.getHealth()>0) {
                attacker=player;

            }
        }
    }
    public void endBattle() {

    }
    public Character fillSpeedBar(Player player, Character character) {
        while(playerSpeedBar>10||characterSpeedBar>10) {
            playerSpeedBar += player.getAttackSpeed();
            characterSpeedBar += character.getAttackSpeed();
        }
        if(playerSpeedBar>=10&&characterSpeedBar>=10) {
            attacker=playerSpeedBar>characterSpeedBar?player:character;
            playerSpeedBar=0; characterSpeedBar=0;
            return attacker;
        }
        else if(playerSpeedBar>=10&&characterSpeedBar<10) {
            attacker=player;
            playerSpeedBar=0;
            return attacker;
        }
        else {
            attacker=character;
            characterSpeedBar=0;
            return attacker;
        }

    }
}
