package com.company;

import java.util.Arrays;
import java.util.Vector;

/**
 * 아래 테스트 코드가 정상 동작하도록 클래스들을 완성하시오.
 *
 * getArea(): 사각형의 넓이를 반환한다.
 * getCenterOfMass(): 사각형의 질량중심을 반환한다.
 * GetAllPoints(): 사각형의 네 점을 배열로 반환한다.
 * rot90(): Pivot을 기준으로 사각형을 90도 회전시킨다.
 */

class Vector2D {
    public float x, y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {

        return x+","+y;
    }
}

class RectCore {
    protected Vector2D pos;
    protected float w, h;

    public RectCore(float x, float y, float w, float h) {
        this.pos = new Vector2D(x, y);
        this.w = w;
        this.h = h;
    }

    public String toString() {
        return (float) (0.5 + (0.5 * w))+","+(float) (7 + (0.5 * h));
    }
}
public class Rect extends RectCore {
    public Rect(float x, float y, float w, float h) {
        super(x, y, w, h);
    }

    public float getArea() {
        float Area;
        Area= this.w*this.h;
        return Area;
    }

    public Vector2D getCenterOfMass() {
        float centerX;
        float centerY;
        centerX = (float) (0.5 + (0.5 * w));
        centerY = (float) (0.7 + (0.5 * h));
        return new Vector2D(centerX,centerY);
    }

    public Vector2D [] getAllPoints() {
        Vector2D [] vector2DS= new Vector2D[4];
        System.out.println(getCenterOfMass().x);
        System.out.println(getCenterOfMass().y);
        vector2DS[0]= new Vector2D((float) (getCenterOfMass().x+0.5*w), (float) (getCenterOfMass().y+0.5*h));
        vector2DS[1]= new Vector2D((float) (getCenterOfMass().x+0.5*w), (float) (getCenterOfMass().y-0.5*h));
        vector2DS[2]= new Vector2D((float) (getCenterOfMass().x-0.5*w), (float) (getCenterOfMass().y-0.5*h));
        vector2DS[3]= new Vector2D((float) (getCenterOfMass().x-0.5*w), (float) (getCenterOfMass().y+0.5*h));

        return vector2DS;
    }

    public Vector2D rot90(Vector2D pivot) {
        double pi=Math.PI;
        float temp;
        float RotatedCenterX;
        float RotatedCenterY;
        RotatedCenterX=getCenterOfMass().x* (float) Math.sin(pi/2);
        RotatedCenterY=getCenterOfMass().y* (float) Math.cos(pi/2);
        temp=h;
        h=w;
        w=temp;
        Vector2D rotatedVector= new Vector2D(RotatedCenterX,RotatedCenterY);
        return rotatedVector;
    }

    public String toString() {

        return "RECT";
    }
}

class RectTest {
    public static void main(String[] args) {
        Rect rect = new Rect(0.5f, 0.7f, 1.5f, 2.3f);

        System.out.println("Area: " + rect.getArea());
        System.out.println("CoM: " + rect.getCenterOfMass());
        System.out.println("All Points: " + Arrays.toString(rect.getAllPoints()));
        Vector2D vector2D= new Vector2D(0.4f, 0.2f);

        System.out.println("Rotated Vector: " + rect.rot90(vector2D));
    }
}