package s04.p05.subp01;

public class ClassA {
    public int x;
    protected int y;
    int z; // default (=package)
    private int w;

    public void methodA() {}
    protected void methodB() {}
    void methodC() {} // default (=package)
    private void methodD() {} // 내부 구현을 위해서만 쓴다.

    public void methodTest() {
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println("w"+w);

        methodA();
        methodB();
        methodC();
        methodD();
    }
}

class ClassATest { // 같은 패키지
    public static void main(String[] args) {
        ClassA obj = new ClassA();
        System.out.println(obj.x);
        System.out.println(obj.y);
        System.out.println(obj.z);
        // System.out.println(obj.w); private

        obj.methodA();
        obj.methodB();
        obj.methodC();
        // obj.methodD(); private
        obj.methodTest();//프라이빗을 포함한 퍼블릭은 쓸수 있다.퍼블릭으로 접근해서 그안의 프라이빗을 건든다
    }
}