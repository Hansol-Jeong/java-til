package Truck_Bridge;

import java.lang.reflect.Array;
import java.util.*;

public class Truck_Bridge {//LinkedList는 무작위접근이 안되고 순차접근만 되는 대신 ArrayList보다 빠르다!
    public static void main(String[] args) {
        Solution solution = new Solution();
            System.out.println(solution.solution(100,100,new int[] {10,10,10,10,10,10,10,10,10,10}));
    }
}
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        //우선 두가지를 모두 linkedList로 만들자. 순차 접근만 할 것이기 때문에
        LinkedList<Integer> truckList = new LinkedList<>();
        LinkedList<Integer> onTheRoad = new LinkedList<>();
        //초기화 작업
        for(int i : truck_weights) {
            truckList.add(i);
        }
        Integer [] a = new Integer[bridge_length]; Arrays.fill(a,0);
        onTheRoad.addAll(Arrays.asList(a));
        //트럭으로, 0으로 초기화 완료

        while(truckList.size() !=0) {//트럭 리스트가 다 빌 때 까지
            int weightSum = 0;
//            1. 도로 위에 트럭을 한대 올리고
            onTheRoad.removeLast(); onTheRoad.addFirst(truckList.peek());
            answer ++; //어쨋든 시간은 간다.
//            2.무게를 달아보자
            for (int i : onTheRoad) {
                weightSum += i;
            }
            if(weightSum<=weight) {//더했는데 그 무게가 10 이하이다. 그럼 한번더 반복문 돌려야지 그 전에 트럭리스트에서지워주고
                truckList.pollFirst();
            }
            else {//근데 그게아니야, 10보다 커 그려면 도로위에 올라간거 취소하고 0으로 올리고 무게올린것도 취소해야지
                weightSum -= truckList.peek();
                onTheRoad.removeFirst(); onTheRoad.addFirst(0);
            }
        }
        answer+=bridge_length;
        return answer;
    }
}