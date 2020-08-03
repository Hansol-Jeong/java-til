package s02.p03;

/**
 * 변수(Variables)
 * 클래스에 쓰이는 다양한 변수
 * -클래스스 멤버 변수(static variable, calss variable)
 * -인스턴스 멤버 변수(member variable, attribute, ...)
 * -로컬 변수(local variable)
 * -로컬 파라미터 변수(local parameter variable)(arguments)
 */
public class Variables {
    static int classVar;//클래스 멤버 변수, 스태틱 변수(정적 변수)
    int instanceVar;// 인스턴스 멤버 변수

    public void method(int paramVar) {//로컬 파라미터 변수
        System.out.println(paramVar);
        int localVar;//로컬 변수
        //System.out.println(localVar);로컬변수는 자동으로 0초기화가 안되기 때문에 외워야함, 클래스 인스턴스는 0 으로 초기화되는데 로컬은 안됨
        localVar=10;
        System.out.println(localVar);
        {
            localVar=30;//블록 안쪽에서 바깥쪽 꺼를 접근 할 수 있지만
            int localVar2=20;
        }
        //localVar2=10;//바깥쪽에서 안쪽꺼를 접근할 순 없다, 생명주기가 끝났다(Life-Cycle)

    }
}
class VariableTest{
    public static void main(String[] args) {
        System.out.println("클래스 변수");
        System.out.println(Variables.classVar);//클래스 변수는 클래스 이름으로 바로 접근 가능, 처음엔 0으로 초기화
        Variables.classVar=10;
        System.out.println(Variables.classVar);
        System.out.println();

        System.out.println("인스턴스 멤버 변수");
        Variables var= new Variables();
        System.out.println(var.instanceVar);//으로 초기화
        //Variables.instanceBar 접근 불가능
        var.instanceVar=20;
        System.out.println(var.instanceVar);

        Variables var2= new Variables();
        System.out.println(var2.instanceVar);//0이 초깃값
        System.out.println(var2.classVar);//인스턴스 이름으로 접근가능 하지만 권장하지 않음, 클래스변수는 클래스로 존재하는것이지 객체로 존재하는 것이 아니기에, 위처럼 클래스이름.클래스변수로 접근하는 것을 권장
        System.out.println("로컬 변수");
        var.method(9);
    }
}
