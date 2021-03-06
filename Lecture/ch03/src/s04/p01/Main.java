package s04.p01;

/**
 * 상속(Ingeritence)
 * 상속:어떤 클래스의 모든 멤버 변수 및 메소드를 계승항여,
 * 새로운 클래스를 생성하는 것
 *
 * 상속 대상:조상 클래스, 부모 클래스, 상위 클래스, 슈퍼 클래스
 * 상속 결과:자손 클래스, 자식 클래스, 하위 클래스, 서브 클래스
 *
 * 상속 관계를 흔히 'IS-A'관계 라고 부른다.
 */
class Person{
    String name;
    public void work(){
        System.out.println("일하기");
    }
    public void sleep(){
        System.out.println("잠자기");
    }
}
//Person을 상속하는 자식 클래스
//extends 키워드를 이용하여 상속
class Developer extends Person {
    String mainLang;

    public void writeCode(){
        System.out.println("돈 받은 만큼 코딩하기");
    }
}

class Student extends Person {
    String major;

    public void writeCode(){
        System.out.println("밤새 코딩하기");
    }

}
public class Main {
    public static void main(String[] args) {
        Developer developer = new Developer();
        developer.name = "나개발";//Developer이지만, Person이기도 하다.
        System.out.println(developer.name);//Developer 'IS-A' Person
        developer.work();
        developer.sleep();//클래스를 상속하면 모든 멤버 변수와 모든 메소드를 상속 받는다.
        developer.mainLang="자바";
        developer.writeCode();

        Student student = new Student();//Student 'IS-A' Person
        student.writeCode();

    }
}
