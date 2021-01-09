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
//	//정수형:byte, short, int, long
//        System.out.println("Byte");
//        System.out.println(Byte.BYTES);//1byte=8bit
//        byte byteValue=42;
//        System.out.println(byteValue);
        System.out.println(Byte.MAX_VALUE);
//        System.out.println(Byte.MIN_VALUE);
//        System.out.println("");
//        //-128~127=256개=2^8=8바이트
//        //byte byteValue1=128; 범위를 벗어나기 때문에 안돼
//       // System.out.println(byteValue.BYTES);
//        System.out.println("Short");
//        System.out.println(Short.BYTES);
//        System.out.println(Short.MAX_VALUE);
//        System.out.println(Short.MIN_VALUE);
//        System.out.println("");
//
//        System.out.println("Integer");
//        System.out.println(Integer.BYTES);//4
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println("");
//
//        System.out.println("Long");
//        System.out.println(Long.BYTES);//8
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(Long.MIN_VALUE);
//        System.out.println("");
//        //메모리 절약을 위해 타입 지정은 필요해
//
//        //Overflow
//        //short shortValue=64000;노농
//        short shortValue=(short)64000;//이렇게 억지로 바꾸는걸 캐스팅이라 한다
//        System.out.println(shortValue);//오버플로우가 발생해서 제대로 된 값이 나오지 않아
//        //32767=2^15-1=>0111111111111111(2)
//        //64000=>10110101011010110(예를들어)=>short캐스팅=>(10110)101011010110=>101011010110:음수가 되버린다 이것이 오버플로우
//        //정수형은 기본적으로 int
//        byte byteValue3=14;//처음엔 무조건 int형이었다가 선언한 자료형에 맞으면 들어간다 아니면 안들어가
//        short shortA=10;
//        short shortB=20;
//        //short shortC=shortA+shortB; 더할 때는 shortA와 shortB가 int형으로 다시 바뀐다 연산이 이루어진다 왜냐하면
//        //더하는 과정에서 overflow가 일어날 수 있기 때문에 따라서 다시 자료형을 지정해줘야 한다
//        short shortC=(short)(shortA+shortB);//이렇게 해야해(shortA int로 바뀌고 B도 int로 바뀌고 나온 int 값이 다시 short로 캐스팅
//        System.out.println("");
//        int bigInt=Integer.MAX_VALUE;
//        int biggerInt=bigInt+1;
//        System.out.println(biggerInt);//overflow
//        System.out.println("");
//
//        long veryBigInt=100000000000000L; //의미: 변수가 long이란 의미고 대입해주는 수도 long이란 의미에서L을 써준다(원래 int기 때문에)
//        System.out.println(veryBigInt);
//        System.out.println("");
//        //질문 연산전에 int로바뀌나 연산 후에 int로 바뀌나=연산 전에 바뀐다(해결)
//        //long이라고 선언 했는데 왜 L을 붙여서 알려줘야 하는가(해결)
//
//        //진수법:2진수 8진수 10진수,,,
//        System.out.println(0b1101);//2진수
//        System.out.println(0423);//8진수:앞에 0만잇으면돼 가능하면 쓰지마요 10진수랑 햇갈려요 그래서 표시도 해줌
//        System.out.println(14);//10진수
//        System.out.println(0x16);//16진수, 10~15=a,b,c,d,e,f
//        //long이랑 long이랑 더하면 int변환없이 long으로 나온다 왜냐하면 int로 변환하면 이미 long으로 캐스팅하기 전에 값이 소실되기 때문에
//        //long으로 바로 나온다.
//        byte flagByte=0b00101100;
//        //실수형 float, double
//        System.out.println("float");
//        System.out.println(Float.BYTES);//4
//        System.out.println(Float.MAX_VALUE);//2.40282*10^38
//        System.out.println(Float.MIN_VALUE);//1.4*10^-45
//        System.out.println("");
//
//        System.out.println("double");
//        System.out.println(Double.BYTES);//8
//        System.out.println(Double.MAX_VALUE);//1.7976931348623157*10^308
//        System.out.println(Double.MIN_VALUE);//4.9*10^-324
//        System.out.println("");
//
//        float floatVal=1.4234f;//그냥두면 더블, 왜 같은 4바이트인데 표현 범위가 달라->표현방법이 달라서
//        double doubleVal=1.423e3;
//
//        System.out.println("char");
//        System.out.println(Character.BYTES);//2
//        System.out.println((int)Character.MAX_VALUE);//1.7976931348623157*10^308
//        System.out.println((int)Character.MIN_VALUE);//4.9*10^-324
//        System.out.println("");//0~6535 정수음수를 표현하는 사인비트가 없다 그걸 다 값표현에 씀
//
//        char charVal='A';
//        System.out.println(charVal);
//        System.out.println((int)charVal);
//        System.out.println('\'');
//        //System.out.println(''');
//        System.out.println('"');
//        System.out.println('\"');
//        System.out.println('\u0041');//유니코드 16진수
//        System.out.println((char)65);
//
//        //논리형 boolean
//        System.out.println("boolean");
//        System.out.println(Boolean.TRUE);
//        System.out.println(Boolean.FALSE);
//        boolean isTrue =true;
//        boolean isFalse=false;
//        //isTrue=1;앙대
//        //문자열(String)
//        System.out.println("String");
//        String s="This is a new string.";
//        System.out.println(s);
//
//        String s1="This"+" "+"is"+" "+"sparta";
//        System.out.println(s1);
//        int intVal10=20;
//        String s2="String+Integer="+intVal10; //자동으로 String으로 변환 후 연결
//        String s3="String+Integer="+Integer.valueOf(intVal10).toString();
//
//        //형변환
//        System.out.println("Casting");
//        int intValue=(int)100.9;//캐스팅은 무조건 소실
//        System.out.println(intValue);
//
      // System.out.println("Upcasting"); //범위가 작은쪽->큰쪽, 정밀도가 낮은쪽->정밀도가 큰쪽
      // byte byteVal=10;
     //int intVal=byteVal;
   // intVal=(int)byteVal;//Upcasting은 자동으로 된다 대부분 군더더기이며 필요가없다.
//
     //  intVal =10244;
    //   long longVal=intVal;
//    longVal=(long)intVal;
//
       // float floatVal=longVal;
       // floatVal=(float)longVal;//long->float으로가면서 부정확하기 때문에 의미있는 색이 나타남 그럼위는 뭐냐 버그다 위도 의미있는 색이 되어야함
//
//        double doubleVal=floatVal;
//        doubleVal=(double)floatVal;

        //DownCasting
       // long longVal=104244L;
        //int intVal=longVal; //자동으로 다운캐스팅안됩니다
      //  int intVal=(int)longVal;
        //System.out.println(intVal);

        //longVal=100_000_000_000L;
        //intVal=(int)longVal;
        //System.out.println(intVal);//다운캐스팅하면서 상위비트 소실

//        char charVal=4123;
//        byte byteVal=(byte)charVal;
//        System.out.println(byteVal);










    }
}
