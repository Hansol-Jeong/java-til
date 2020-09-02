package com.company;

public class ShowField {
    public void show() {
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 4; j++)
                System.out.print(Initialize.field[i][j] + " ");
            System.out.println();
        }
    }

    public void JioakChamadoSikllEffectShow() throws InterruptedException {
        int col = InputToField.col;
        int col1 = InputToField.col1;
        int col2 = InputToField.col2;//col1이 더 큰수야
        int row = InputToField.row;

        char getcol = Initialize.field[row][col];
        char getcol1 = Initialize.field[row][col1];
        char getcol2 = Initialize.field[row][col2];

        Initialize.field[row][col] = '-';
        Initialize.field[row][col1] = '-';
        Initialize.field[row][col2] = '-';

        System.out.println("미안해요 영감...다시는 안쓰기로했는데...울부짖어라 지옥참마도!!!");
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 4; j++) {
                System.out.print(Initialize.field[i][j] + " ");
            }
            System.out.println();
        }
        Thread.sleep(1000);

        for (int j = 0; j < 25; j++)
            System.out.println();

        Initialize.field[row][col] = getcol;
        Initialize.field[row][col1] = getcol1;
        Initialize.field[row][col2] = getcol2;
        System.out.println("미안해요 영감...다시는 안쓰기로했는데...울부짖어라 지옥참마도!!!");
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 4; j++) {
                System.out.print(Initialize.field[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }
}

