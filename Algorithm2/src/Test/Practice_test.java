package Test;

import java.util.ArrayList;
import java.util.List;

public class Practice_test {
    public static void main(String[] args) {



    }
    class Solution {
        public int[] solution(int[] answers) {
            int[] answer = {};
            List<Integer> list = new ArrayList<>();
            int person1_a=0;
            int person2_a=0;
            int person3_a=0;
            int max = 0;
            int[] person1 = {1,2,3,4,5};
            int[] person2 = {2,1,2,3,2,4,2,5};
            int[] person3 = {3,3,1,1,2,2,4,4,5,5};

            for(int i = 0; i< answer.length; i++) {
                if(person1[i%person1.length]==answers[i])  person1_a++;
                if(person2[i%person2.length]==answers[i])  person2_a++;
                if(person3[i%person3.length]==answers[i])  person3_a++;
            }
            max = person1_a>person2_a?person1_a:person2_a;
            max = max>person3_a?max:person3_a;

            if(max == person1_a) list.add(1);
            if(max == person2_a) list.add(2);
            if(max == person3_a) list.add(3);
            for(int i = 0; i< answer.length; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
