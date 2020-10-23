package com.company.s05_Re.p01;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String [] strings = {"fast", "campus", "java", "backend", "choigo", "best", "people"};
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));//첫글자 알파벳 순으로 정렬

        class MyComparator implements Comparator<String> {

            @Override
            public int compare(String o1, String o2) {
                return o1.substring(1).compareTo(o2.substring(1));
            }
        }
        Arrays.sort(strings, new MyComparator());//두번째 글자부터 비교한다.
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, Comparator.comparing(o -> o.substring(2)));
        System.out.println(Arrays.toString(strings));
    }
}
