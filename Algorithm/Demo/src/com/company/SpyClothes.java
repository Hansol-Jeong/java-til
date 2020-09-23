package com.company;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class SpyClothes {
    public static void main(String[] args) {
        String [][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Solution_SpyClothes solution_spyClothes = new Solution_SpyClothes();
        System.out.println(solution_spyClothes.solution(clothes));

    }
}

class Solution_SpyClothes {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new Hashtable<>();
        int value = 1;
        for (String [] cloth: clothes ) {
            String key = cloth[1];
            if(!map.containsKey(key)) {
                map.put(key,value);
            }
            else map.put(key,++value);
        }
        for (int values: map.values()) {
            answer = answer*(values+1);
        }
        return answer-1;
    }
}