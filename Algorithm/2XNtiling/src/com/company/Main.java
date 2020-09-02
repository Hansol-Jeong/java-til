package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(60000));
    }
}
class Solution {
    public int solution(int n) {
        int [] integers = new int[n + 1];
        integers[1] = 1;
        integers[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            integers[i] = (integers[i - 1] + integers[i - 2]) % 1000000007;
        }
        return integers[n];
    }
}