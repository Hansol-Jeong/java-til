package com.company;

import java.util.*;

public class Sortting {
    public static void main(String[] args) {
        Solution_Sortting solution_sortting = new Solution_Sortting();
        solution_sortting.solution(new int[] {3,30,34,5,9});
    }
}
class Elements implements Comparable<Elements> {
    int index;
    int num;
    int copy;

    public Elements(int index, int num, int copy) {
        this.index = index;
        this.num = num;
        this.copy = copy;
    }

    @Override
    public int compareTo(Elements o) {
        return Integer.compare(copy, o.copy);
    }

}
class Solution_Sortting {
    public String solution(int[] numbers) {
        String answer = "";
        int [] copyNum = numbers.clone();

        PriorityQueue heap = new PriorityQueue();
        for(int i = 0; i<numbers.length; i++) {
            if(copyNum[i]>=10) {
                while(copyNum[i]>=10) {
                    copyNum[i] = copyNum[i] / 10;
                }
                heap.add(new Elements(i,numbers[i],copyNum[i]));
            }
            else  heap.add(new Elements(i,numbers[i],copyNum[i]));
        }

        while(!heap.isEmpty()) {
            Elements elements = (Elements) heap.remove();
                answer = answer.concat(String.valueOf(elements.num));
        }
        System.out.println(answer);
        System.out.println(reverse(answer));
        return reverse(answer);
    }

    private String reverse(String answer) {
        String a="";
        for(int i = 0; i< answer.length(); i++) {
         a=a.concat(String.valueOf(answer.charAt(answer.length()-i-1)));
        }
        return a;
    }
}