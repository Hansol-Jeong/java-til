package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//Id1~999999, 병명5이하, 비고사항10이하, 좌측정렬, 문자는 1바이트, 10바이트 넘기면 어째
        int x=0;
        //String y,z;

        Scanner scanner = new Scanner(System.in);
        System.out.println("환자 ID를 기입해주세요");
        int id = scanner.nextInt();
        while (id < 1 || id > 999999) {
            System.out.println("환자 Id를 양식에 맞기 기입 요망(1~999999");
            id=scanner.nextInt();
            if (id >= 1 && id <= 999999) {
                System.out.printf("환자의 ID: %d", id);
                System.out.println();
                //x = id;
                //System.out.println(x); 왜 x가 초깃값으로 나오는가
                break;
            }

        }
//        scanner.next();
//        String s1 = scanner.nextLine();
//        while (s1.length() > 5) {
//            System.out.println("병명을 양식에 맞기 기입 요망(5자 이하");
//            s1=scanner.nextLine();
//            if (s1.length() <= 5) {
//                //y = s1;y를 초기화 안해줬다고 나올까=>if조건에 부합하면 초기화가 되고 아니면 y가 초기화가안되니까
        //그리고 애초에 while(조건)이 잘못됫음
//                break;
//            }
//        }
//        scanner.next();
//        String s2 = scanner.nextLine();
//        //catch-exception도 괜찮아보이는데
//        while (s2.length() > 10) {
//            System.out.println("비고를 양식에 맞기 기입 요망(10자 이하");
//            s2 = scanner.nextLine();
//            if (s1.length() <= 10) {
//               //z = s2;
//                break;
//            }
//        }
        scanner.nextLine();//왜 여기만 넘어가나요
        //System.out.println("s1입력시작");
        System.out.println("환자의 병명을 기입해주세요");
        String s1=scanner.nextLine();
        //System.out.println("s2입력완료");
        if (s1.length() <= 5) {
            //System.out.printf("check1: s1=%s",s1);
            //System.out.println("");
        }
        else {
            while (s1.length() > 5) {
                System.out.println("병명을 양식에 맞기 기입 요망(5자 이하");
                s1 = scanner.nextLine();
                if (s1.length() <= 5) {
                    //System.out.printf("check1: s1=%s", s1);
                    System.out.printf("환자의 병명:%s",s1);
                    System.out.println("");
                    break;
                }
            }
        }
        System.out.println("");
      //  scanner.nextLine();//왜 여기만 넘어가나요
        //System.out.println("s2입력시작");
        System.out.println("환자의 비고 사항을 기입해주세요");
        String s2=scanner.nextLine();
        //System.out.println("s2입력완료");
        if (s2.length() <= 10) {
            //System.out.printf("check2: s2=%s",s2);
            System.out.printf("환자의 비고 사항:%s",s2);
            System.out.println("");
        }
        else {
            while (s2.length() > 10) {
                System.out.println("비고를 양식에 맞기 기입 요망(10자 이하");
                s2 = scanner.nextLine();
                if (s2.length() <= 10) {
                    System.out.printf("check2: s2=%s", s2);
                    System.out.println("");
                    break;
                }
            }
        }
        System.out.println("ღ'ᴗ'ღ========================================ღ'ᴗ'ღ");//
        System.out.printf("=ID:%06d|병명:%-5s|비고 사항:%-10s=", id, s1, s2);
        System.out.println();
        System.out.println("ღ'ᴗ'ღ========================================ღ'ᴗ'ღ");
    }
}
