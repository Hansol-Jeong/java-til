package com.company;

public class Main {

    public static void main(String[] args) {
        int [][] ints; //이것을 쓰자
        int[] integers[];
        int Cintegers[];

        int [][] ints1= new int[10][5];
        int[][] ints2=new int[10][];//열 갯수 안정해 줄 수 있고
        for(int i=0; i<ints2.length;i++){
            ints2[i]=new int[5];
        }

        int[][] ints3=new int[5][];
        ints3[0]=new int[10];
        ints3[1]=new int[8];
        ints3[2]=new int[2];
        ints3[3]=new int[2];
        ints3[4]=new int[5];
        //ints3[5]=new int[3];//Array index is out of bounds

        int[][] ints4={{1,2,3},{4,5,6},{2,3,4}};//int[][] int4 =new int[3][3]
        int[][] ints5={{1,2,3},{2,3,4},{3,4}};//int[3][]
//        for(int i=0;i<ints5.length;i++){
//            System.out.printf("%d: ",ints5[i].length);
//            for(int j=0;j<ints5[i].length;j++)
//                System.out.print(ints5[i][j]);
//            System.out.println();
//        }
//        System.out.println();

        for (int[] value : ints5) {
            System.out.printf("%d: ", value.length);
            for (int i : value) System.out.print(i);
            System.out.println();
        }
        System.out.println();
        for(int[] enhancedArray: ints5){
            System.out.printf("%d: ",enhancedArray.length);
            for(int  i:enhancedArray) System.out.print(i);
            System.out.println();
        }

    }
}
