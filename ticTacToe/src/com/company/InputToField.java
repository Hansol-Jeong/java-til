package com.company;

import java.util.Scanner;

public class InputToField {

    static int row = 0, col = 4, tempRow = 0, tempCol = 0, col1 = 0, col2 = 0;
    IsAllUsed isAllUsed = new IsAllUsed();
    boolean aBoolean = false;
    Player A;

    public void inputFieldReset() {
        row = 0;
        col = 4;
        tempCol = 0;
        tempRow = 0;//리셋 안시켜주면 위의 함수 실행조차 안된다.
    }

    public void firstPlayerInput() {
        Scanner scan = new Scanner(System.in);
        while (Initialize.field[row][col] != 'E') {
            if (!isAllUsed.isAllUsed())//false면 중단==다차면 중단
                break;
            tempRow = scan.nextInt();
            tempCol = scan.nextInt() + 1;
            if (!(((tempRow >= 0) && (tempRow <= 2)) && ((tempCol >= 1) && (tempCol <= 3)))) {
                System.out.println("범위를 고려하여 좌표를 다시 입력해주십시오.");
                continue;
            }
            row = tempRow;
            col = tempCol;
            if (Initialize.field[row][col] != 'E') {
                System.out.println("중복된 좌표입니다. 다른 좌표를 입력해주세요");
                continue;
            }

            if (Initialize.field[row][col] == 'E') {
                Initialize.field[row][col] = 'O';
                break;
            }
        }

    }

    public void secondPlayerInput() {
        Scanner scan = new Scanner(System.in);
        while (Initialize.field[row][col] != 'E') {
            if (!isAllUsed.isAllUsed())
                break;
            tempRow = scan.nextInt();
            tempCol = scan.nextInt() + 1;
            if (!(((tempRow >= 0) && (tempRow <= 2)) && ((tempCol >= 1) && (tempCol <= 3)))) {
                System.out.println("범위를 고려하여 좌표를 다시 입력해주십시오.");
                continue;
            }
            row = tempRow;
            col = tempCol;
            if (Initialize.field[row][col] != 'E') {
                System.out.println("중복된 좌표입니다. 다른 좌표를 입력해주세요");
                continue;
            }

            if (Initialize.field[row][col] == 'E') {
                Initialize.field[row][col] = 'X';
                break;
            }
        }
    }

