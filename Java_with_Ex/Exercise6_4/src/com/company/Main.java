package com.company;

class Main {
    // 두 점 (x,y)와 (x1,y1)간의 거리를 구한다.
    static double getDistance(int x, int y, int x1, int y1) {
        int newX=((x-x1)>=0)?(x-x1):(x1-x);
        int newY=((y-y1)>=0)?(y-y1):(y1-y);
        return Math.sqrt(Math.pow(newX,2)+Math.pow(newY,2));
    }

    public static void main(String args[]) {
        System.out.println(getDistance(1, 1, 2, 2));
        Foo foo = new Foo();
        System.out.println(foo.instanceVar);//결과:3, 생성자 위치 상관없이 마지막에 생성자 실행된다.
    }
}
class Foo {
    static int classVar;
    int instanceVar=0;

    public Foo() {
        this.instanceVar = 3;
    }

    static {  // Class Initializater
        classVar = 100;
    }
    {
        System.out.println(instanceVar);
    }
    {  // Instance Initializer
        instanceVar = 10;
    }
    {
        System.out.println(instanceVar);
    }

    static {
        // May be more than one block
    }
}