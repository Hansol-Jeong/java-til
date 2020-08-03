package com.company;

public class Main {

    public static void main(String[] args) {
        int seqLength=100;
        float first=0;
        float second=1;
        float baby=0;
        System.out.printf("1: %.0f\n",first);
        System.out.printf("2: %.0f\n",second);

        for(int i=3;i<seqLength+1;i++)
        {
            baby=first+second;
            System.out.printf("%d: %.0f",i,baby);
            System.out.println();
            first=second;
            second=baby;

        }

    }
}
