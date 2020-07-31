package com.company;

public class Main {

    public static void main(String[] args) {

        /**
         *N-D배열(N-D Arrays)
         * 배열이 배열을 담고 있으면, 다차원 배열이라 한다.(N-D Array)
         * 수학에서 말하는 점이 선이되고 선이 면이되고 공간이되고, 4, 5차원이 되는 것
         */

        //다차원 배열의 선언
        int [][] ints;
        int [] integers[];//hybrid
        int Cintegers[][];//old

        int[][] ints1=new int[10][5];//길이가 5인 인테져 어레이를 담고있는 길이가 10인 인테져 어레이 앞쪽숫자가 더 큰차원의 수
        int[][] ints2=new int[10][];
        for(int i=0; i<ints2.length;i++){
            ints2[i]=new int[5];
        }

        int[][] ints3= new int[5][];
        ints3[0]=new int[10];
        ints3[1]=new int[8];
        ints3[2]=new int[4];
        ints3[3]=new int[15];
        ints3[4]=new int[9];

        int [][] ints4 ={{1,2,3},{4,5,6},{7,8,8}};//int [2][3]
        int [][] ints5={{1,2,3},{1,2},{5,6,7}};//int[3][]
        for (int i=0;i<ints5.length;i++){
            System.out.printf("%d:",ints5[i].length);
            for(int j=0;j<ints5[i].length;j++){
                System.out.print(ints5[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for(int [] fork:ints5){
            System.out.printf("%d:",fork.length);
            for(int forkUp:fork){
                System.out.printf("%d",forkUp);
            }
            System.out.println();
        }
    }
}
