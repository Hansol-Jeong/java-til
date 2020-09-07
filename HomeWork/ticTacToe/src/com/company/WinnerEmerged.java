package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WinnerEmerged {


    int row, col, tempRow, tempCol, count = 0;
    char character;
    Player A;
    public WinnerEmerged() {//기본 생성자 오버로딩->꽉차서 종료될 때 lastPhase만을 호출하기 위해 생성

    }
    public WinnerEmerged(int row, int col) {//마지막에 둔 지점
        this.row = row;
        this.col = col;
    }

    public boolean check3(Player A) {//플레이어를 받고 그 플레이어의 wincount를 ++시킨다.

        this.A = A;
        tempRow = row;
        tempCol = col;
        character = Initialize.field[row][col];
        //col direction 위로 2번 아래로 2번 스캔할것임

            tempRow--;
            if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){      //행 위로 이동하고 그것이 범위안에 있으면
                if (Initialize.field[tempRow][tempCol]==character)    //위행렬로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
                {
                    A.upCount++;
                    count++;
                    tempRow--;
                    if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 한행 더 위로 올라갔을때 범위에 포함된다면
                    {
                        if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                        {
                            A.upCount++;
                            count++;

                        }
                    }
                }
            }
            if(A.upCount==1){
                A.detoritMustStopThisSequence_TypeUp= true;
                A.upCount=0;
            }
            tempRow = row;
            tempCol = col;//다시 원래 좌표로 돌아와서
            tempRow++;//이번엔 아래로 2번 스캔 시작
            if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){      //행 아래로 이동하고 그것이 범위안에 있으면
                if (Initialize.field[tempRow][tempCol]==character)    //아래행렬로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
                {
                    A.downCount++;
                    count++;
                    tempRow++;
                    if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 한행 더 위로 올라갔을때 범위에 포함된다면
                    {
                        if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                        {
                            A.downCount++;
                            count++;
                        }
                    }
                }
            }
        if(A.downCount==1){
            A.detoritMustStopThisSequence_Typedown= true;
            A.downCount=0;
        }
            if(count==2) {
                A.winCount++;
                A.winOrNot=true;
                return true;//이 과정이 끝났을 때 카운트가 2가되면 true를 반환->true면 승리
            }
        tempRow = row;
        tempCol = col;
        count = 0;//좌우 따지기 전에 초기화 시켜주고

        //row direction

            tempCol--;//좌측 스캔
            if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){      //좌측으로 이동하고 그것이 범위안에 있으면
                if (Initialize.field[tempRow][tempCol]==character)    //좌측열로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
                {
                    A.leftCount++;
                    count++;
                    tempCol--;
                    if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 한번더 왼쪽으로 갔을때 범위에 포함된다면
                    {
                        if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                        {
                            A.leftCount++;
                            count++;
                        }
                    }
                }
            }
        if(A.leftCount==1){
            A.detoritMustStopThisSequence_Typeleft= true;
            A.leftCount=0;
        }
            tempRow = row;
            tempCol = col;//다시 원래 좌표로 돌아와서
            tempCol++;//이번엔 우측으로 2번 스캔 시작
            if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){      //우측열로 이동하고 그것이 범위안에 있으면
                if (Initialize.field[tempRow][tempCol]==character)    //우측열로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
                {
                    A.rightCount++;
                    count++;
                    tempCol++;
                    if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 우측으로 한번더 갔을 떄 범위에 포함된다면
                    {
                        if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                        {
                            A.rightCount++;
                            count++;
                        }
                    }
                }
            }
        if(A.rightCount==1){
            A.detoritMustStopThisSequence_Typeright= true;
            A.rightCount=0;
        }
            if(count==2) {
                A.winCount++;
                A.winOrNot=true;
                return true;//이 과정이 끝났을 때 카운트가 2가되면 true를 반환->true면 승리
            }

        tempRow = row;
        tempCol = col;
        count = 0;//초기화

        //right top direction

            tempRow--;
            tempCol++;//위 우측 스캔
            if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){     //위 우측 스캔하고 그것이 범위 안에 있다면
                if (Initialize.field[tempRow][tempCol]==character)    //위 우측으로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
                {
                    A.rightUpCount++;
                    count++;
                    tempRow--;
                    tempCol++;
                    if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 한번더위 우측으로 갔을때 범위에 포함된다면
                    {
                        if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                        {
                            A.rightUpCount++;
                            count++;
                        }
                    }
                }
            }
        if(A.rightUpCount==1){
            A.detoritMustStopThisSequence_TypeUpRight= true;
            A.rightUpCount=0;
        }
            tempRow = row;
            tempCol = col;//다시 원래 좌표로 돌아와서
            tempRow++;
            tempCol--;//아래 좌측 스캔 시작
            if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){      //아래 좌측으로 이동하고 그것이 범위안에 있으면
                if (Initialize.field[tempRow][tempCol]==character)    //아래 좌측으로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
                {
                    A.lefDownCount++;
                    count++;
                    tempRow++;
                    tempCol--;
                    if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 아래 좌측으로 한번더 갔을 떄 범위에 포함된다면
                    {
                        if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                        {
                            A.lefDownCount++;
                            count++;
                        }
                    }
                }
            }
        if(A.lefDownCount==1){
            A.detoritMustStopThisSequence_TypeDownLeft= true;
            A.lefDownCount=0;
        }
            if(count==2) {
                A.winCount++;
                A.winOrNot=true;
                return true;//이 과정이 끝났을 때 카운트가 2가되면 true를 반환->true면 승리
            }

        tempRow = row;
        tempCol = col;
        count = 0;//초기화

        //left top direction

            tempRow--;
            tempCol--;//위 좌측 스캔
            if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){     //위 좌측 스캔하고 그것이 범위 안에 있다면
                if (Initialize.field[tempRow][tempCol]==character)    //위 좌측으로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
                {
                    A.leftUpCount++;
                    count++;
                    tempRow--;
                    tempCol--;
                    if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 한번더위 우측으로 갔을때 범위에 포함된다면
                    {
                        if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                        {
                            A.leftUpCount++;
                            count++;
                        }
                    }
                }
            }
        if(A.leftUpCount==1){
            A.detoritMustStopThisSequence_TypeUpLeft= true;
            A.leftUpCount=0;
        }
            tempRow = row;
            tempCol = col;//다시 원래 좌표로 돌아와서
            tempRow++;
            tempCol++;//아래 우측 스캔 시작
            if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){      //아래 우측으로 이동하고 그것이 범위안에 있으면
                if (Initialize.field[tempRow][tempCol]==character)    //아래 우측으로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
                {
                    A.rightDownCount++;
                    count++;
                    tempRow++;
                    tempCol++;
                    if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 아래 우측으로 한번더 갔을 떄 범위에 포함된다면
                    {
                        if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                        {
                            A.rightDownCount++;
                            count++;
                        }
                    }
                }
            }
        if(A.rightDownCount==1){
            A.detoritMustStopThisSequence_TypeDownright= true;
            A.rightDownCount=0;
        }
            if(count==2) {
                A.winCount++;
                A.winOrNot=true;
                return true;//이 과정이 끝났을 때 카운트가 2가되면 true를 반환->true면 승리
            }

        tempRow = row;
        tempCol = col;
        count = 0;
        //모든방향에 대해 2칸씩 스캔을 마쳤다.






        //between
        tempRow--;
        if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){      //행 위로 이동하고 그것이 범위안에 있으면
            if (Initialize.field[tempRow][tempCol]=='E')    //중간이 비엇고
            {
                tempRow--;
                if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 한행 더 위로 올라갔을때 범위에 포함된다면
                {
                    if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                    {
                        A.BetweenUpCount++;
                    }
                }
            }
        }
        if(A.BetweenUpCount==1){
            A.detoritMustStopThisSequence_TypeBetweenUp= true;
            A.BetweenUpCount=0;
        }
        tempRow = row;
        tempCol = col;//다시 원래 좌표로 돌아와서
        tempRow++;//이번엔 아래로 2번 스캔 시작
        if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){      //행 아래로 이동하고 그것이 범위안에 있으면
            if (Initialize.field[tempRow][tempCol]=='E')    //아래행렬로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
            {
                tempRow++;
                if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 한행 더 위로 올라갔을때 범위에 포함된다면
                {
                    if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                    {
                        A.BetweenDownCount++;
                    }
                }
            }
        }
        if(A.BetweenDownCount==1){
            A.detoritMustStopThisSequence_TypeBetweenDown= true;
            A.BetweenDownCount=0;
        }

        tempRow = row;
        tempCol = col;
        count = 0;//좌우 따지기 전에 초기화 시켜주고

        //row direction

        tempCol--;//좌측 스캔
        if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){      //좌측으로 이동하고 그것이 범위안에 있으면
            if (Initialize.field[tempRow][tempCol]=='E')    //좌측열로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
            {
                tempCol--;
                if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 한번더 왼쪽으로 갔을때 범위에 포함된다면
                {
                    if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                    {
                        A.BetweenLeftCount++;
                    }
                }
            }
        }
        if(A.BetweenLeftCount==1){
            A.detoritMustStopThisSequence_TypeBetweenLeft= true;
            A.BetweenLeftCount=0;
        }
        tempRow = row;
        tempCol = col;//다시 원래 좌표로 돌아와서
        tempCol++;//이번엔 우측으로 2번 스캔 시작
        if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){      //우측열로 이동하고 그것이 범위안에 있으면
            if (Initialize.field[tempRow][tempCol]=='E')    //우측열로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
            {
                tempCol++;
                if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 우측으로 한번더 갔을 떄 범위에 포함된다면
                {
                    if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                    {
                        A.BetweenRightCount++;
                    }
                }
            }
        }
        if(A.BetweenRightCount==1){
            A.detoritMustStopThisSequence_TypeBetweenRight= true;
            A.BetweenRightCount=0;
        }

        tempRow = row;
        tempCol = col;
        count = 0;//초기화

        //right top direction

        tempRow--;
        tempCol++;//위 우측 스캔
        if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){     //위 우측 스캔하고 그것이 범위 안에 있다면
            if (Initialize.field[tempRow][tempCol]=='E')    //위 우측으로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
            {
                tempRow--;
                tempCol++;
                if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 한번더위 우측으로 갔을때 범위에 포함된다면
                {
                    if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                    {
                        A.BetweenRightUpCount++;
                    }
                }
            }
        }
        if(A.BetweenRightUpCount==1){
            A.detoritMustStopThisSequence_TypeBetweenUpRight= true;
            A.BetweenRightUpCount=0;
        }
        tempRow = row;
        tempCol = col;//다시 원래 좌표로 돌아와서
        tempRow++;
        tempCol--;//아래 좌측 스캔 시작

        if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){      //아래 좌측으로 이동하고 그것이 범위안에 있으면
            if (Initialize.field[tempRow][tempCol]=='E')    //아래 좌측으로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
            {
                tempRow++;
                tempCol--;
                if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 아래 좌측으로 한번더 갔을 떄 범위에 포함된다면
                {
                    if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                    {
                        A.BetweenLeftDownCount++;
                    }
                }
            }
        }
        if(A.BetweenLeftDownCount==1){
            A.detoritMustStopThisSequence_TypeBetweenDownLeft= true;
            A.BetweenLeftDownCount=0;
        }

        tempRow = row;
        tempCol = col;
        count = 0;//초기화

        //left top direction

        tempRow--;
        tempCol--;//위 좌측 스캔
        if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){     //위 좌측 스캔하고 그것이 범위 안에 있다면
            if (Initialize.field[tempRow][tempCol]=='E')    //위 좌측으로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
            {
                tempRow--;
                tempCol--;
                if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 한번더위 우측으로 갔을때 범위에 포함된다면
                {
                    if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                    {
                        A.BetweenLeftUpCount++;
                    }
                }
            }
        }
        if(A.BetweenLeftUpCount==1){
            A.detoritMustStopThisSequence_TypeBetweenUpLeft= true;
            A.BetweenLeftUpCount=0;
        }
        tempRow = row;
        tempCol = col;//다시 원래 좌표로 돌아와서
        tempRow++;
        tempCol++;//아래 우측 스캔 시작
        if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))){      //아래 우측으로 이동하고 그것이 범위안에 있으면
            if (Initialize.field[tempRow][tempCol]=='E')    //아래 우측으로 이동했을 떄의 좌표의 캐릭터가 마지막에 둔 돌의 캐릭터와 같다면
            {
                tempRow++;
                tempCol++;
                if(((tempRow>=0)&&(tempRow<=2))&&((tempCol>=1)&&(tempCol<=3))) //또한 이 상태에서 아래 우측으로 한번더 갔을 떄 범위에 포함된다면
                {
                    if (Initialize.field[tempRow][tempCol]==character)//그 좌표가 또 캐릭터와 같다면
                    {
                        A.BetweenRightDownCount++;
                    }
                }
            }
        }
        if(A.BetweenRightDownCount==1){
            A.detoritMustStopThisSequence_TypeBetweenDownRight= true;
            A.BetweenRightDownCount=0;
        }

        tempRow = row;
        tempCol = col;
        count = 0;
        //모든방향에 대해 2칸씩 스캔을 마쳤다.

    return false;
    }

    public void lastPhase(boolean B) throws InterruptedException {
        int num;
        if (B == true) //경기 끝
        {

            if(A!=null)
            System.out.println(A.getPlayerName()+"님이 이겼습니다.");
            System.out.println("현재 스코어");
            System.out.println(DecideTurns.firstPlayer.getPlayerName() + DecideTurns.firstPlayer.winCount + " - " + DecideTurns.secondPlayer.getPlayerName() + DecideTurns.secondPlayer.winCount);
       loop:
        while(true) {
            System.out.println("1번은 다시하기 2번은 종료입니다.");
            try {
                Scanner scan = new Scanner(System.in);
                num = scan.nextInt();
                if (num == 1) {
                    break loop;//아무것도안하고 나가면 게임 다시시작
                } else if (num == 2) {
                    System.exit(0);
                } else {
                    System.out.println("다시 입력해 주세요");
                    continue;
                }
            }catch (InputMismatchException e)
            {
                continue;
            }
        }
        }
    }
}

