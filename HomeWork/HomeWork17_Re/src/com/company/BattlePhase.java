package com.company;

public class BattlePhase {
    ConsumerList consumerList = new ConsumerList();
    Character character1;
    Character character2;
    Character attacker;
    Character defender;
    int character1_speedBar=0;
    int character2_speedBar=0;

    public BattlePhase(Character character1, Character character2) {
        this.character1 = character1;
        this.character2 = character2;
        battle1();
    }

    public void battle1() {
        while(character1.getRemainHealth()>0&&character2.getRemainHealth()>=0) {
            chooseAttacker();
            defender.setRemainHealth(attacker.getTotalDamage());
            consumerList.SYSTEM_Battle1.accept(attacker.getName(), defender.getName());
            consumerList.SYSTEM.accept("총" + attacker.getTotalDamage() +"의 데미지를 받았습니다");
            consumerList.SYSTEM.accept(attacker.getName()+"의 남은체력: "+attacker.getRemainHealth()+" " + defender.getName()+"의 남은체력: "+defender.getRemainHealth());
            if(character1.getRemainHealth()<0) {
                consumerList.SYSTEM.accept(character2.getName()+"이(가) 승리하였습니다.");
                break;
            }
            else {
                consumerList.SYSTEM.accept(character1.getName()+"이(가) 승리하였습니다.");
                break;
            }
        }

    }

    public void chooseAttacker() {
        while(character1_speedBar>=10||character2_speedBar>=10) {
            character1_speedBar+=character1.getAttackSpeed();
            character2_speedBar+=character2.getAttackSpeed();
        }
        if(character1_speedBar>=10&&character2_speedBar>=10) {
            if(character1_speedBar>=character2_speedBar) {
                attacker=character1;
                defender=character2;
            }
            else {
                attacker=character2;
                defender=character1;
            }
            character1_speedBar-=10;
            character2_speedBar-=10;
        }
        else if(character1_speedBar>=10&&character2_speedBar<10) {
            attacker = character1;
            defender = character2;
            character1_speedBar-=10;
        }
        else {
            attacker = character2;
            defender = character1;
            character2_speedBar-=10;
        }
    }
}
