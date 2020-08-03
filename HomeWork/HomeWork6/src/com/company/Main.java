package com.company;

public class Main {

    public static void main(String[] args) {
        int [][] matA = {{1, 2, 3} ,{4, 5, 2}};
        int [][] matB = {{5, 2}, {6, 2}, {1, 0}};
        int [][] matC=new int [matA.length][matB[0].length];

        for(int N=0;N<matA.length;N++                           ){
            System.out.println();
            for(int K=0;K<matB[0].length;K++){
                for(int M=0;M<3;M++){
                    matC[N][K]+=matA[N][M]*matB[M][K];
                }
                System.out.printf("%3d",matC[N][K]);
            }
        }
    }
}
