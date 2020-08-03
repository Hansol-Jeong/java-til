package com.company;

public class Main {

    public static void main(String[] args) {
//        int[] integers = {2, 2, 3, 5, 3};
//        int max = 0;
//        int maxI=0;
//        //위 배열에서 최대값을 찾아보세요
//        int temp = 0;
//        for (int i = 0; i < integers.length; i++) {
//            maxI=(integers[i] > max ? i : maxI);
//            max = (integers[i] > max ? integers[i] : max);
//
//        }
//        System.out.println(maxI);
//        System.out.println(max);
        int[] integers = {2, 2, 3, 5, 4};//큰 순서대로 정렬해보자
        int temp=0;

        for(int i=0;i<integers.length;i++){
            for(int j=i+1; j<integers.length;j++){
              if(integers[j]>integers[i]){
                  temp=integers[i];
                  integers[i]=integers[j];
                  integers[j]=temp;

              }

            }
        }
        for(int i=0;i<integers.length;i++){
            System.out.print(integers[i]);}
        }
    }