    public void firstBecomeAI() {
        while (Initialize.field[row][col] != 'E') {
            if (!isAllUsed.isAllUsed())
                break;
            row = (int) ((Math.random() * 3) % 3);
            col = (int) ((Math.random() * 3) % 3) + 1;
            if (Initialize.field[row][col] == 'E') {
                Initialize.field[row][col] = 'O';
                break;
            } else if (Initialize.field[row][col] != 'E')
                continue;
        }
    }
    public void secondBecomeAI() {
        while (Initialize.field[row][col] != 'E') {
            if (!isAllUsed.isAllUsed())
                break;
            row = (int) ((Math.random() * 3) % 3);
            col = (int) ((Math.random() * 3) % 3) + 1;
            if (Initialize.field[row][col] == 'E') {
                Initialize.field[row][col] = 'X';
                break;
            } else if (Initialize.field[row][col] != 'E')
                continue;
        }

    }
    public void firstBecomeJioakChamado() {
        while (Initialize.field[row][col] != 'E') {
            if (!isAllUsed.isAllUsed())
                break;
            row = (int) ((Math.random() * 3) % 3);
            col = (int) ((Math.random() * 3) % 3) + 1;
            float randomSkillPercentage = 0.5f;
            float random = (float) Math.random();//0~1
            if (random < randomSkillPercentage) {//확률이 발동되고
                col1 = col + 1;
                col2 = col - 1;
                if (Initialize.field[row][col] == 'E') {//랜덤 좌표값이 비어있고
                    if (((col1 >= 1) && (col1 < 4))) {//오른쪽으로 범위가 성립될 때
                        if (Initialize.field[row][col1] == 'E')//해당 칸이 비어있다면
                        {
                            aBoolean = true;
                            Initialize.field[row][col] = 'O';
                            Initialize.field[row][col1] = 'O';
                            break;
                        } else if (Initialize.field[row][col1] != 'E')//비어있지 않다면 스킬멘트 없음
                        {
                            Initialize.field[row][col] = 'O';
                            break;
                        }
                    }
                    if (((col2 >= 1) && (col2 < 4))) {//왼쪽으로 범위가 성립될 때
                        if (Initialize.field[row][col2] == 'E')//해당 칸이 비어있다면
                        {
                            aBoolean = true;
                            Initialize.field[row][col] = 'O';
                            Initialize.field[row][col2] = 'O';
                            break;
                        } else if (Initialize.field[row][col2] != 'E')//비어있지 않다면 스킬멘트 없음
                        {
                            Initialize.field[row][col] = 'O';
                            break;
                        }
                    }
                }
            } else if (random >= randomSkillPercentage) {
                if (Initialize.field[row][col] == 'E') {
                    Initialize.field[row][col] = 'O';
                    break;
                }
            }
        }
    }
    public void secondBecomeJioakChamado()  {
        while (Initialize.field[row][col] != 'E') {
            if (!isAllUsed.isAllUsed())
                break;
            row = (int) ((Math.random() * 3) % 3);
            col = (int) ((Math.random() * 3) % 3) + 1;
            float randomSkillPercentage = 0.5f;
            float random = (float) Math.random();//0~1
            if (random < randomSkillPercentage) {//확률이 발동되고
                col1 = col + 1;
                col2 = col - 1;
                if (Initialize.field[row][col] == 'E') {//랜덤 좌표값이 비어있고
                    if (((col1 >= 1) && (col1 < 4))) {//오른쪽으로 범위가 성립될 때
                        if (Initialize.field[row][col1] == 'E')//해당 칸이 비어있다면
                        {
                            aBoolean = true;
                            Initialize.field[row][col] = 'X';
                            Initialize.field[row][col1] = 'X';
                            break;
                        } else if (Initialize.field[row][col1] != 'E')//비어있지 않다면 스킬멘트 없음
                        {
                            Initialize.field[row][col] = 'X';
                            break;
                        }
                    }
                    if (((col2 >= 1) && (col2 < 4))) {//왼쪽으로 범위가 성립될 때
                        if (Initialize.field[row][col2] == 'E')//해당 칸이 비어있다면
                        {
                            aBoolean = true;
                            Initialize.field[row][col] = 'X';
                            Initialize.field[row][col2] = 'X';
                            break;
                        } else if (Initialize.field[row][col2] != 'E')//비어있지 않다면 스킬멘트 없음
                        {
                            Initialize.field[row][col] = 'X';
                            break;
                        }
                    }
                }
            } else if (random >= randomSkillPercentage) {
                if (Initialize.field[row][col] == 'E') {
                    Initialize.field[row][col] = 'X';
                    break;
                }
            }
        }
    }
    public void fristAIBecomeHuman(Player secondPlayer) {
        int tempRowUp = row - 1, tempRowDown = row + 1, tempColRight = col + 1, tempColLeft = col - 1;
        if (secondPlayer.detoritMustStopThisSequence_TypeUp == true) {
            //TypeUp의 경우 아래가 빈경우와 더블위가 빈경우가 있다.
            //1.
            if (tempRowDown >= 0 && tempRowDown < 3) {//범위를 만족한다면
                if (Initialize.field[tempRowDown][col] == 'E')//그자리가 비었다면
                {
                    Initialize.field[tempRowDown][col] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeUp = false;
                    row=tempRowDown;//여기에 둿다는 정보를 winnerEmer...한테 줘야해
                    return;
                }
            }
            if (tempRowUp - 1 >= 0 && tempRowUp + 1 < 3) {
                if (Initialize.field[tempRowUp - 1][col] == 'E') {
                    Initialize.field[tempRowUp - 1][col] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeUp = false;
                    row=tempRowUp - 1;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (secondPlayer.detoritMustStopThisSequence_Typedown == true) {
            if (tempRowUp >= 0 && tempRowUp < 3) {
                if (Initialize.field[tempRowUp][col] == 'E') {
                    Initialize.field[tempRowUp][col] = 'O';
                    secondPlayer.detoritMustStopThisSequence_Typedown = false;
                    row=tempRowUp;
                    return;
                }
            }
            if (tempRowDown + 1 >= 0 && tempRowDown - 1 < 3) {
                if (Initialize.field[tempRowDown + 1][col] == 'E') {
                    Initialize.field[tempRowDown + 1][col] = 'O';
                    secondPlayer.detoritMustStopThisSequence_Typedown = false;
                    row=tempRowDown+1;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (secondPlayer.detoritMustStopThisSequence_Typeright == true) {
            if (tempColLeft >= 1 && tempColLeft < 4) {
                if (Initialize.field[row][tempColLeft] == 'E') {
                    Initialize.field[row][tempColLeft] = 'O';
                    secondPlayer.detoritMustStopThisSequence_Typeright = false;
                    col=tempColLeft;
                    return;
                }
            }
            if (tempColRight + 1 >= 1 && tempColRight + 1 < 4) {
                if (Initialize.field[row][tempColRight + 1] == 'E') {
                    Initialize.field[row][tempColRight+1] = 'O';
                    secondPlayer.detoritMustStopThisSequence_Typeright = false;
                    col=tempColRight+1;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (secondPlayer.detoritMustStopThisSequence_Typeleft == true) {
            if (tempColRight >= 1 && tempColRight < 4) {
                if (Initialize.field[row][tempColRight] == 'E') {
                    Initialize.field[row][tempColRight] = 'O';
                    secondPlayer.detoritMustStopThisSequence_Typeleft = false;
                    col=tempColRight;
                    return;
                }
            }
            if (tempColLeft - 1 >= 1 && tempColLeft - 1 < 4) {
                if (Initialize.field[row][tempColLeft - 1] == 'E') {
                    Initialize.field[row][tempColLeft - 1] = 'O';
                    secondPlayer.detoritMustStopThisSequence_Typeleft = false;
                    col=tempColLeft-1;
                    return;

                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (secondPlayer.detoritMustStopThisSequence_TypeUpRight == true) {
            if (((row + 1) >= 0 && (row + 1) < 3) && ((col - 1) >= 1 && (col - 1) < 4)) {
                if (Initialize.field[row + 1][col - 1] == 'E') {
                    Initialize.field[row + 1][col - 1] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeUpRight = false;
                    row=row+1;col=col-1;
                    return;
                }
            }
            if (((row - 2) >= 0 && (row - 2) < 3) && ((col + 2) >= 1 && (col + 2) < 4)) {
                if (Initialize.field[row - 2][col + 2] == 'E') {
                    Initialize.field[row - 2][col + 2] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeUpRight = false;
                    row=row-2;col=col+2;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (secondPlayer.detoritMustStopThisSequence_TypeUpLeft == true) {
            if (((row + 1) >= 0 && (row + 1) < 3) && ((col + 1) >= 1 && (col + 1) < 4)) {
                if (Initialize.field[row + 1][col + 1] == 'E') {
                    Initialize.field[row + 1][col + 1] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeUpLeft = false;
                    row=row+1;col=col+1;
                    return;
                }
            }
            if (((row - 2) >= 0 && (row - 2) < 3) && ((col - 2) >= 1 && (col - 2) < 4)) {
                if (Initialize.field[row - 2][col - 2] == 'E') {
                    Initialize.field[row - 2][col - 2] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeUpLeft = false;
                    row=row-2;col=col-2;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (secondPlayer.detoritMustStopThisSequence_TypeDownright == true) {
            if (((row - 1) >= 0 && (row - 1) < 3) && ((col - 1) >= 1 && (col - 1) < 4)) {
                if (Initialize.field[row - 1][col - 1] == 'E') {
                    Initialize.field[row - 1][col - 1] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeDownright = false;
                    row=row-1;col=col-1;
                    return;
                }
            }
            if (((row + 2) >= 0 && (row + 2) < 3) && ((col + 2) >= 1 && (col + 2) < 4)) {
                if (Initialize.field[row + 2][col + 2] == 'E') {
                    Initialize.field[row + 2][col + 2] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeDownright = false;
                    row=row+2;col=col+2;
                    return;
                }
            }
        }
        if (secondPlayer.detoritMustStopThisSequence_TypeDownLeft == true) {
            if (((row - 1) >= 0 && (row - 1) < 3) && ((col + 1) >= 1 && (col + 1) < 4)) {
                if (Initialize.field[row - 1][col + 1] == 'E') {
                    Initialize.field[row - 1][col + 1] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeDownLeft = false;
                    row=row-1;col=col+1;
                    return;
                }
            }
            if (((row + 2) >= 0 && (row + 2) < 3) && ((col - 2) >= 1 && (col +- 2) < 4)) {
                if (Initialize.field[row + 2][col - 2] == 'E') {
                    Initialize.field[row + 2][col - 2] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeDownLeft = false;
                    row=row+2;col=col-2;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.

        if (secondPlayer.detoritMustStopThisSequence_TypeBetweenUp == true) {
            if(tempRowUp>=0&&tempRowUp<3){
                if (Initialize.field[tempRowUp][col] == 'E')//그자리가 비었다면
                {
                    Initialize.field[tempRowUp][col] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeBetweenUp = false;
                    row=tempRowUp;//여기에 둿다는 정보를 winnerEmer...한테 줘야해
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (secondPlayer.detoritMustStopThisSequence_TypeBetweenDown == true) {
            if(tempRowDown>=0&&tempRowDown<3){
                if (Initialize.field[tempRowDown][col] == 'E')//그자리가 비었다면
                {
                    Initialize.field[tempRowDown][col] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeBetweenDown = false;
                    row=tempRowDown;//여기에 둿다는 정보를 winnerEmer...한테 줘야해
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (secondPlayer.detoritMustStopThisSequence_TypeBetweenRight == true) {
            if(tempColRight>=1&&tempColRight<4){
                if (Initialize.field[row][tempColRight] == 'E')//그자리가 비었다면
                {
                    Initialize.field[row][tempColRight] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeBetweenRight = false;
                    col=tempColRight;//여기에 둿다는 정보를 winnerEmer...한테 줘야해
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (secondPlayer.detoritMustStopThisSequence_TypeBetweenLeft == true) {
            if(tempColLeft>=1&&tempColLeft<4){
                if (Initialize.field[row][tempColLeft] == 'E')//그자리가 비었다면
                {
                    Initialize.field[row][tempColLeft] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeBetweenLeft = false;
                    col=tempColLeft;//여기에 둿다는 정보를 winnerEmer...한테 줘야해
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (secondPlayer.detoritMustStopThisSequence_TypeBetweenUpRight == true) {
            if (((row - 1) >= 0 && (row - 1) < 3) && ((col + 1) >= 1 && (col + 1) < 4)) {
                if (Initialize.field[row - 1][col + 1] == 'E') {
                    Initialize.field[row - 1][col + 1] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeUpRight = false;
                    row=row - 1;col=col + 1;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (secondPlayer.detoritMustStopThisSequence_TypeBetweenUpLeft == true) {
            if (((row - 1) >= 0 && (row - 1) < 3) && ((col - 1) >= 1 && (col - 1) < 4)) {
                if (Initialize.field[row - 1][col - 1] == 'E') {
                    Initialize.field[row - 1][col - 1] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeUpLeft = false;
                    row=row - 1;col=col - 1;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (secondPlayer.detoritMustStopThisSequence_TypeBetweenDownRight == true) {
            if (((row + 1) >= 0 && (row + 1) < 3) && ((col + 1) >= 1 && (col + 1) < 4)) {
                if (Initialize.field[row + 1][col + 1] == 'E') {
                    Initialize.field[row + 1][col + 1] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeDownright = false;
                    row=row-1;col=col-1;
                    return;
                }
            }
        }
        if (secondPlayer.detoritMustStopThisSequence_TypeDownLeft == true) {
            if (((row + 1) >= 0 && (row + 1) < 3) && ((col - 1) >= 1 && (col - 1) < 4)) {
                if (Initialize.field[row + 1][col - 1] == 'E') {
                    Initialize.field[row + 1][col - 1] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeDownLeft = false;
                    row=row-1;col=col+1;
                    return;
                }
            }
            if (((row + 2) >= 0 && (row + 2) < 3) && ((col - 2) >= 1 && (col +- 2) < 4)) {
                if (Initialize.field[row + 2][col - 2] == 'E') {
                    Initialize.field[row + 2][col - 2] = 'O';
                    secondPlayer.detoritMustStopThisSequence_TypeDownLeft = false;
                    row=row+2;col=col-2;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.

        while (Initialize.field[row][col] != 'E') {
            if (!isAllUsed.isAllUsed())
                break;
            row = 1;
            col = 2;
            if (Initialize.field[row][col] == 'E') {
                Initialize.field[row][col] = 'O';
                break;
            }//필승전략 2. 11자리 우선 선점


            row = (int) ((Math.random() * 3) % 3);
            col = (int) ((Math.random() * 3) % 3) + 1;
            if (Initialize.field[row][col] == 'E') {
                Initialize.field[row][col] = 'O';
                break;
            } else if (Initialize.field[row][col] != 'E')
                continue;
        }
    }
    public void secondAIBecomeHuman(Player firstPlayer) {
        int tempRowUp = row - 1, tempRowDown = row + 1, tempColRight = col + 1, tempColLeft = col - 1;
        if (firstPlayer.detoritMustStopThisSequence_TypeUp == true) {
            //TypeUp의 경우 아래가 빈경우와 더블위가 빈경우가 있다.
            //1.
            if (tempRowDown >= 0 && tempRowDown < 3) {//범위를 만족한다면
                if (Initialize.field[tempRowDown][col] == 'E')//그자리가 비었다면
                {
                    Initialize.field[tempRowDown][col] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeUp = false;
                    row=tempRowDown;
                    return;
                }
            }
            if (tempRowUp - 1 >= 0 && tempRowUp + 1 < 3) {
                if (Initialize.field[tempRowUp - 1][col] == 'E') {
                    Initialize.field[tempRowUp - 1][col] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeUp = false;
                    row=tempRowUp-1;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (firstPlayer.detoritMustStopThisSequence_Typedown == true) {
            if (tempRowUp >= 0 && tempRowUp < 3) {
                if (Initialize.field[tempRowUp][col] == 'E') {
                    Initialize.field[tempRowUp][col] = 'X';
                    firstPlayer.detoritMustStopThisSequence_Typedown = false;
                    row=tempRowUp;
                    return;
                }
            }
            if (tempRowDown +1 >= 0 && tempRowDown + 1 < 3) {
                if (Initialize.field[tempRowDown + 1][col] == 'E') {
                    Initialize.field[tempRowDown + 1][col] = 'X';
                    firstPlayer.detoritMustStopThisSequence_Typedown = false;
                    row=tempRowDown+1;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (firstPlayer.detoritMustStopThisSequence_Typeright == true) {
            if (tempColLeft >= 1 && tempColLeft < 4) {
                if (Initialize.field[row][tempColLeft] == 'E') {
                    Initialize.field[row][tempColLeft] = 'X';
                    firstPlayer.detoritMustStopThisSequence_Typeright = false;
                    col=tempColLeft;
                    return;
                }
            }
            if (tempColRight + 1 >= 1 && tempColRight + 1 < 4) {
                if (Initialize.field[row][tempColRight + 1] == 'E') {
                    Initialize.field[row][tempColRight+1] = 'X';
                    firstPlayer.detoritMustStopThisSequence_Typeright = false;
                    col=tempColRight+1;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (firstPlayer.detoritMustStopThisSequence_Typeleft == true) {
            if (tempColRight >= 1 && tempColRight < 4) {
                if (Initialize.field[row][tempColRight] == 'E') {
                    Initialize.field[row][tempColRight] = 'X';
                    firstPlayer.detoritMustStopThisSequence_Typeleft = false;
                    col=tempColRight;
                    return;
                }
            }
            if (tempColLeft - 1 >= 1 && tempColLeft - 1 < 4) {
                if (Initialize.field[row][tempColLeft - 1] == 'E') {
                    Initialize.field[row][tempColLeft - 1] = 'X';
                    firstPlayer.detoritMustStopThisSequence_Typeleft = false;
                    col=tempColLeft-1;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (firstPlayer.detoritMustStopThisSequence_TypeUpRight == true) {
            if (((row + 1) >= 0 && (row + 1) < 3) && ((col - 1) >= 1 && (col - 1) < 4)) {
                if (Initialize.field[row + 1][col - 1] == 'E') {
                    Initialize.field[row + 1][col - 1] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeUpRight = false;
                    row=row+1;
                    col=col-1;
                    return;
                }
            }
            if (((row - 2) >= 0 && (row - 2) < 3) && ((col + 2) >= 1 && (col + 2) < 4)) {
                if (Initialize.field[row - 2][col + 2] == 'E') {
                    Initialize.field[row - 2][col + 2] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeUpRight = false;
                    row=row-2;
                    col=col+2;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (firstPlayer.detoritMustStopThisSequence_TypeUpLeft == true) {
            if (((row + 1) >= 0 && (row + 1) < 3) && ((col + 1) >= 1 && (col + 1) < 4)) {
                if (Initialize.field[row + 1][col + 1] == 'E') {
                    Initialize.field[row + 1][col + 1] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeUpLeft = false;
                    row=row+1;
                    col=col+1;
                    return;
                }
            }
            if (((row - 2) >= 0 && (row - 2) < 3) && ((col - 2) >= 1 && (col - 2) < 4)) {
                if (Initialize.field[row - 2][col - 2] == 'E') {
                    Initialize.field[row - 2][col - 2] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeUpLeft = false;
                    row=row-2;
                    col=col-2;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (firstPlayer.detoritMustStopThisSequence_TypeDownright == true) {
            if (((row - 1) >= 0 && (row - 1) < 3) && ((col - 1) >= 1 && (col - 1) < 4)) {
                if (Initialize.field[row - 1][col - 1] == 'E') {
                    Initialize.field[row - 1][col - 1] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeDownright = false;
                    row=row-1;
                    col=col-1;

                    return;
                }
            }
            if (((row + 2) >= 0 && (row + 2) < 3) && ((col + 2) >= 1 && (col + 2) < 4)) {
                if (Initialize.field[row + 2][col + 2] == 'E') {
                    Initialize.field[row + 2][col + 2] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeDownright = false;
                    row=row+2;
                    col=col+2;
                    return;
                }
            }
        }
        if (firstPlayer.detoritMustStopThisSequence_TypeDownLeft == true) {
            if (((row - 1) >= 0 && (row - 1) < 3) && ((col + 1) >= 1 && (col + 1) < 4)) {
                if (Initialize.field[row - 1][col + 1] == 'E') {
                    Initialize.field[row - 1][col + 1] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeDownLeft = false;
                    row=row-1;
                    col=col+1;
                    return;
                }
            }
            if (((row + 2) >= 0 && (row + 2) < 3) && ((col - 2) >= 1 && (col +- 2) < 4)) {
                if (Initialize.field[row + 2][col - 2] == 'E') {
                    Initialize.field[row + 2][col - 2] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeDownLeft = false;
                    row=row+2;
                    col=col-2;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.

        if (firstPlayer.detoritMustStopThisSequence_TypeBetweenUp == true) {
            if(tempRowUp>=0&&tempRowUp<3){
                if (Initialize.field[tempRowUp][col] == 'E')//그자리가 비었다면
                {
                    Initialize.field[tempRowUp][col] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeBetweenUp = false;
                    row=tempRowUp;//여기에 둿다는 정보를 winnerEmer...한테 줘야해
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (firstPlayer.detoritMustStopThisSequence_TypeBetweenDown == true) {
            if(tempRowDown>=0&&tempRowDown<3){
                if (Initialize.field[tempRowDown][col] == 'E')//그자리가 비었다면
                {
                    Initialize.field[tempRowDown][col] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeBetweenDown = false;
                    row=tempRowDown;//여기에 둿다는 정보를 winnerEmer...한테 줘야해
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (firstPlayer.detoritMustStopThisSequence_TypeBetweenRight == true) {
            if(tempColRight>=1&&tempColRight<4){
                if (Initialize.field[row][tempColRight] == 'E')//그자리가 비었다면
                {
                    Initialize.field[row][tempColRight] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeBetweenRight = false;
                    col=tempColRight;//여기에 둿다는 정보를 winnerEmer...한테 줘야해
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (firstPlayer.detoritMustStopThisSequence_TypeBetweenLeft == true) {
            if(tempColLeft>=1&&tempColLeft<4){
                if (Initialize.field[row][tempColLeft] == 'E')//그자리가 비었다면
                {
                    Initialize.field[row][tempColLeft] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeBetweenLeft = false;
                    col=tempColLeft;//여기에 둿다는 정보를 winnerEmer...한테 줘야해
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (firstPlayer.detoritMustStopThisSequence_TypeBetweenUpRight == true) {
            if (((row - 1) >= 0 && (row - 1) < 3) && ((col + 1) >= 1 && (col + 1) < 4)) {
                if (Initialize.field[row - 1][col + 1] == 'E') {
                    Initialize.field[row - 1][col + 1] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeUpRight = false;
                    row=row - 1;col=col + 1;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (firstPlayer.detoritMustStopThisSequence_TypeBetweenUpLeft == true) {
            if (((row - 1) >= 0 && (row - 1) < 3) && ((col - 1) >= 1 && (col - 1) < 4)) {
                if (Initialize.field[row - 1][col - 1] == 'E') {
                    Initialize.field[row - 1][col - 1] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeUpLeft = false;
                    row=row - 1;col=col - 1;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.
        if (firstPlayer.detoritMustStopThisSequence_TypeBetweenDownRight == true) {
            if (((row + 1) >= 0 && (row + 1) < 3) && ((col + 1) >= 1 && (col + 1) < 4)) {
                if (Initialize.field[row + 1][col + 1] == 'E') {
                    Initialize.field[row + 1][col + 1] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeDownright = false;
                    row=row-1;col=col-1;
                    return;
                }
            }
        }
        if (firstPlayer.detoritMustStopThisSequence_TypeDownLeft == true) {
            if (((row + 1) >= 0 && (row + 1) < 3) && ((col - 1) >= 1 && (col - 1) < 4)) {
                if (Initialize.field[row + 1][col - 1] == 'E') {
                    Initialize.field[row + 1][col - 1] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeDownLeft = false;
                    row=row-1;col=col+1;
                    return;
                }
            }
            if (((row + 2) >= 0 && (row + 2) < 3) && ((col - 2) >= 1 && (col +- 2) < 4)) {
                if (Initialize.field[row + 2][col - 2] == 'E') {
                    Initialize.field[row + 2][col - 2] = 'X';
                    firstPlayer.detoritMustStopThisSequence_TypeDownLeft = false;
                    row=row+2;col=col-2;
                    return;
                }
            }
        }//필승전략 1. 되는대로 다 막는다.


        while (Initialize.field[row][col] != 'E') {
            if (!isAllUsed.isAllUsed())
                break;
            row = 1;
            col = 2;
            if (Initialize.field[row][col] == 'E') {
                Initialize.field[row][col] = 'X';
                break;
            }//필승전략 2. 11자리 우선 선점


            row = (int) ((Math.random() * 3) % 3);
            col = (int) ((Math.random() * 3) % 3) + 1;
            if (Initialize.field[row][col] == 'E') {
                Initialize.field[row][col] = 'X';
                break;
            } else if (Initialize.field[row][col] != 'E')
                continue;
        }
    }
}
