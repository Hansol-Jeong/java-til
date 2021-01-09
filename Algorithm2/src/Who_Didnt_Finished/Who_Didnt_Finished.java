package Who_Didnt_Finished;

import java.util.*;

public class Who_Didnt_Finished {


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}	);
    }
}
class Solution {
    public String solution(String[] participant, String[] completion) {
        String temp = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i = 0;

        while(i<completion.length) {
            if(!completion[i].equals(participant[i])) {
                temp = participant[i];
                break;
            }
            else
                i++;
        }
        if(temp.equals("")) {
            temp = participant[participant.length-1];
        }
        return temp;
    }
}