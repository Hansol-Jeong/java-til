package com.company;

public class NTiling {
    public static void main(String[] args) {
        Solution_NTiling solution_nTiling = new Solution_NTiling();
        System.out.println(solution_nTiling.solution(3));
    }
}
class Solution_NTiling {
    public int solution(int n) {
        int answer = 0;
        int [] possibility = new int [n+1];//n=3일 때 배열은 4개니까
        possibility[0]=0; possibility[1]=1; possibility[2]=2;
        for(int i = 3; i<=n ; i++)
        possibility[i]= (possibility[i-1]+possibility[i-2])%1000000007;
        answer = possibility[n];
        return answer;
    }
}