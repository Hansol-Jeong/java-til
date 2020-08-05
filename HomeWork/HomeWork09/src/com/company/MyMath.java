package com.company;
 class MyMath {
    static float PI = 3.1415927f;
    static float E = 2.718281f;
    private MyMath(){};
    public static float min(float ...x){
        float min=x[0];
        for(int i=1;i<x.length;i++)
        min=(x[i]<min?x[i]:min);
        return min;
    }
    public static float max(float ...x){
        float max=x[0];
        for(int i=1;i<x.length;i++)
            max=(x[i]>max?x[i]:max);
        return max;
    }
    public static double abs(double x){
        if(x<0)
            return -x;
        else
            return x;
    }
    public static int floor(double x){
        return (int)x;
    }
    public static int ceil(double x){
        return (int)x+1;
    }
}
class Main {

    public static void main(String[] args) {
        System.out.println(MyMath.PI);
        System.out.println(MyMath.E);
        System.out.println(MyMath.min(2, 3, -4, 6));
        System.out.println(MyMath.max(7, 0, 6, 16, -4));
        System.out.println(MyMath.abs(5));
        System.out.println(MyMath.abs(-2.3));
        System.out.println(MyMath.floor(-1.5232));
        System.out.println(MyMath.ceil(4.6452));
    }
}
