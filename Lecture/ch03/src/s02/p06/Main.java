package s02.p06;

/**
 * Getter,Setter
 * 멤버 변수를 간접적으로 다룰 수 있게 해 주는 메소드
 * 멤버 변수의 캡슐화(Encapsulation)에 도움이 됨
 * ->정보의 은닉/보호
 * 멤버 변수의 값을 제한헤야 할 때 유용
 */
public class Main {
    int x, y;
    String z;
    float w;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        if(x>0 && x<=1000){
            this.x=x;

        }
        else{
            System.out.println("~~~~");
        }

    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    }
class MainTest {
    public static void main(String[] args) {
        Main m=new Main();
        m.x=10;
        System.out.println(m.x);//직접적인 접근은 권장되지 않음

        m.setX(-100);
        System.out.println(m.getX());



    }
}
