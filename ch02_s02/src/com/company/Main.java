package com.company;

/**
 * 자료형에 대해서 알아봅시당(Data Type)
 * 자료형-기본형(Primitive Type),참조형(Reference Type)
 * 기본형 자료형- 정수형, 실수형, 문자형, 논리형
 * 참조형 자로형-문자열(String)
 *
 */
public class Main {

    public static void main(String[] args) {
	//정수형:byte, short, int, long
        System.out.println("Byte");
        System.out.println(Byte.BYTES);//1byte=8bit
        byte byteValue=42;
        System.out.println(byteValue);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println("");
        //-128~127=256개=2^8=8바이트
        //byte byteValue1=128; 범위를 벗어나기 때문에 안돼
       // System.out.println(byteValue.BYTES);
        System.out.println("Short");
        System.out.println(Short.BYTES);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
        System.out.println("");

        System.out.println("Integer");
        System.out.println(Integer.BYTES);//4
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println("");

        System.out.println("Long");
        System.out.println(Long.BYTES);//8
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println("");
        //메모리 절약을 위해 타입 지정은 필요해

        //Overflow
        //short shortValue=64000;노농
        short shortValue=(short)64000;//이렇게 억지로 바꾸는걸 캐스팅이라 한다
        System.out.println(shortValue);//오버플로우가 발생해서 제대로 된 값이 나오지 않아
        //32767=2^15-1=>0111111111111111(2)
        //64000=>10110101011010110(예를들어)=>short캐스팅=>(10110)101011010110=>101011010110:음수가 되버린다 이것이 오버플로우
        //정수형은 기본적으로 int
        byte byteValue3=14;//처음엔 무조건 int형이었다가 선언한 자료형에 맞으면 들어간다 아니면 안들어가
        short shortA=10;
        short shortB=20;
        //short shortC=shortA+shortB; 더할 때는 shortA와 shortB가 int형으로 다시 바뀐다 연산이 이루어진다 왜냐하면
        //더하는 과정에서 overflow가 일어날 수 있기 때문에 따라서 다시 자료형을 지정해줘야 한다
        short shortC=(short)(shortA+shortB);//이렇게 해야해(shortA int로 바뀌고 B도 int로 바뀌고 나온 int 값이 다시 short로 캐스팅
        System.out.println("");
        int bigInt=Integer.MAX_VALUE;
        int biggerInt=bigInt+1;
        System.out.println(biggerInt);//overflow
        System.out.println("");

        long veryBigInt=100000000000000L; //의미: 변수가 long이란 의미고 대입해주는 수도 long이란 의미에서L을 써준다(원래 int기 때문에)
        System.out.println(veryBigInt);
        System.out.println("");
        //질문 연산전에 int로바뀌나 연산 후에 int로 바뀌나=연산 전에 바뀐다(해결)
        //long이라고 선언 했는데 왜 L을 붙여서 알려줘야 하는가(해결)

        //진수법:2진수 8진수 10진수,,,
        System.out.println(0b1101);//2진수
        System.out.println(0423);//8진수:앞에 0만잇으면돼 가능하면 쓰지마요 10진수랑 햇갈려요 그래서 표시도 해줌
        System.out.println(14);//10진수
        System.out.println(0x16);//16진수, 10~15=a,b,c,d,e,f
        //long이랑 long이랑 더하면 int변환없이 long으로 나온다 왜냐하면 int로 변환하면 이미 long으로 캐스팅하기 전에 값이 소실되기 때문에
        //long으로 바로 나온다.
        byte flagByte=0b00101100;







    }
}
