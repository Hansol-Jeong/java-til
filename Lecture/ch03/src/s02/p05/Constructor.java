package s02.p05;
/**
 * 생성자(Constructor)
 * 클래스에서 인스턴스를 생성할 때 사용되는 메소드
 * new 키워드를 사용할 때 호출되는 메소드
 *
 * 기본생성자(Default constructor)
 * 파라미터 생성자(Parameter constructors)
 * -->여러개의 생성자를 오버로딩할 수있음
 *
 */

public class Constructor {
    int x;
    int y;
    String z;
    static int k;

    //public Constructor() {}//기본 생성자, 구현하지 않아도 알아서 생긴다.
    //private Constructor(){}//외부에서 호출이 불가능한 생성자도 있다.
    public Constructor(){
//        x=1;
//        y=2;
//        z="초기화";
//        System.out.println("생성자 생성");
        this(0,0,"");
        //질문: this의 3개인자가 정의가 아직 안되지 않았나?->자바는 순서 상관 없다.호이스팅?
    }
    public Constructor(int x, int y, String z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public Constructor(int x, int y, String z,int k){
        this.x=x;
        this.y=y;
        this.z=z;
        this.k=k;
    }

    public Constructor(int a, int b){//생성자는 리턴타입은 받지 않는다.
//        x=a;
//        y=b;
//        z="";
        this(a,b,"");//이러면 인자가 3개니까 자기자신 Constructor중 인자가 세개인 자기자신을 불러옴, this는 맨 첫째 줄에 와야함

    }
}
class ConstructorTest{
    public static void main(String[] args) {
        Constructor c=new Constructor();//기본 생성자 호출
        System.out.println(c.x+","+c.y+","+c.z);//z의 경우 클래스이기 때문에 null로 초기화가 된다, null->아무것도 참조하고 있지 않다.
        Constructor c1=new Constructor(10,20,"파라미터 생성자");
        System.out.println(c1.x+","+c1.y+","+c1.z);
        Constructor c2=new Constructor(10,20);
        System.out.println(c2.x+","+c2.y+","+c2.z);
        Constructor c3=new Constructor(10,20,"뽕빵삥",20);
        System.out.println(c3.x+","+c3.y+","+c3.z+","+c3.k);
    }
}
