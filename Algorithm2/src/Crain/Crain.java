package Crain;

import java.util.ArrayList;
import java.util.List;

public class Crain {

    public static void main(String[] args) {
        int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int [] moves = {1,5,3,5,1,2,1,4};
        Solution solution = new Solution();
        System.out.println(solution.solution(board,moves));

    }
}

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        int length = 0;
        //몇행 몇열 인지 알아야지
        for (int m = 0; m<moves.length; m++) {
            int location = moves[m]-1;
            int target = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][location] == 0)
                    continue;
                else {
                    target = board[i][location];
                    board[i][location]=0;
                    break;
                }
            }
            if(target != 0){
            list.add(target);
            length = list.size()-1;
            if (length >= 1) {
                if (list.get(length) == list.get(length - 1)) {
                    answer++;
                    answer++;
                    list.remove(length);
                    list.remove(length - 1);
                }
                }
            }
        }
        return answer;
    }
}