package com.company;

import javax.swing.*;
import java.util.Scanner;

public class GameType {
    Player A,B;
    Initialize initialize = new Initialize();
    IsAllUsed isAllUsed = new IsAllUsed();
    InputToField inputToField = new InputToField();
    DecideTurns decideTurns = new DecideTurns();
    ShowField showField = new ShowField();
    LoadingView loadingView = new LoadingView();
    WinnerEmerged winnerEmerged;
    public GameType(Player A, Player B)  {
        this.A = A;
        this.B = B;
    }
    public void startMan_VS_AI(String Man,String AI) throws InterruptedException {

        while (true) {
            Scanner scan = new Scanner(System.in);

            decideTurns.decideFirstTurn(A, B);
            loadingView.loadingView();
            System.out.println("startMan_VS_AI");
            System.out.println("======================");

            initialize.initialize();
            inputToField.inputFieldReset();
            A.winOrNotReset();
            B.winOrNotReset();

            System.out.println("======================");
            System.out.println();
            System.out.println();
            if (!decideTurns.firstPlayer.getPlayerName().equals("AI")) {
                System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 선공입니다.");
                while (true) {
                    System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 턴입니다. 원하는 좌표를 숫자+(space)+숫자+(enter) 형식으로 입력해주세요");
                    inputToField.firstPlayerInput();//범위체크완료,중복체크 완료, input에서 isAllUsed체크, 다차면 중단해서 show보여주고 아래 승자판단 건너 뛰겟고 감싸고있는 while(isAll...)탈출하면서 게임 끝
                    showField.show();
                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    //winnerEmerged.check3(decideTurns.firstPlayer);
                   if(winnerEmerged.check3(decideTurns.firstPlayer)==true)
                       break;//게임이 끝났으면 첫번째 루프 탈출
                    //그걸 lastPhase에 반환
                    System.out.println();

                    System.out.println(decideTurns.secondPlayer.getPlayerName() + "의 턴입니다.");
                    Thread.sleep(2000);
                    loadingView.AILoadingView();
                    inputToField.secondBecomeAI();
                    showField.show();
                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    if(winnerEmerged.check3(decideTurns.secondPlayer)==true)
                        break;
                    System.out.println();
                    if (!isAllUsed.isAllUsed())
                        break;
                }
               if(decideTurns.firstPlayer.winOrNot)//첫번째 애가 이겼다면
               {
                   winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                   continue;
               }
                if(decideTurns.secondPlayer.winOrNot)
                {
                    winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                    continue;
                }

                System.out.println("모든 필드가 꽉차 게임이 종료되었습니다.");
                new WinnerEmerged().lastPhase(true);
            }

            if (decideTurns.firstPlayer.getPlayerName().equals("AI")) {
                System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 선공입니다.");
                while (true) {
                    System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 턴입니다.");
                    Thread.sleep(2000);
                    loadingView.AILoadingView();
                    inputToField.firstBecomeAI();
                    showField.show();
                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    if(winnerEmerged.check3(decideTurns.firstPlayer)==true)
                        break;//게임이 끝났으면 첫번째 루프 탈출
                    System.out.println();

                    System.out.println(decideTurns.secondPlayer.getPlayerName() + "의 턴입니다. 원하는 좌표를 숫자+(space)+숫자+(enter) 형식으로 입력해주세요");
                    inputToField.secondPlayerInput();
                    showField.show();
                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    if(winnerEmerged.check3(decideTurns.secondPlayer)==true)
                        break;//게임이 끝났으면 첫번째 루프 탈출
                    System.out.println();
                    if (!isAllUsed.isAllUsed())
                        break;
                }
                if(decideTurns.firstPlayer.winOrNot)//첫번째 애가 이겼다면
                {
                    winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                    continue;
                }
                if(decideTurns.secondPlayer.winOrNot)
                {
                    winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                    continue;
                }
                System.out.println("모든 필드가 꽉차 게임이 종료되었습니다.");
                new WinnerEmerged().lastPhase(true);
            }
        }
    }
    public void startMan_VS_MAN(String Man1, String Man2)throws InterruptedException {

        while (true) {
            Scanner scan = new Scanner(System.in);

            decideTurns.decideFirstTurn(A, B);
            loadingView.loadingView();
            System.out.println("startMan_VS_Man");
            System.out.println("======================");

            initialize.initialize();
            inputToField.inputFieldReset();
            A.winOrNotReset();
            B.winOrNotReset();

            System.out.println("======================");
            System.out.println();
            System.out.println();

            System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 선공입니다.");
            while (true) {
                System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 턴입니다. 원하는 좌표를 숫자+(space)+숫자+(enter) 형식으로 입력해주세요");
                inputToField.firstPlayerInput();//범위체크완료,중복체크 완료, input에서 isAllUsed체크, 다차면 중단해서 show보여주고 아래 승자판단 건너 뛰겟고 감싸고있는 while(isAll...)탈출하면서 게임 끝
                showField.show();
                winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                //winnerEmerged.check3(decideTurns.firstPlayer);
                if (winnerEmerged.check3(decideTurns.firstPlayer) == true)
                    break;//게임이 끝났으면 첫번째 루프 탈출
                //그걸 lastPhase에 반환
                System.out.println();

                System.out.println(decideTurns.secondPlayer.getPlayerName() + "의 턴입니다. 원하는 좌표를 숫자+(space)+숫자+(enter) 형식으로 입력해주세요");
                inputToField.secondPlayerInput();//범위체크완료,중복체크 완료, input에서 isAllUsed체크, 다차면 중단해서 show보여주고 아래 승자판단 건너 뛰겟고 감싸고있는 while(isAll...)탈출하면서 게임 끝
                showField.show();
                winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                //winnerEmerged.check3(decideTurns.firstPlayer);
                if (winnerEmerged.check3(decideTurns.firstPlayer) == true)
                    break;//게임이 끝났으면 첫번째 루프 탈출
                //그걸 lastPhase에 반환
                System.out.println();
                if (winnerEmerged.check3(decideTurns.secondPlayer) == true)
                    break;
                System.out.println();

                if (!isAllUsed.isAllUsed())
                    break;
            }
            if (decideTurns.firstPlayer.winOrNot)//첫번째 애가 이겼다면
            {
                winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                continue;
            }
            if (decideTurns.secondPlayer.winOrNot) {
                winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                continue;
            }

            System.out.println("모든 필드가 꽉차 게임이 종료되었습니다.");
            new WinnerEmerged().lastPhase(true);
        }
    }
    public void startAI_VS_AI(String AI1, String AI2)throws InterruptedException {

        while (true) {
            Scanner scan = new Scanner(System.in);

            decideTurns.decideFirstTurn(A, B);
            loadingView.loadingView();
            System.out.println("startMan_VS_AI");
            System.out.println("======================");

            initialize.initialize();
            inputToField.inputFieldReset();
            A.winOrNotReset();
            B.winOrNotReset();

            System.out.println("======================");
            System.out.println();
            System.out.println();

                System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 선공입니다.");
                while (true) {
                    System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 턴입니다.");
                    Thread.sleep(2000);
                    loadingView.AILoadingView();
                    inputToField.firstBecomeAI();
                    showField.show();
                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    if(winnerEmerged.check3(decideTurns.firstPlayer)==true)
                        break;//게임이 끝났으면 첫번째 루프 탈출
                    System.out.println();

                    System.out.println(decideTurns.secondPlayer.getPlayerName() + "의 턴입니다.");
                    Thread.sleep(2000);
                    loadingView.AILoadingView();
                    inputToField.secondBecomeAI();
                    showField.show();
                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    if(winnerEmerged.check3(decideTurns.secondPlayer)==true)
                        break;//게임이 끝났으면 첫번째 루프 탈출
                    System.out.println();

                    if (!isAllUsed.isAllUsed())
                        break;
                }
                if(decideTurns.firstPlayer.winOrNot)//첫번째 애가 이겼다면
                {
                    winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                    continue;
                }
                if(decideTurns.secondPlayer.winOrNot)
                {
                    winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                    continue;
                }
                System.out.println("모든 필드가 꽉차 게임이 종료되었습니다.");
                new WinnerEmerged().lastPhase(true);
        }
    }
    public void startMan_VS_JioakChamado(String Man,String AI) throws InterruptedException {

        while (true) {
            Scanner scan = new Scanner(System.in);

            decideTurns.decideFirstTurn(A, B);
            loadingView.loadingView();
            System.out.println("startMan_VS_지옥참마도");
            System.out.println("======================");

            initialize.initialize();
            inputToField.inputFieldReset();
            A.winOrNotReset();
            B.winOrNotReset();

            System.out.println("======================");
            System.out.println();
            System.out.println();
            if (!decideTurns.firstPlayer.getPlayerName().equals("지옥참마도")) {
                System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 선공입니다.");
                while (true) {
                    System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 턴입니다. 원하는 좌표를 숫자+(space)+숫자+(enter) 형식으로 입력해주세요");
                    inputToField.firstPlayerInput();//범위체크완료,중복체크 완료, input에서 isAllUsed체크, 다차면 중단해서 show보여주고 아래 승자판단 건너 뛰겟고 감싸고있는 while(isAll...)탈출하면서 게임 끝
                    showField.show();
                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    //winnerEmerged.check3(decideTurns.firstPlayer);
                    if(winnerEmerged.check3(decideTurns.firstPlayer)==true)
                        break;//게임이 끝났으면 첫번째 루프 탈출
                    //그걸 lastPhase에 반환
                    System.out.println();

                    System.out.println(decideTurns.secondPlayer.getPlayerName() + "의 턴입니다.");
                    Thread.sleep(2000);
                    loadingView.AILoadingView();
                    inputToField.secondBecomeJioakChamado();
                    if (inputToField.aBoolean) {
                        showField.JioakChamadoSikllEffectShow();
                        inputToField.aBoolean=false;
                    }
                    else
                        showField.show();
                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    if(winnerEmerged.check3(decideTurns.secondPlayer)==true)
                        break;
                    System.out.println();
                    if (!isAllUsed.isAllUsed())
                        break;
                }
                if(decideTurns.firstPlayer.winOrNot)//첫번째 애가 이겼다면
                {
                    winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                    continue;
                }
                if(decideTurns.secondPlayer.winOrNot)
                {
                    winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                    continue;
                }

                System.out.println("모든 필드가 꽉차 게임이 종료되었습니다.");
                new WinnerEmerged().lastPhase(true);
            }

            if (decideTurns.firstPlayer.getPlayerName().equals("지옥참마도")) {
                System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 선공입니다.");
                while (true) {
                    System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 턴입니다.");
                    Thread.sleep(2000);
                    loadingView.AILoadingView();
                    inputToField.firstBecomeJioakChamado();
                    if (inputToField.aBoolean) {
                        showField.JioakChamadoSikllEffectShow();
                        inputToField.aBoolean=false;
                    }
                    else
                        showField.show();
                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    if(winnerEmerged.check3(decideTurns.firstPlayer)==true)
                        break;//게임이 끝났으면 첫번째 루프 탈출
                    System.out.println();

                    System.out.println(decideTurns.secondPlayer.getPlayerName() + "의 턴입니다. 원하는 좌표를 숫자+(space)+숫자+(enter) 형식으로 입력해주세요");
                    inputToField.secondPlayerInput();
                    showField.show();
                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    if(winnerEmerged.check3(decideTurns.secondPlayer)==true)
                        break;//게임이 끝났으면 첫번째 루프 탈출
                    System.out.println();
                    if (!isAllUsed.isAllUsed())
                        break;
                }
                if(decideTurns.firstPlayer.winOrNot)//첫번째 애가 이겼다면
                {
                    winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                    continue;
                }
                if(decideTurns.secondPlayer.winOrNot)
                {
                    winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                    continue;
                }
                System.out.println("모든 필드가 꽉차 게임이 종료되었습니다.");
                new WinnerEmerged().lastPhase(true);
            }
        }
    }
    public void startMan_VS_Detroit(String Man,String AI) throws InterruptedException {

        while (true) {
            Scanner scan = new Scanner(System.in);

            decideTurns.decideFirstTurn(A, B);
            loadingView.loadingView();
            System.out.println("startMan_VS_Detroit");
            System.out.println("======================");

            initialize.initialize();
            inputToField.inputFieldReset();
            A.winOrNotReset();
            B.winOrNotReset();

            System.out.println("======================");
            System.out.println();
            System.out.println();
            if (!decideTurns.firstPlayer.getPlayerName().equals("디트로이트")) {
                System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 선공입니다.");
                while (true) {
                    System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 턴입니다. 원하는 좌표를 숫자+(space)+숫자+(enter) 형식으로 입력해주세요");
                    inputToField.firstPlayerInput();//범위체크완료,중복체크 완료, input에서 isAllUsed체크, 다차면 중단해서 show보여주고 아래 승자판단 건너 뛰겟고 감싸고있는 while(isAll...)탈출하면서 게임 끝
                    showField.show();
                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    //winnerEmerged.check3(decideTurns.firstPlayer);
                    if(winnerEmerged.check3(decideTurns.firstPlayer)==true)
                        break;//게임이 끝났으면 첫번째 루프 탈출
                    //그걸 lastPhase에 반환
                    System.out.println();

                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    System.out.println(decideTurns.secondPlayer.getPlayerName() + "의 턴입니다.");
                    Thread.sleep(2000);
                    loadingView.AILoadingView();
                    inputToField.secondAIBecomeHuman(DecideTurns.firstPlayer);
                    showField.show();
                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    if(winnerEmerged.check3(decideTurns.secondPlayer)==true)
                        break;
                    System.out.println();
                    if (!isAllUsed.isAllUsed())
                        break;
                }
                if(decideTurns.firstPlayer.winOrNot)//첫번째 애가 이겼다면
                {
                    winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                    continue;
                }
                if(decideTurns.secondPlayer.winOrNot)
                {
                    winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                    continue;
                }

                System.out.println("모든 필드가 꽉차 게임이 종료되었습니다.");
                new WinnerEmerged().lastPhase(true);
            }

            if (decideTurns.firstPlayer.getPlayerName().equals("디트로이트")) {
                System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 선공입니다.");
                while (true) {
                    System.out.println(decideTurns.firstPlayer.getPlayerName() + "의 턴입니다.");
                    Thread.sleep(2000);
                    loadingView.AILoadingView();
                    inputToField.fristAIBecomeHuman(DecideTurns.secondPlayer);
                    showField.show();
                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    if(winnerEmerged.check3(decideTurns.firstPlayer)==true)
                        break;//게임이 끝났으면 첫번째 루프 탈출
                    System.out.println();

                    System.out.println(decideTurns.secondPlayer.getPlayerName() + "의 턴입니다. 원하는 좌표를 숫자+(space)+숫자+(enter) 형식으로 입력해주세요");
                    inputToField.secondPlayerInput();
                    showField.show();
                    winnerEmerged = new WinnerEmerged(inputToField.row, inputToField.col);
                    if(winnerEmerged.check3(decideTurns.secondPlayer)==true)
                        break;//게임이 끝났으면 첫번째 루프 탈출
                    System.out.println();
                    if (!isAllUsed.isAllUsed())
                        break;
                }
                if(decideTurns.firstPlayer.winOrNot)//첫번째 애가 이겼다면
                {
                    winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                    continue;
                }
                if(decideTurns.secondPlayer.winOrNot)
                {
                    winnerEmerged.lastPhase(true);//라스트 페이즈 실행
                    continue;
                }
                System.out.println("모든 필드가 꽉차 게임이 종료되었습니다.");
                new WinnerEmerged().lastPhase(true);
            }
        }
    }
}
