package com.company;

public class Main {

    public static void main(String[] args) {
        int gameLength = 1000;
        int numPeople = 12;
        int myTurn = 3;//3+12*Cycle
        int Cycle=0;
        int wholeTurn=0;
        int MyTurn=0;
        int JJACK=0;
        int KKUNG=0;
        int Bigger;

        while(wholeTurn<gameLength){
            wholeTurn++;
            myTurn=3+12*Cycle;

            if(wholeTurn==myTurn)
                MyTurn=myTurn;
            else MyTurn=0;

            int x100=MyTurn/100;
            int x10=(MyTurn/10)%10;
            int x=MyTurn%10;
            //System.out.println(wholeTurn+" "+myTurn+" "+MyTurn);
            if(MyTurn!=0)//내턴
            {
                System.out.printf("내턴:%-4d",MyTurn);
                if(x100!=3&&x100!=6&&x100!=9&&x100!=5&&x10!=3&&x10!=6&&x10!=9&&x10!=5&&x!=3&&x!=6&&x!=9&&x!=5)
                   System.out.print("외침을 사용한다: "+MyTurn);//3695 가 포함되지 않은 내턴에 숫자를 외친다
                    if (x100 == 3 || x100 == 6 || x100 == 9) //100자리수가 3또는 6또는 9이면 짝
                        JJACK++;
                    if (x10 == 3 || x10 == 6 || x10 == 9) //10자리수가 3또는6또는9이면 짝
                        JJACK++;
                    if (x == 3 || x == 6 || x == 9) //1자리수가 3또는 6또는 9이면 짝
                        JJACK++;
                if(x100==5)
                    KKUNG++;
                if(x10==5)
                    KKUNG++;
                if(x==5)
                    KKUNG++;
                System.out.print("짝:"+JJACK+" "+"쿵:"+KKUNG);
                System.out.print(" 외친다:");
               // JJACK=2;
               // KKUNG=1;

                {
                    if(JJACK==0){
                        while(KKUNG>0) {//쿵이 0보다 큰동안
                            System.out.print("쿵");
                            KKUNG--;//0이되면그만출력
                        }
                    }
                    if(KKUNG==0){
                        while(JJACK>0) {//짝이 0보다 큰동안
                            System.out.print("짝");
                            JJACK--;//0이되면그만출력
                        }
                    }

                }
                {
                    if(JJACK==2&&KKUNG==1)
                        System.out.print("짝쿵짝");
                    if(JJACK==1&&KKUNG==2)
                        System.out.println("쿵짝쿵");
                }
                {
                    if(JJACK==1&&KKUNG==1)
                        System.out.print("짝쿵");
                }

                JJACK = 0;
                KKUNG = 0;//초기화
                System.out.println();
            }
            if(wholeTurn%12==0)
                Cycle++;
        }
    }
}
