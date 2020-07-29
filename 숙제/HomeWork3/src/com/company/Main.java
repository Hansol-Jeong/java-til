package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1,x2,x3;
        int winner;
        System.out.println("x1입력");
        x1=scanner.nextInt();
        System.out.println("x2입력");
        x2=scanner.nextInt();

        winner=(x1>x2?x1:x2);
        System.out.println("x3입력");
        x3=scanner.nextInt();
        winner=(winner>x3?winner:x3);
        System.out.printf("우승자는%d",winner);









    }
}
