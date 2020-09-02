package com.company;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        loop:
        for(String tree: skill_trees) {
            List<Integer> list = new ArrayList<>();
            for( char s: tree.toCharArray()) {
                int index = skill.indexOf(s);//없으면 -1 있으면 해당 인덱스
                if(index>=0) {
                   list.add(index);
                }
            }
            if (list.size() > 0 && list.get(0) != 0) {
                continue;
            }
            for(int i = 0; i< list.size(); i++) {
                if(list.get(i-1) +1 != list.get(i)) {
                    continue loop;
                }
            }
            answer++;
        }
        return answer;
    }
}
public class Main2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println( solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA","CBDAE"}));
    }
}


