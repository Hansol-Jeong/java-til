package com.company;

public class Main {

    public static void main(String[] args) {
        int[] integers = {1, 2, 5, 2, 2};
        //1.위 배열에서 최대값을 찾아보세요
        int temp=0;
        for(int j=0;j<integers.length;j++) {
            for (int i = j+1; i < integers.length; i++) {
                if(integers[i]>integers[j]){
                    temp=integers[j];
                    integers[j]=integers[i];
                    integers[i]=temp;
                }

                for(int k=0;k<integers.length;k++)
                    System.out.print(integers[k]);
                System.out.println("");
            }
        }
        System.out.println(temp);
        for(int i=0;i<integers.length;i++)
            System.out.println(integers[i]);
    }
}
