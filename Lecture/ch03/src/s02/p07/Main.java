package s02.p07;

/**
 * 초기화 블록(Initializer)
 */
public class Main {
    static int classVar;
    static int instanceCount;//추천되는 예외:인스턴스의 갯수를 유지하는 클래스 변수같은경우는 객체에서 클래스 변수를 다룰 수 있게 (추천됨)됨.
    int instanceVar;
    //static initializer
    static{
        System.out.println("static block1");
        classVar=20;//객체 만들기 전이라 객체변수에 접근 불가

    }
    //object initializer
    {
        System.out.println("block1");
        instanceVar=30;//객체를 만들기 때문에 객체변수 접근가능
        classVar=50;//클래스변수도 마찬가지, but 계속말했지만 추천되지 않음.
        instanceCount++;
    }
    static {
        classVar=5;
        System.out.println("static block2");
    }
    {
        instanceVar=5;
        System.out.println("block2");
    }
}
class MainTest{
    public static void main(String[] args) {
        System.out.println(Main.classVar);
        Main main=new Main();
        System.out.println(Main.instanceCount);
        System.out.println(main.instanceVar);
        System.out.println(Main.classVar);

        Main main2=new Main();
        System.out.println(Main.instanceCount);
        Main main3=new Main();
        System.out.println(Main.instanceCount);

    }
}
