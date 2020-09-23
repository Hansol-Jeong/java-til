package com.company;

import java.util.ArrayList;
import java.util.List;
class SkillTree {
    public static void main(String[] args) {
        String [] skill_trees;
        skill_trees = new String[]{"BACDE", "CBADF", "AECB", "BDA"};
        Solution_Skilltree solution = new Solution_Skilltree();
        System.out.println(solution.solution("CBD",skill_trees));
    }
}
class Solution_Skilltree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        loop: for(String tree: skill_trees) {
            List<Integer> list = new ArrayList<>();
            for(char s: tree.toCharArray()) {
                int index = skill.indexOf(s);
                if(index>=0) {
                    list.add(index);
                }
            }
            if(list.size()>0&&list.get(0)!=0) {
                continue;
            }
            for(int i  = 0; i<list.size()-1; i++) {
                if(list.get(i)+1!=list.get(i+1)) {
                    continue loop;
                }
            }
            answer++;
        }
        return answer;
    }
}