package Country124;

public class Country124 {
}
class Solution {
    public String solution(int n) {
//        String answer = "";
//        int one=0;
//     while(n>0) {
//         one = n%3;
//         n = n/3;
//
//         if(one == 0) {
//             n --;
//             one = 4;
//         }
//         answer = one+answer;
//     }
//        return answer;
//        String answer = "";
//        int reminder;
//        while(n>0) {
//            reminder = n%3;
//            n=n/3;
//            if(reminder ==0) {
//                n -=1;
//                reminder = 4;
//            }
//            answer = reminder +answer;
//        }
//        if (answer.equals(""))
//            answer = "0";
//        return  answer;
        //단일 스레드에서는 String builder 멀티쓰레드에서는 String buffer 사용하자
        String answer="";
        StringBuilder sb = new StringBuilder();
        int one = 0;
        while(n>0) {
            one = n%3;
            n = n/3;
            if (one ==0) {
                n--;
                one = 4;
            }
            sb.insert(0,one);
        }
        answer = sb.toString();
        return answer;
    }
}