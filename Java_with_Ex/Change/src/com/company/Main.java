package com.company;

public class Main {

    public static void main(String[] args) {

        int num = 12345;
        int tempNum = 0;
        int sum = 0;
        int count = 0;
        int tempCount = 0;
        int k = 10;

        //카운틑 부터 정한다.
        tempNum = num;
        while (tempNum != 0) {
            count++;
            tempNum = num / k;
            if (tempNum == 0)
                break;
            k = k * 10;
        }//count=5;

        int[] Array = new int[count];//5개 생성하고
        tempCount = count;
        for (int i = 0; i < count; i++) {
            Array[i] = (int) (num / Math.pow(10, --tempCount));
        }

        for (int i = 1; i < count; i++)//1~4
        {
            int tempArray =0;
            int reverseCount = i;
            for (int j = 0; j < i; j++) {
                tempArray+=Math.pow(10,reverseCount--)*Array[j];
            }
            Array[i]-=tempArray;
        }
        for(int i = 0; i<Array.length; i++) {
            sum+=Array[i];
        }
        System.out.println("sum = " + sum);
    }
}