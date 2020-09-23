package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Farthest {
    public static void main(String[] args) {
        Solution_Farthest solution_farthest = new Solution_Farthest();
        System.out.println(solution_farthest.solution(6,new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
    class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(distance,o.distance);//Priority Queue를 사용하기 위해서
        }
    }
class Solution_Farthest {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int [] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        List<List<Integer>> bigList = new ArrayList<>();
        for(int i = 0; i<n+1; i++) {
            List<Integer> smallList = new ArrayList<>();
            for(int[] e:edge) {
                if(e[0]==i) {
                    smallList.add(e[1]);
                }
                else if (e[1]==i) {
                    smallList.add(e[0]);
                }
            }
            bigList.add(smallList);
        }
        PriorityQueue<Node> heap = new PriorityQueue<>();
        distance[1]=0;
        heap.add(new Node(1,distance[1]));

        while(!heap.isEmpty()) {
            Node node = heap.remove();
            for(int visitingIndex:bigList.get(node.index)) {
                if(node.distance< distance[visitingIndex]) {
                    distance[visitingIndex]=node.distance+1;
                    heap.add(new Node(visitingIndex, distance[visitingIndex]));
                }
            }
        }
        int max = 0;
        distance[0]=0;
        for(int el:distance) {

            if(el==max) {
                answer++;
            }
            if(el>max) {
                max = el;
                answer=1;
            }
        }
        return answer;
    }
}