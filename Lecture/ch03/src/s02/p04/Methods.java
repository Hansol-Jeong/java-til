package s02.p04;

/**
 * 메소드(Methods)
 * 객체가 하는 동작(행위)을 정의하는 작업을 수행하는 코드의 집함, 나열
 * 코드의 중복을 방지, 유지보수성을 향상, 코드의 가독성을 개선
 */
class Foo{
    int value;
}
class Bar{
    //인스턴스 메소드, 메소드
    //Return Type(출력의 자료형)
    public int add(int x, int y){//입력 파라미터
        return x + y;//반환값(Return Value)
    }
    //선언(Declaration)- ~한 것이 있다. 실제 구현은 X
    //정의(Definition)- 선언+구현(초기화)

    //정적 메소드(static method), 클래스 메소드
    //void return type은 아무것도 반환하지 않는다.
    public static void classMethod(){
        System.out.println("클래스메소드 호출");
    }
    public static void swapPrimitive(int x, int y){//실제 x,y가 넘어오는 것이 아닌 사본(값)만 넘어옴(Call by value)
        int temp= x;                               //Call by value:메소드 호출을 할 때, 값을 복사해서 넘긴다.(Primitive타입인 경우에 해당)
        x=y;                                       //스택에 쌓여있다가 생명주기가 끝나면 사라진다.
        y=temp;
    }
    public static void swapReference(Foo x, Foo y){//Foo->class, class는 참조형 변수, call by reference
        int temp= x.value;                         //실제 x와 y의 값이 바뀐다.
        x.value= temp;
        x.value=y.value;
        y.value=temp;


    }
    public static int sumAll(int ...params){//여러개의 int를 입력 받는다.
                                            //입력 받은 결과는 배열로 주어진다.,여러개의 인자를 받는 것을 가변인자(Variable arguments)라 한다
        int sum=0;
        for(int value:params){
            sum+=value;
        }
        return sum;

    }
    //메소드 오버로딩 Overloading
    //함수 명은 같고, 입력 인자가 달라야 합니다.
    //입력 인자의 개수도 다를 수 있다.
    public static float sumAll(float ...params){//여러개의 int를 입력 받는다.
        //입력 받은 결과는 배열로 주어진다.
        float sum=0;
        for(float value:params){
            sum+=value;
        }
        return sum+1;

    }
}
class Person{
    static String kor= "사람";
    boolean isHungry= true;//인스턴스 멤버 변수
    //클래스 메소드
    int example=3;//클래스 함수에 쓸 수 없다.
    public static void describe(){
        System.out.println(kor+"사람입니다.");//클래스 메소드는 클래스 변수를 사용할 수 있다. 단, 객체에 속하는 속성은 사용할 수 없다.
        kor="에에?";
    }
    //인스턴스 메소드
    public void eat() {
        System.out.println(example);//인스턴스 메소드에는 쓸 수 있다.
        kor="빠가";
        //isHungry =false;

    }
}


public class Methods {
    int x;
    int y;
    static int z=10;
    public static void classMethod(int x){
        System.out.printf("클래스 메소드 호출%d",x);
       //this.x=this.z;
//        this.z=this.x;
        z=20;
        System.out.println("z="+z);
    }
    public void instanceMethod(int x){
        System.out.printf("인스턴스 메소드 호출%d\n",x);
        this.x=this.z;
        this.z=this.x;
    }

    public static void main(String[] args) {
        Bar.classMethod();//정적메소드는 클래스이름으로 호출할 수 있지만
        //Bar.add() //인스턴스 메소드는 안된다 객체를 생성하고 해야한다.
        Bar bar= new Bar();
        System.out.println(bar.add(1,2));
        bar.classMethod();//인스턴스 이름으로 클래스메소드를 호출할 수는 있으나 권장 x, 클래스이름으로 호출하는 것을 권장

        Person p1= new Person();
        Person p2= new Person();

        Person.describe();

        //인스턴스 메소드는 객체의 속성을 변화시킨다.
        p1.eat();
        System.out.println(p1.isHungry);
        System.out.println(p2.isHungry);
        //클래스 메소드는 객체의 속성과 상관이 없다.
        int x= 10;
        int y=20;
        Bar.swapPrimitive(x,y);
        System.out.println(x+ ","+ y);//Call by value, 실제 객체에 반영이 되지 않는다.
        Foo f1= new Foo();
        Foo f2= new Foo();

        f1.value=10;
        f2.value=20;
        Bar.swapReference(f1,f2);
        System.out.println(f1.value+ ","+f2.value);

        System.out.println(Bar.sumAll(2,5,6,7,8,4));
        System.out.println(Bar.sumAll(2.2f,5.2f,6.2f,7.2f,8,4));

        classMethod(1);//동일 클래스에 속한 클래스 메소드 호출
        Methods.classMethod(2);//상위 클래스 붙여줄 수도 있고
        Methods m= new Methods();
        m.instanceMethod(1);
        Methods M= new Methods();
        M.instanceMethod(2);//새로운 자기자신 클래스객체 생성짱
        Methods.classMethod(3);//새로운 객체인가?=>ㄴㄴ 스택영역에 있는거 호출하고 출력하고 끝(스택영역도없어짐), 객체가 생성된건 아님
    }
}
