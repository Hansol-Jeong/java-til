package s04.p07.poly03;

/**
 * 공변 반환 타입 (Covariant return type)
 */

class Foo {
    public Foo() {
        System.out.println("Foo");
    }

    public Foo getInstance() {
        return this;
    }
}

class Bar extends Foo {
    public Bar() {
        System.out.println("Bar");
    }

    @Override
    public Bar getInstance() { // 오버라이딩이지만, 리턴 타입이 달리질 수 있다.
        return this;
    }
}
//class Mar3 extends Foo3 {
//    @Override
//    public Foo3 getInstance() {
//        return this;
//    }
//}

public class Poly03 {
    public static void main(String[] args) {
        Bar bar = new Bar();
        Foo foo = new Foo();


    }
}