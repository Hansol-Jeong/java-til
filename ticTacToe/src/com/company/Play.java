package com.company;

import java.util.Scanner;

public class Play {
    Player A = new Player();
    Player B = new Player();
    GameType gameType;
    Player [] nameArray;
    public void run() throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        System.out.println("게임규칙은 간단합니다(press enter>>)");
        scan.nextLine();
        System.out.println("3x3의 게임필드에서 플레이어 두명은 서로 번갈아 돌을 놓습니다(press enter>>)");
        scan.nextLine();
        System.out.println("먼저 3개의 돌을 연속으로 놓는 플레이어가 승리합니다(press enter>>)");
        scan.nextLine();
        System.out.println("게임을 시작합니다.(press enter>>)");
        scan.nextLine();
        System.out.println("플레이어의 이름과 상대를 space로 구분해 입력해주세요. 'AI','지옥참마도','디트로이트'를 입력할 경우 자동으로 해당 AI플레이어와 게임을 시작합니다");
        System.out.println("이외의 이름을 쓰면 플레이어 vs 플레이어 대전이 시작됩니다.");
        A.setPlayerName();
        B.setPlayerName();
        nameArray = new Player[2];
        nameArray[0] = A;
        nameArray[1] = B;//배열과 레퍼런스가 같은 데이터를 가리킨다.
        System.out.println(nameArray[0].getPlayerName()+" "+ nameArray[1].getPlayerName());
//        for (int i = 0; i < nameArray.length; i++) {
//            if (nameArray[i].getPlayerName() == "AI")
//                nameArray[i].settingTOAI();
//        }


       if ((nameArray[0].getPlayerName().equals("AI")) ^ (nameArray[1].getPlayerName().equals("AI"))) {//xor연산자 되는지 확이해보고 쓰기
            gameType = new GameType(nameArray[0], nameArray[1]);
            gameType.startMan_VS_AI("Man","AI");
        }

       else if (nameArray[0].getPlayerName().equals("AI") && nameArray[1].getPlayerName().equals("AI")) {
            gameType = new GameType(nameArray[0], nameArray[1]);
            gameType.startAI_VS_AI("AI","AI");
        }

        else if ((nameArray[0].getPlayerName().equals("지옥참마도")) ^ (nameArray[1].getPlayerName().equals("지옥참마도"))) {
            gameType = new GameType(nameArray[0], nameArray[1]);
            gameType.startMan_VS_JioakChamado("Man","Hell");
        }

        else if ((nameArray[0].getPlayerName().equals("디트로이트")) ^ (nameArray[1].getPlayerName().equals("디트로이트"))) {
           gameType = new GameType(nameArray[0], nameArray[1]);
           gameType.startMan_VS_Detroit("Man","Detroit");
       }

       else if (!nameArray[0].getPlayerName().equals("AI")&&!nameArray[1].getPlayerName().equals("AI")) {
            gameType = new GameType(nameArray[0], nameArray[1]);
            gameType.startMan_VS_MAN("Man","Man");//게임타입을 정하고 순서까지 정하였다.
        }
    }
}
