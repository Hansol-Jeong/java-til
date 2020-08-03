package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
/**
 *문자열(String)
 * 문자열은 내부적으로 '클래스'로 구성되어 있다
 * 내부에는 문자의 배열로된 데이터가 있다.  char[]
 * 한번 만든 문자열은 변하지 않는다(Immutable)
 * 문자열 편집은 String을 쓰지 않고 Builder나 Buffer등을 사용한다
 */
    //문자열의 생성
        String s1="문자열 생성방법";
        String s2= new String("문자열 생성방법2");//클래스 생성자. 권장하지않음
        String s4="안녕";

       // String s3="abcde";
        //String s4="abcde";+
//        String s5= new String("abcde");
//
//        System.out.println(s3==s4);//문자열을 곧바로 생성할 경우 상수 풀에서 찾아 사용
//        System.out.println(s4==s5);//문자열을 클래스로 생성할 경우 새로운 값을 생성
//        System.out.println(s3.equals(s4));
//        System.out.println(s3.equals(s5));

//        s1=s4;
//        System.out.println(s1);//한번만든 배열이나 문자열은 수정이안된다고햇는데
//        Scanner scanner= new Scanner(System.in);
//        s1=scanner.nextLine();
//        System.out.println(s1);//왜 수정이 되나요

        String s="1234567890";
        System.out.println(s.length());
        System.out.println(s.charAt(2));
        System.out.println(s.indexOf('a'));//두번 째 a는?
        System.out.println(s.equalsIgnoreCase("this is a string"));//실제로 대체하는게 아니다 원래 문자열은 그대로다
        System.out.println(s.replace('i','t'));
        System.out.println(s);
        System.out.println(s.substring(3,9));//3~8까지 출력
        System.out.println("wwef ".trim());//양 옆 공백 제거
        System.out.println("*".repeat(10));//문자열 반복

        char [] characters=s.toCharArray();
        for(char value:characters)
            System.out.println(value);
        String a=s.replace('i','t');
        System.out.println(a);

    }
}
