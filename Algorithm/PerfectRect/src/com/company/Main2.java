package com.company;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().solution(8,12));
    }
}
class Solution2 {
    long gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
    public long solution(int w, int h) {
        long answer = 0;
        answer = (long)w * (long)h - ((long)w + (long)h - gcd(w, h));
        return answer;
    }
}
