package Printer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Printer {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println( solution.solution(new int[] {1, 1, 9, 1, 1, 1},0));
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for (int i : priorities) {
            priorityQueue.add(i);
        }
        while (priorityQueue.poll()!=priorities[location]) {
            answer ++;
        }
        int index = 0;
        int max = 0;
        for (int i = 0; i<priorities.length; i++) {
            if((Math.max(priorities[i], max))==priorities[i]) {
                max = priorities[i];
                index = i;
            }
        }
        int count1 = 0;
        if(location>0) {
            for (int i = 0; i < location; i++) {
                if (priorities[location] == priorities[i])
                    count1++;
            }
        }
        int count2 = 0;
        for (int i = index+1; i<priorities.length; i++) {
            if(priorities[location]==priorities[i])
                count2++;
        }
        int count3 = 0;
        for (int i = index+1; i<location; i++) {
            if(priorities[location]==priorities[i])
                count3++;
        }
        if(location<index) {
            return count2+count1+answer+1;
        }
       else return answer+count3+1;
    }
}