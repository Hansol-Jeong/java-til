package One_Plus_One;

import java.util.*;

public class One_Plus_One {
    public static void main(String[] args) {


        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[] {5,0,2,7})));

    }
}


class Solution {
    public int[] solution(int[] numbers) {
        int answer[];
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            if (i < numbers.length) {
                for (int j = i + 1; j < numbers.length; j++) {
                    set.add(Math.addExact(numbers[i],numbers[j]));
                }
            }
        }
        answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();
//        list = new ArrayList<>(set).stream().sorted(Integer::compareTo).collect(Collectors.toList());
        // answer = list.toArray(new int[set.size()])
//        answer = new int[list.size()];
//        for(int i = 0; i < list.size(); i++) {
//            answer[i] = list.get(i);
//        }
        return answer;
    }
}