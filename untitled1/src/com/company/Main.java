package com.company;

public class Main {

    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(Outer.x);
    }
}
class Outer {
    class InstanceInner {
        int x = 1;
        void innerMethod() {
            int x = 0;
            System.out.println(x);
            System.out.println(this.x);
            System.out.println(Outer.this.x);
            System.out.println(Outer.y);

        }
    }
    static int x = 2;
    static int y = 3;
}