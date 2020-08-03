package com.company;

public class Main {

    public static void main(String[] args) {

        int[] array = {-10, 1, 3, -5, -1, -1, 1, 1, -1, 10};
        int i;
        int stack = 0;
        int stackArray[] = new int[array.length];
        int max=0;
        int maxK=0;

        //누계 구하기
        for (int j = 0; j < stackArray.length; j++) {
            for (i = j; i < array.length; i++) {
                stackArray[j] = stackArray[j] + array[i];
            }
            System.out.println(stackArray[j]);
        }
//        for (int j = 0; j < stackArray.length; j++){
//            System.out.println(stackArray[j]);
//        }
        System.out.println();
        for(int k=0; k<stackArray.length;k++){
            if(stackArray[k]>max) {
                maxK=k;
                max = stackArray[k];
            }
        }
        System.out.printf("누계가 가장 큰 시작번째 와 그 수는 %d: %d", maxK+1, max);
    }
}
