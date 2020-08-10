package com.company;

import java.util.Vector;

class Vector2D{
    public float x,y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "" + this.x + "," + this.y;
    }
}

class RectCore {
    protected Vector2D pos;
    protected  float w, h;

    public RectCore (float x, float y, float w, float h) {
        this.pos = new Vector2D(x,y);
        this.w = w;
        this.h = h;
    }
    public String toString(){
        return "RectCore("+ this.pos + ", "+ w+ ", "+ h + ")";
    }
}

public class Main extends RectCore{
    public Main(float x, float y, float w, float h){
        super(x,y,w,h);
    }
    public float getArea(){
        return w*h;
    }
    public Vector2D getCenterOfMass(){
        return new Vector2D(pos.x+w/2.0f,pos.y+h/2.0f);
    }
    public Vector2D [] getAllPoints(){
        return new Vector2D[] {
                pos,
                new Vector2D(pos.x+w,pos.y),
                new Vector2D(pos.x,pos.y+h),
                new Vector2D(pos.x+w,pos.y+h)
        };
    }
    public void rot90(Vector2D pivot) {
        Vector2D [] oldPoints = getAllPoints();
        Vector2D [] newPoints = new Vector2D[4];
        for(int i=0; i<oldPoints.length;i++){
            newPoints[i] = new Vector2D(-(oldPoints[i].y - pivot.y) + pivot.x,
                    (oldPoints[i].x - pivot.x) + pivot.y);
    }
    float min_x = newPoints[0].x;
    float min_y = newPoints[0].y;
    float max_x = newPoints[0].x;
    float max_y = newPoints[0].y;
        for (
    Compare.Vector2D vector2D: newPoints) {
        min_x = Math.min(vector2D.x, min_x);
        min_y = Math.min(vector2D.y, min_y);
        max_x = Math.max(vector2D.x, max_x);
        max_y = Math.max(vector2D.y, max_y);
    }

    pos = new Vector2D(min_x, min_y);
    w = max_x - min_x;
    h = max_y - min_y;
}}