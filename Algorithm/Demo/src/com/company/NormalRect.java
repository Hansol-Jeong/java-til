package com.company;


import java.sql.ShardingKey;

public class NormalRect {
    public static void main(String[] args) {
        Solution_NormalRect solution_normalRect  = new Solution_NormalRect();
        System.out.println(solution_normalRect.solution(8,12));
    }
}
class Solution_NormalRect {
    public long solution(int w, int h) {
        long answer = 1;
        long shorter,longer;
        longer = Math.max(w, h);
        shorter = Math.min(w, h);
//공약수
        long gcd = 1;
       for(int i = 1; i<=shorter; i++) {
           if (longer % i == 0 && shorter % i == 0)
               gcd=i;
       }
       long longer_gcd = longer/gcd;
       long shoretr_gcd = shorter/gcd;

       answer = (long)w*(long)h-(longer_gcd+shoretr_gcd-1)*gcd;

        return answer;
    }
}
