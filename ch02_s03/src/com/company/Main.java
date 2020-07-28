package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	//출력 메소드
        System.out.println("String can be printed");
        System.out.println('C');
        System.out.println(40234);
        System.out.println(1.52f);

        System.out.println("1234\n");//line
        System.out.printf("%s",123);//format
        System.out.printf("%b\n",true);//decimal
        System.out.printf("%d 0x%x 0X%X 0%o", 15, 15, 15, 15);// 데시멀 헥사데시멀 소 대 옥탈(8)
        System.out.printf("%f\n", 14.23);
        System.out.printf("%f\n", 14.23f);
        System.out.printf("%e\n",14.423);//지수표현
        System.out.printf("%c %c \n", 'U', '\u0042');
        System.out.printf("%n");//new line으로 이용

        System.out.printf("%5d.\n", 10); //우측정렬
        System.out.printf("%-5d.\n", 10);//좌측정렬
        System.out.printf("%05d\n",11);//0으로채움

        System.out.printf("%3d\n",12345);//넘으면 넘은대로 출력
        System.out.println("");

        System.out.printf("%5.4f\n", 112334.33);
        System.out.printf("%05.2f\n", 1.425);//우측정렬 뒤에 두자리 먼저확보하고 전체 다섯자리, 점도 한자리 포함함
        System.out.printf("%-5.2f\n",1.425);//좌측정렬
        System.out.printf("%-5.4f\n",1.425);//좌측정렬
        System.out.println("");

        //입력 메소드
        System.out.println("Input Method");
        Scanner scanner = new Scanner(System.in);

       // String s=scanner.next();//공백으로 구분된 String을 입력받는다
//        System.out.println(s);
//        System.out.println(scanner.next());
//        System.out.println(scanner.next());
//        System.out.println(scanner.next());
        //next()메소드는 입력한 내용이 있을 때까지 기다립니다 이것을 Blocking이라고 합니다<->non-blocking
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextInt());
//        System.out.println(scanner.nextInt());
//        System.out.println(scanner.nextLine());
//        System.out.println(scanner.nextLine());
//        System.out.println(scanner.nextLine());//엔터로 구분
        //비교 연산자
        System.out.println("비교연산자"); //출력이 boolean
        System.out.println(10>20);
        System.out.println(10<20);
        System.out.println(10>=10);

        int x=10;
        int y=10;
        System.out.println(x==y);
        System.out.println(x!=y);
        System.out.println("");
        //논리연산자-입출력이 모두 boolean
        //a AND b:a,b 모두 참일떄만 참
        //a OR b:a또는b둘중 하나만 참이어도 참
        //a XOR b :a또는 b 둘중 하나만 참이어야 참
        //NOT a:a가 참이면 거짓, 거짓이면 참
        System.out.println(10<20&40>=2);//AND
        System.out.println(40<2|1>0);//OR
        System.out.println(10>2^5<2);//XOR
        System.out.println(!(10>20));//NOT단항 연산자 Operand가 하나

        //short-circuit 더 빠르다
        System.out.println(10<20&&4<2);
        System.out.println(2>8||2<5);

        //증감 연산자-단항 연산자
        int val=0;
        System.out.println(val++);//expression 평가 후에 +
        System.out.println(++val);//expression 평가 전에 +
        System.out.println(val--);
        System.out.println(--val);
        //val++ *10+- -val=55
        //삼항 연산자
        //(cond)?(true expression):(false expression)
        //boolean   값
        System.out.println(true?1:0);
        System.out.println(false?1:0);
        //비트 연산자
        //정수형 연산에 사용
        System.out.printf("b%32s\n", Integer.toBinaryString(8));
        System.out.printf("b%32s\n", Integer.toBinaryString(8>>1));//0으로 채움
        System.out.printf("b%32s\n", Integer.toBinaryString(7));
        System.out.printf("b%32s\n", Integer.toBinaryString(7<<2));//0으로 채움
        System.out.println();
        System.out.printf("b%32s\n", Integer.toBinaryString(1234));
        System.out.printf("b%32s\n", Integer.toBinaryString(1234>>2));//0으로 채움
        System.out.printf("b%32s\n", Integer.toBinaryString(1234>>4));
        System.out.printf("b%32s\n", Integer.toBinaryString(1234<<2));
        System.out.printf("b%32s\n", Integer.toBinaryString(1234<<4));
        System.out.println();
        System.out.printf("b%32s\n", Integer.toBinaryString(-1));
        System.out.printf("b%32s\n", Integer.toBinaryString(-1>>1));//사인비트로 채움
        System.out.printf("b%32s\n", Integer.toBinaryString(-1>>>1));//sign비트와 무관하게 0으로 채운다
        System.out.printf("b%32s\n", Integer.toBinaryString(-1<<2));
        System.out.println();
        System.out.printf("b%32s\n", Integer.toBinaryString(1252));
        System.out.printf("b%32s\n", Integer.toBinaryString(15234));
        System.out.printf("b%32s\n", Integer.toBinaryString(1252&15234));
        System.out.printf("b%32s\n", Integer.toBinaryString(1252^15234));
        System.out.println();
        System.out.printf("b%32s\n", Integer.toBinaryString(1252));
        System.out.printf("b%32s\n", Integer.toBinaryString(~1252));
        int intVal=4123;
        intVal>>=2;//intVal =intVal>>2;
        //intVal |=412;//intVal=intVal|412;
        System.out.printf("b%32s\n", Integer.toBinaryString(4123));
        System.out.printf("b%32s\n", Integer.toBinaryString(4123>>2));
        System.out.println(intVal);
        System.out.printf("b%32s\n", Integer.toBinaryString(1438));














    }
}
