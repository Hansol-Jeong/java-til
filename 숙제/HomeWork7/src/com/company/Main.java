package com.company;

public class Main {

    public static void main(String[] args) {
        int[] integers = {1,1,1,1,1,1,-1,-1,-1-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1
        ,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};//정확하다
        int sum = 0;
        int[] integersSum = new int[1000];
        int count = 0;
        int range1;
        int range2;
        int MAX = 0;
        while (count < integersSum.length) {
            range1 = (int) (Math.random() *integers.length);
            range2 = (int) (Math.random() *integers.length);
            if (range1 > range2) {
                for (int i = range2; i < range1; i++) {
                    sum += integers[i];

                }

            } else if (range2 > range1) {
                for (int i = range1; i < range2; i++) {
                    sum += integers[i];
                }

            }
            else if(range1==range2)
                sum=integers[range1];

            integersSum[count]=sum;
                   MAX=(integersSum[count]>MAX?integersSum[count]:MAX);
                   sum=0;
                count++;
                if(count>integersSum.length)break;
            }
        System.out.println(MAX);
        }
    }
