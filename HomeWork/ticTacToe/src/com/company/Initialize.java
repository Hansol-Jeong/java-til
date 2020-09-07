package com.company;

public class Initialize {
   static char [][]  field = new char[3][5];//공유할 거니까 스테틱 아무리 객체 생성해도 필드는 하나!

    public void initialize() {
        for(int i =0; i< 3;i++)
            field[i][4]='G';//스타트로 씀
        for(int i =0; i< 3;i++)
            field[i][0]='G';//스타트로 씀
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 4; j++) {
                field[i][j]='E';
                System.out.print(field[i][j]+" ");
            }
            System.out.println();
        }
    }
}
