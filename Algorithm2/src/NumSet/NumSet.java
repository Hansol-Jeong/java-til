package NumSet;

import java.util.*;

public class NumSet {
}
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<numbers.length-1; i++) {
            for (int j = i+1; j<numbers.length; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }
        List<Integer> list = new ArrayList<>(set);
//        list = list.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        list.sort(Integer::compareTo);
        answer = new int [list.size()];
        for(int i = 0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[] {5, 0, 2, 7});
    }
}
