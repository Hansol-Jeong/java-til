package StockPrice;

import java.util.Arrays;

public class StockPrice {
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];
        for (int i = 0; i<prices.length-1; i++) {
            int standard = prices[i];
            int compare=0;
            for (int j = i+1; j<prices.length; j++) {
                if(prices[j]<standard) {
                    compare = j;
                    break;
                }
            }
            int time = 0;
            if(compare == 0) {
                time = prices.length-1-i;
            }
            else {
                time = compare - i;
            }
            answer[i] = time;
        }
        prices[prices.length-1] = 0;
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 2, 3})));
    }
}