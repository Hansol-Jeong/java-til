package com.company;

public class Main {

    public static void main(String[] args) {
        /**
         * 반복문(Loops)
         * for문, while문
         * 초기화-반복문을 실행하기 위해서 증감할 변수를 초기화
         * 조건식-반복문을 실행할 조건(또는 종료할 조건)
         * 실행문-조건식이 참(또는 거짓)일 경우 실행할 코드,
         * 증감식-실행문이 실행된 후에 변수에 증감을 주는 것
         */
        //for문
        for(int i=0; i<5; i++)
            System.out.println(i);//실행문
        System.out.println("");
        for(int i=0; i<5; i+=2){
            System.out.println(i);
        }
        System.out.println("");
        for(int i=4; i>=0; i--){
            System.out.println(i);
        }
        System.out.println("");
        //nested for
        for(int i=0; i<5; i++){
            for( int j=0;j<5;j++)
                System.out.printf("(%d, %d)", i, j);//iterated반복되었다<->not iterated
            System.out.println();
        }
        //while문
        int i=0;
        while(i<5){
            System.out.println(i);
            i++;
        }
        //do while
        i=0;
        do {
            System.out.println(i);
            i++;
        }while(i<5);//조건과 관계없이 반드시 한번은 실행된다
        //제어문- break, continue
        for(i=0;i<10;i++){
            if(i==3)
                continue;//3을 건너뜀
        System.out.println(i);
        if(i==7)
        break;//7이면 종료
        }
//        for(i=0;i<5;i++)
//            for(int j=0;j<5;j++){
//                if(i==3)
//                    continue;
//                System.out.printf("%d*%d=%d\n",i,j,i*j);
//            }
        //레이블 사용
      outer:
        for(i=0;i<5;i++)
            for(int j=0;j<5;j++){
                if(i==3&&j==2) {
                    System.out.println("continue called");
                    continue outer;//outer로 이동, 반복문에서만 사용 가능
                }
                System.out.printf("%d*%d=%d\n",i,j,i*j);
            }
    }
}
