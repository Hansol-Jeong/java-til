package com.company;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(12,8));
    }
}
class Solution {
    long Greatest_common_divisor= 1;
    long testNum=1;
    public long solution(int w, int h) {
        long answer = 1;
        long min;
        long rate_w,rate_h;
        long eraseBox=0;
        double incline;

        if(w>=h)
            min=h;
        else min=w;
//공약수 구현
        for(int i = 0; i<min; i++){
            if(w%testNum==0&&h%testNum==0) {
                Greatest_common_divisor=testNum;
                testNum++;

            }
            else
                testNum++;
        }
        rate_w=w/Greatest_common_divisor;
        rate_h=h/Greatest_common_divisor;

        long bigger_rate=0;
        long smaller_rate=0;

        if(rate_w>=rate_h) {
            bigger_rate=rate_w;
            smaller_rate=rate_h;
        }
        else {
            bigger_rate=rate_h;
            smaller_rate=rate_w;
        }

        if(bigger_rate%smaller_rate==0) {
            eraseBox=bigger_rate*Greatest_common_divisor;
            answer=w*h-eraseBox;
        }

        else {
            incline = (double)h/w;
            double tempH1=0;
            double tempH2=0;
            long tempEraseBox=0;
            for(int i = 0; i<w; i++) {
                tempH2=incline*(i+1);
                if(tempH2%1==0) {
                    tempEraseBox += tempH2-(int)tempH1;
                    tempH1 = tempH2;
                }
                else {
                    tempEraseBox += (int)tempH2+1-(int)tempH1;
                    tempH1= tempH2;
                }
            }
            eraseBox=tempEraseBox;
            answer=h*w-eraseBox;
        }

        return answer;
    }
}
//class Solution {
//    int Greatest_common_divisor= 1;
//    int testNum=1;
//    public long solution(int w, int h) {
//        long answer = 1;
//        int min;
//        int rate_w,rate_h;
//        int eraseBox=0;
//
//        if(w>=h)
//            min=h;
//        else min=w;
////공약수 구현
//        for(int i = 0; i<min; i++){
//            if(w%testNum==0&&h%testNum==0) {
//                Greatest_common_divisor=testNum;
//                testNum++;
//
//            }
//            else
//                testNum++;
//        }
//        rate_w=w/Greatest_common_divisor;
//        rate_h=h/Greatest_common_divisor;
//
//        int bigger_rate=0;
//        int smaller_rate=0;
//
//        if(rate_w>=rate_h) {
//            bigger_rate=rate_w;
//            smaller_rate=rate_h;
//        }
//        else {
//            bigger_rate=rate_h;
//            smaller_rate=rate_w;
//        }
//
//        if(bigger_rate%smaller_rate==0) {
//            eraseBox=bigger_rate*Greatest_common_divisor;
//            answer=w*h-eraseBox;
//        }
//        int newBigger_rate;
//        else {
//            while(newBigger_rate>bigger_rate) {
//
//            }
//        }
//        return answer;
//    }
//}