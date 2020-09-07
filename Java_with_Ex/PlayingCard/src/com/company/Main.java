package com.company;

import org.w3c.dom.ls.LSOutput;

public class Main {


    public static void main(String[] args) {
    Point point = new Point();
        Circle b = new Circle();
        b.c.x= 3;
        System.out.println(b.c.x);
    }
}
class Circle {
    Point c = new Point(); // 원점
    int r; // 반지름

}

class Point {
    static int x; // x 좌표
    int y; // y 좌표
}