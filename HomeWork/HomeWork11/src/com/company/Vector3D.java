package com.company;

public class Vector3D {
    private float x, y, z, scala;
     Vector3D(float x, float y, float z){
        this.x= x; this.y= y; this.z= z;
    }
    Vector3D(float scala){
        this.scala=scala;
    }
    public void print(){
         if(scala==0)
        System.out.printf("(%.3f, %.3f, %.3f)\n",getX(),getY(),getZ());
         else
             System.out.printf("%.3f\n",getScala());
    }

    public float getScala() {
         if(this.scala>0)
             return this.scala;
         else
             return -this.scala;
    }

    public void setScala(float scala) {
        this.scala = scala;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public Vector3D add(Vector3D Vector){
        this.x=this.x+Vector.getX();//그냥 x하면 어캐될까나
        this.y=this.y+Vector.getY();
        this.z=this.z+Vector.getZ();

        return new Vector3D(getX(),getY(),getZ());
    }
    public Vector3D add(float x){
        this.x=this.x+x;
        this.y=this.y+x;
        this.z=this.z+x;

        return new Vector3D(getX(),getY(),getZ());
    }
    public Vector3D sub(Vector3D Vector){
        this.x=this.x-Vector.getX();
        this.y=this.y-Vector.getX();
        this.z=this.z-Vector.getZ();

        return new Vector3D(getX(),getY(),getZ());
    }
    public Vector3D sub(float x){
        this.x=this.x-x;
        this.y=this.y-x;
        this.z=this.z-x;

        return new Vector3D(getX(),getY(),getZ());
    }
    public Vector3D inner(Vector3D Vector){
        this.scala=this.getX()*Vector.getX();

        return new Vector3D(getScala());
    }
    public Vector3D mul(float x){
        this.x=this.x*x;
        this.y=this.y*x;
        this.z=this.z*x;

        return new Vector3D(getX(),getY(),getZ());
    }
    public float mag(){
        float a,b;
        a=this.getX()*this.getX()+this.getY()*this.getY()+this.getZ()*this.getZ();
        b=(float)Math.sqrt(a);

        return b;
    }
}

class Vector3DTest {
    public static void main(String[] args) {
        Vector3D v1 = new Vector3D(0.5f, 0.2f, 0.9f);
        Vector3D v2 = new Vector3D(0.8f, 0.1f, 1.3f);

        v1.add(v2).print();
        //v2.sub(v1).print();
        v1.add(0.2f).print();
        //v2.sub(0.05f).print();
       // v1.inner(v2).print();
        v1.mul(1.2f).print();
        System.out.println(v2.mag());
    }
}