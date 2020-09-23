package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            loop:
            for(String tree: skill_trees) {
                List<Integer> list = new ArrayList<>();
                for(char s: tree.toCharArray()) {
                    int index = skill.indexOf(s);
                    if(index >=0 ) {
                        list.add(index);
                    }
                }
                if(list.size()>0 && list.get(0)!=0) {
                    continue;
                }
                for(int i = 1; i<list.size(); i++) {
                    if(list.get(i-1)+1!=list.get(i)) {
                        continue loop;
                    }
                }
                answer++;
            }
            return answer;
        }
}
