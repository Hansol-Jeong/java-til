package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int Bitnums = 12;//12개의 비트가 있다
        int Cycle = 0;
        int Count = 0;
        int Initial = 1;
        int wholeCount=0;
        //String Mention = "GO";
        int x=1;
        //Count%Countnums=0
        //System.out.printf("b%32s\n", Integer.toBinaryString(1234>>4));
        System.out.println("시작한다");
       // while (Mention =="Go") 이거 왜안될까=>.equals()써라
        while(x==1)
        {
            do {
                System.out.print("0b");
                for(int i=0;i<Bitnums-(Count+1);i++)
                System.out.print("0");
                System.out.printf("%s\n", Integer.toBinaryString(Initial));
                System.out.println(Count);
                wholeCount=Cycle*12+Count;
                System.out.println(wholeCount);
                if(wholeCount==19)
                {

                    System.out.printf("19번째 카운트된 이진수는:%d입니다.",Initial);
                }
                scanner.nextLine();
                Count++;
                Integer.toBinaryString(Initial <<= 1);//Initial=Initial<<1
            }
            while (Count % (Bitnums) != 0);//Count가 13이 되는 순간 Count를 1로 돌림
            Count=0;
            Initial=1;
            Cycle++;
            System.out.println("한번더 ㄱ?(Yes:1,No:2");
            x=scanner.nextInt();
            scanner.nextLine();

        }



    }
}