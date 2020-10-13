package p01;
/**
 * 팩토리 패턴
 * -구상 클래스 객체(추상 클래스를 구현한 것(Concrete class))를 전담하여 생성하는 클래스를 구현하는 패턴
 */
interface  Shape {
    void draw();
}
class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangel drawn");
    }
}
class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle drawn");
    }
}
class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square drawn");
    }
}

class RoundedRectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("RoundedRectangel drawn");
    }
}
class RoundedCircle implements Shape {

    @Override
    public void draw() {
        System.out.println("RoundedCircle drawn");
    }
}
class RoundedSquare implements Shape {

    @Override
    public void draw() {
        System.out.println("RoundedSquare drawn");
    }
}

class ShapeFactory {
    Shape getShape(String shapeType) {
        Shape shape = null;

        if(shapeType.equals("Circle")) {
            shape = new Circle();
        } else if (shapeType.equals("Rectangle")) {
            shape = new Rectangle();
        } else if (shapeType.equals("Square")) {
            shape = new Square();
        }
        return shape;
    }
}
//추상 팩토리 패턴(Abstract factory pattern)
abstract class AbstractFactory {
    abstract  Shape getShape(String shapeType);
}
class RoundedShapeFactory extends AbstractFactory {

    @Override
    Shape getShape(String shapeType) {
        Shape shape = null;
        if (shapeType.equals("Circle")) {
            shape =  new Circle();
        } else if (shapeType.equals("Rectangle")) {
            shape = new RoundedRectangle();
        } else if (shapeType.equals("Square")){
            shape = new RoundedSquare();
        }

        return shape;
    }
}
class NormalShapeFactory extends AbstractFactory {

    @Override
    Shape getShape(String shapeType) {
        Shape shape = null;
        if (shapeType.equals("Circle")) {
            shape =  new Circle();
        } else if (shapeType.equals("Rectangle")) {
            shape = new Rectangle();
        } else if (shapeType.equals("Square")){
            shape = new Square();
        }

        return shape;
    }
}

class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded) {
        if (rounded) {
            return new RoundedShapeFactory();
        }
        else
            return new NormalShapeFactory();
    }
}
public class FactoryPattern{
    public static void main(String[] args) {
        //기존에 폴리몰피즘을 사용하면
//        Shape shape = new Circle();
//        shape = new Rectangle(); 또는
        String shapeType = "Circle";
        Shape shape;

//        if(shapeType.equals("Circle")) {
//            shape = new Circle();
//        } else if (shapeType.equals("Rectangle")) {
//            shape = new Rectangle();
//        } else if (shapeType.equals("Square")) {
//            shape = new Square();
//        } else
//            shape = null;
//        if(shape !=null) {
//            shape.draw();이렇게 하면 바람직 하지 않으니  ShapeFactory로 만들어준다. 모든 의존성을 ShapeFactory클래스가 갖는다
        /**
         * 이렇게 매번 직접 객체를 생성할 경우, 새로운 구상 클래스가 만들어 졌을 때 코드 수정이 불가피, 클래스가 구상클래스에 의존하게됨.(Ex: 다른 도형이 추가되면 또 if문 써야됨)
         * 클래스는 추상 클래스(인터페이스)에 의존하는 것이 더 바람직하다. 그래서 만들어 주는 것이 팩토리 클래스(or 팩토리 메소드 패턴) go to line:30 또한 이것을 발전시킨 것이
         * 추상 팩토리 패턴 go to line:44
         */
        //진화(X1 추상화)
        ShapeFactory factory = new ShapeFactory();
        Shape shape1 = factory.getShape("Circle");
        shape1.draw();
        //또진화(X2 추상화)
        Shape shape2 = FactoryProducer.getFactory(true).getShape("Rectangle");
        shape2.draw();
    }
}
