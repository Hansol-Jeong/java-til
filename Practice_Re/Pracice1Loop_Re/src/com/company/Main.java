package com.company;

public class Main {

    public static void main(String[] args) {

//        *
//        **
//        ***
//        ****
//        *****
//        for(int i=0; i<5;i++){
//            for(int j=0;j<i;j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//            *
//           **
//          ***
//         ****
//        *****
//        for(int i=0; i<5;i++){
//            for(int j=0; j<5-i;j++){
//                System.out.print(" ");
//            }
//            for(int j=0; j<i;j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//               *
//              ***
//             *****
//            *******
//        for(int i=0; i<4; i++)
//        {
//            for(int j=i;j<4;j++){
//                System.out.print(" ");
//            }
//            for(int j=0;j<2*i+1;j++){
//                System.out.print("*");
//            }
//            for(int j=i;j<4;j++){
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
//               1
//              222
//             33333
//            4444444
                for(int i=0; i<4; i++)
        {
            for(int j=i;j<4;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*i+1;j++){
                System.out.print(i+1);
            }
            for(int j=i;j<4;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
//                1
//               212
//              32123
//             4321234
        for(int i=0; i<4; i++)
        {
            int k=i+1;
            for(int j=i;j<4;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*i+1;j++){//이만큼 반복하고
                if(k==0)
                    k=-1;
                if(k>0)
                    System.out.print(k--);
                else if(k<=0)
                {
                    k--;
                    System.out.print(-k);//?
//                                                 1
//                                                211이 되야할것같은데 왜 제대로 나옵니까
                }


            }
            for(int j=i;j<4;j++){
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
