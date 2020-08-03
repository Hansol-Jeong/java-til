package com.company;

import com.sun.security.jgss.GSSUtil;

public class Main {

    public static void main(String[] args) {
	int[][] matA={{1,3,3},{1,3,3},{1,2,3}};
	int[][] matB={{3,4,5},{3,4,2},{3,4,2}};
	int[][] newMat= new int[matA.length][matA[0].length];

//	for(int i=0;i<matA.length;i++){
//	    for(int j=0;j<matA[0].length;j++){
//	        newMat[i][j]=matA[i][j]+matB[i][j];
//            System.out.print(newMat[i][j]);
//        }
//        System.out.println();
//    }

	//역행렬
        int[][] reverseA= new int[matA[0].length][matA.length];
	for(int i=0;i<matA[0].length;i++)
    {
        for(int j=0;j<matA.length;j++){
            reverseA[i][j]=matA[j][i];
            System.out.print(reverseA[i][j]);
        }
        System.out.println();
    }
    }
}
