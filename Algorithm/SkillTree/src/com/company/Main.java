package com.company;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println( solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA","CBDAE"}));
    }
}

class Solution {


    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int count = 0;
        int count2 = 0;

        for(int i=0; i<skill_trees.length; i++) {
            char temp [] = new char[skill.length()];
            for(int j =0 ; j<skill_trees[i].length(); j++) {
                for(int k = 0; k<skill.length() ; k++) {
                    if(skill_trees[i].charAt(j)==skill.charAt(k)) {
                        temp[count++]=skill.charAt(k);
                    }
                }
            }
            for(int j = 0; j<count ; j++) {
                if(temp[j]==skill.charAt(j)) {
                    count2++;
                    continue;
                }
                else break;
            }
            if(count2==count)
                answer++;
            count = 0;
            count2 = 0;
        }
            return answer;
    }
}

