package com.company;
class Main {

    public static void main(String[] args) {

        String str = "123";
//        System.out.println(Integer.valueOf("1"));//문자열은 자동 숫자로 문자는 자동 아스키 코드로
        System.out.println(str + " 는 숫자입니까? " + isNumber(str));



        str = "1234o";

        System.out.println(str + " 는 숫자입니까? " + isNumber(str));

    }

    private static boolean isNumber(String str) {
        char[] charArray = str.toCharArray();
        for(int i =0; i <charArray.length; i++) {
//            System.out.println(Integer.valueOf(charArray[i]));
            if((Integer.valueOf(charArray[i])>=48)&&(Integer.valueOf(charArray[i])<=57)) {
                continue;
            }
            else return false;
        }
        return true;
    }

}
