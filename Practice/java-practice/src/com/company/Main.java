package com.company;

public class Main {

    public static void main(String[] args) {
	/**
    자료형에 대해 복습해봅시다
    자료형-byte short int double long char boolean
    byte=8비트=>-2^7~2^7-1
    short 2bytes=16bit=>-2^15~2^15-1
    integer=4bytes=>32bit=>-2^31~2^31-1
    long=8bytes=>64bit=>-2^63~2^63-1
    모든 리터럴은 int로 정의되고 따라서
    short=큰수 하면 short타입에 큰 int타입이 캐스팅되지 못한다 그렇다고 강제변환해보자
    short=(short)큰수 만약 큰수의 이진수가00000001111111111이라 가정하고 앞의 0부분만 짤린다고해보자
    그러면 11111111이되서 음수가 출력된다
    long부터는 자동 int캐스팅이 되지 않는다 만약에 long+long연산 시 long이 자동으로 int로 변환된다면
    위의 경우처럼 데이터 소실이 일어나기 때문이다
    그렇다면 short+short는 왜 int로 형변환 한 후 더할까 왜냐하면 더하는 과정에서 overflow가 일
    어날 수 있기 때문이다 그래서 int+int=int형으로 표현되기 때문에 short로 다시 캐스팅해줘야한다
    앞서말햇듯이 변수=int형이기 때문에 long=int의 크기를 넘어갈 시 long값을 표시해 줘야한다
    그래서 long=큰수L으로 쓴다

     */
        System.out.println("Byte");
        System.out.println(Byte.BYTES);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println("");

        System.out.println("Short");
        System.out.println(Short.BYTES);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
        System.out.println("");

        System.out.println("Integer");
        System.out.println(Integer.BYTES);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println("");

        System.out.println("Integer");
        System.out.println(Integer.BYTES);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println("");

        







    
    }
}
