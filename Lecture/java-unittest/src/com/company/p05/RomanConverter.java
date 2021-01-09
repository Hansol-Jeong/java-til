package com.company.p05;

/**
 * TDD, 테스트 주도 개발(Test-Driven Development)
 *  - '실패하는' 테스트 케이스를 먼저 작성하고, 이것을 통과시키는 식으로 코드를 구현하는 방식
 *  - 테스트 케이스 작성 -> 코드 구현 -> (커밋) -> (리팩토링) ->테스트 케이스 작성 .. 을 빠르게 반복
 *    - 1~2분 간격으로 매우 빠른 호흡으로 진행
 *  - 도메인에 대한 지식이 없어도 테스트 케이스를 작성할 수 있다.
 */
public class RomanConverter {
    private String roman = "";

    public void setRoman(String roman) {
        this.roman = roman;
    }

    public RomanConverter(String roman) {
        this.roman = roman;
    }
    public int transform() {
       if(!roman.equals("")) {
           return 1;
       }
        throw new ArithmeticException();
    }
}
