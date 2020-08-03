package com.company;

/**
 * 긴 주석
 */
//짧은 주석

/**
 * 변수에 대해 알아볼 겁니다.
 * 변수는 변하는 수
 * 수학의 변수와 유사하다
 * 변수란 거는 변수 타입이 존재하고, 변수에는 병수명, 값을 할당할수 있고
 * 변수의 선언을 배울것이고
 * 변수의 값 할당(리터럴을 이용)
 * 변수명 규칙에 대해 배울 것이다.
 */
public class Main {
    //변하지 않는 수=static, final
    static int STATIC_VARIABLE=10;//이렇게 표시합니다

    public static void main(String[] args) {
	    int x;//인티저(정수)
        x=10;//10을 리터럴이라 한다. 있는 그대로의 상수값
        System.out.println(x);

        int y,z, value;//여러개도 동시 선언 가능
        int valueOne=10,valueTwo=20;//이렇게 한줄에도 가능

        //int int; 이거는 안돼, 이미 키워드로 잡혀있어 자바에서 문법적으로 쓰는 키워드는 변수명으로 사용 불가
        int intOne;//요롷게는 가능
        // int 4four;숫자로 시작할 순 없어
        int 심지어_한글도_됩니다_하지만_쓰지않습니다;
        //int fwei&sfe; 특수문자는 안되지만 $는 쓸수있습니다
        int what$the;//하지만 쓰지 않습니다.
        //변수명을 어떤식으로 쓰면 좋은가 Code Convention
        int valueOfComputer;//첫번째 소문자 그다음 띄어쓰기 대신에 대문자=camelCase라 합니다
        // lowerCamelCase, UpperCamelCase=Pascalcase
        //PascalCase 파스칼케이스는 이렇게쓰지만 변수이름으론 쓰지않습니다
        //만약 숫자를 굳이 앞에 쓰고싶다면
        int _8thWord;//이렇게 씁니다 _는 특수문자가 아닙니다



    }
}
