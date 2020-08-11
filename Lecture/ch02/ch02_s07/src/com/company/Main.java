package com.company;

public class Main {

    public static void main(String[] args) {
        /**
         * 배열(array)
         * 배열의 특성
         * 하나의 변수로 여러 개의 값을 다룰 수 있다.
         * 동일 자료형만 다룰 수 있다
         * 한번 생성한 배열의 크기는 변하지 않는다.
         * scanner로 입력, 정의된거 재정의 가능?
         * 배열에 속한 값은 메모리에 연속으로 위치한다.
         */
        int intVal;
        int [] integers;

        long [] longs;
        char [] chars;
        String [] strings;//메모리 할당조차 안됨

        //배열의 생성과 초기화
        integers=new int[10];
        int [] integers2=new int[10];
        integers2[0]=5;
        integers2[1]=10;
        integers2[3]=9;

        System.out.println(integers2[0]);
        System.out.println(integers2[1]);
        System.out.println(integers2[2]);
        System.out.println(integers2[3]);//값 지정해주지 않앗다면 0으로 자동초기화
        System.out.println();

        int [] integers3=new int[]{1,2,3,4,5,6};//길이 입력 안해도 된다.
        System.out.println(integers3[0]);
        System.out.println(integers3[1]);
        System.out.println(integers3[2]);
        System.out.println(integers3[3]);
        System.out.println(integers3[4]);
        System.out.println(integers3[5]);
        //System.out.println(integers3[6]);//ArrayIndexOutOfBoundsException 오류 발생
        //배열 사용할 떄에는 선언해 준 길이까지만 접근해야 한다.
        System.out.println();

        int [] integers5 = {1,2,3,4,5};//new int[]굳이 필요 x, 초기화 가능
        float [] floats= new float[5];
        for(int i=0; i<floats.length; i++){
            floats[i]=(float)(i*0.25);
        }
        for(int i=0; i<floats.length; i++){
            System.out.println(floats[i]);
        }

        //Enhanced for, for_each문이라고도 한다
        for(float floatVal:floats){//0부터 시작해서 해당 배열의 길이만큼 자동으로 출력해준다
            System.out.println(floatVal);
        }

        //배열의 크기를 변경
        int [] src={1,2,3,4,5};
        int [] dst=new int [10];
        for(int i=0;i<src.length;i++){
            dst[i]=src[i];//메모리를 두배로 늘리는법
        }

        for(int ingegers:dst){
            System.out.println(ingegers);
        }
        System.out.println();
        int[] src2={1,2,3,4,5};
        int [] dst2=new int[10];
        System.arraycopy(src2,0,dst2,1,src2.length);
        for(int integer:dst2){
            System.out.println(integer);
        }


    }
}
