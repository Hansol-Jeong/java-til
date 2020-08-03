package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] matA={{1,2,3},{3,4,5}};
        int[][] matB={{3,4,5},{1,4,2}};
        int[][] newMat = new int[matA.length][matA[0].length];
        int temp;
        //1. matA+matB를 구하고 출력하시오.
        //2. matA를 TransPose하고 출력하시오.

        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                newMat[i][j]=matA[i][j]+matB[i][j];
                System.out.printf("%d",newMat[i][j]);
            }
            System.out.println();
        }
        //int[][] reverseA=new int[matA[matA.length].length][matA.length];
        // 이거 안돼matA[matA.length].length의 의미는mathA의 행의 길이=2,mathA의 2행의 열의길이란 의미인데 2행은없어 0,1행만 있음
        int[][] reverseA=new int[matA[matA.length-1].length][matA.length];
        for(int i=0;i<reverseA.length;i++){
            for(int j=0;j<reverseA[i].length;j++){
                reverseA[i][j]=matA[j][i];
                System.out.print( reverseA[i][j]);
            }
            System.out.println();
        }

    }
}
