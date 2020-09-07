package com.company;

class Main {

    public static void main(String[] args) {
        int[] data = {3,2,9,4,10};
        System.out.println(java.util.Arrays.toString(data));
        System.out.println("최대값 :"+max(data));
        System.out.println("최대값  :"+max(new int[]{})); // 크기가 0인 배열  }
        System.out.println(" :"+max(null));



    }

    private static int max(int[] data) {
        if (data==null)
            return -999999;
        else if(data.length==0)
        return -999999;
//        if (data.length==0)
//            return -999999;
//        else if(data==null)
//            return -999999;//순서만 바꾼건데 이건왜 안돼
//        if(data == null || data.length == 0) {
//            return -999999;
//        }
else {
            int max = data[0];
            for (int i = 1; i < data.length; i++) {
                if (data[i] >= max)
                    max = data[i];
            }
            return max;
        }
    }
}
