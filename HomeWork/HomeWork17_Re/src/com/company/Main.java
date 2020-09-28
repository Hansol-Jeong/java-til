package com.company;

import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    static Player player = new Player();
    public static void main(String[] args) {
        ConsumerList consumerList = new ConsumerList();
        Scanner scan = new Scanner(System.in);
//        Chapter1.
        {//템창 튜토리얼
            player.addWeapon(Weapon.Bare_Hand);
            consumerList.Narration.accept("-사악한 용이 휩쓸고간 마을-");
            consumerList.Hero.accept("장로님...! 좀만 버텨보세요");
            consumerList.NPC1_elder.accept("설명할 시간이 없네 p를 눌러 어서 인벤토리 창을 열어보게 어서...! 저 용을 무찌를 사람은 자네뿐이야...");
            consumerList.SYSTEM.accept("p를 눌러 포션백을 여십시오");
            pushP();
            consumerList.NPC1_elder.accept("역시 아무것도없군....그렇다면 w를 눌러서 웨폰케이스를...어서...!");
            consumerList.SYSTEM.accept("w를 눌러 웨폰 케이스를 여십시오");
            pushW();
            consumerList.NPC1_elder.accept("젠장...자네 가진게뭔가...가진거라곤 그 멀쩡한 두 손뿐이군... 빨리 이걸 받게");
            player.addPotion(Potion.Low_Class_Stat_Amplification_Potion);
            player.addWeapon(Weapon.Short_Sword);
            consumerList.NPC1_elder.accept("자네 스텟은...스텟은...!");
            consumerList.SYSTEM.accept("s를 눌러 스텟을 확인하세요");
            pushS();
            consumerList.NPC1_elder.accept("(젠장...개똥망캐구만...)이것도받아...그리고 빨리 사용해...");
            player.addItem(Item.Elders_Soul);
            player.useItem(Item.Elders_Soul);
            consumerList.NPC1_elder.accept("부디 우리마을의 원수를...!");
            consumerList.SYSTEM_SomthingDead.accept("장로 할아버지");
        }
//        Chpter2.
        {//전투 튜토리얼
            consumerList.Narration.accept("-왕국 수도로 가는 숲길-");
            System.out.println("???: 이봐 거기 너");
            scan.nextLine();
            consumerList.SpeedWagon.accept("그래 너 말이야 너...그대로 숲으로 들어갔다간 살아남지 못할거다");
            scan.nextLine();
            consumerList.SpeedWagon.accept("좋아 아무것도 모른다고 하니 내가 하나부터 열까지 다알려주지 전투를 시작하기 전엔 준비가 필요해 아이템도 바꿔야하고 포션도 먹어야하지 그냥 들어갔다간 도륙이나버릴거라구");
            scan.nextLine();
            consumerList.SpeedWagon.accept("우선 무기를 바꿔야한다 내가 너가가진 무기보다 좋은 무기를 줄 테니 한번 웨폰케이스로 들어가서 바꿔봐");
            consumerList.SpeedWagon.accept("네 인벤토리의 무기를 터미널창에 적으면 무기가 바뀌고 'Auto'라고 적으면 네 무기중 데미지가 가장 센걸로 장착될거야");
            player.addWeapon(Weapon.Long_Sword);
            player.beforeBattleWeaponchange();
            consumerList.SpeedWagon.accept("전투 전에 물약을 빼 놓을 수 없겠지? 내가 너의 스텟용 물약과 무기용 물약, 막타 데미지+ 물약 세가지를 줄 테니 각각 먹고 저기있는 허수아비를 때려봐");
            player.addPotion(Potion.Low_Class_Stat_Amplification_Potion); player.addPotion(Potion.Weapon_Slush); player.addPotion(Potion.Amplification_Final_Attack_Potion);
            player.usePotion(Potion.Low_Class_Stat_Amplification_Potion); player.usePotion(Potion.Weapon_Slush); player.usePotion(Potion.Amplification_Final_Attack_Potion);

            System.out.println();
            System.out.println("1턴");
            System.out.println("사용 중인 포션: "+ player.usingPotionList);

            new BattlePhase(player,new Forest_Ghoul());
            consumerList.SpeedWagon.accept("흥, 어느정도 애송이티는 벗엇군. 마침 저기 '배회하는 구울'이 보이는걸. 그럼 잘해보라구.");


        }
    }

    private static void pushP () {
        Scanner scan = new Scanner(System.in);
        if (scan.nextLine().equals("p")) {
            player.showPotion();
        }
    }
    private static void pushW () {
        Scanner scan = new Scanner(System.in);
        if (scan.nextLine().equals("w")) {
            player.showWeapon();
        }
    }
    private static void pushS (){
        Scanner scan = new Scanner(System.in);
        if (scan.nextLine().equals("s")) {
            player.showState();
        }
    }}
