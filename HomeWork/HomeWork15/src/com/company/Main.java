package com.company;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 람다식을 이용하여 알고리즘 정답을 테스트하는 프로그램을 작성하시오.
 *
 * 주어진 interface와 실행 메소드를 이용하여 알고리즘 정답을 테스트하는 프로그램을 작성하시오.
 * 이 테스트 방식을 이용하여 실제 알고리즘 문제를 하나 이상 풀이하시오.
 *
 */

interface Solution<T, R> {
    R solve(T t1, T t2);
}

class Algorithm<T, R> {
    boolean test(T input1, T input2, R groundtruth, Solution<? super T, ? super R> solution) {
        return solution.solve(input1, input2).equals(groundtruth);
    }
}

public class Main {
    public static void main(String[] args) {
        Algorithm<Integer, Integer> integerIntegerAlgorithm = new Algorithm<>();
        System.out.println(integerIntegerAlgorithm.test(5,12,4,(N, number) -> {
            List<Set<Integer>> sets = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            sets.add(set);
            set = new HashSet<>();
            set.add(N);
            sets.add(set);
            for (int i = 1; i <= 8; i++) {
                set = new HashSet<>();
                int num = N;
                for (int j = 1; j < i; j++) {
                    num *= 10;
                    num += N;
                }
                set.add(num);
                for (int j = 1; j < i / 2 + 1; j++) {
                    for (int x: sets.get(j)) {
                        for (int y: sets.get(i - j)) {
                            set.add(x + y);
                            set.add(x * y);
                            set.add(x - y);
                            set.add(y - x);
                            if (y != 0) {
                                set.add(x / y);
                            }
                            if (x != 0) {
                                set.add(y / x);
                            }
                            if(set.contains(number)) {
                                return i;
                            }
                        }
                    }
                    sets.add(set);
                }
            }
            return -1;
        }));

    }
}
