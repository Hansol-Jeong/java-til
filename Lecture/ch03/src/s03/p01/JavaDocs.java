package s03.p01;

/**
 * 클래스에대한 설명
 * 호올리 호올리 홀리홀리 이 클래스는 자바독 클래스로서 자바독을 공부하기위해...홀리쉿
 * @author Hansol-Jeong Holy 호올리 호올리
 */
public class JavaDocs {
    /**
     * 멤버 변수에 대한 설명 호올리 호올리
     */
    int memberInt;
    /**
     * 호올리쉿
     */
    String memberString;

    /**
     * 생성자에 대한 설명입니다
     * @param memberInt 입력 1입니다
     * @param memberString 입력 2입니다
     */
    public JavaDocs(int memberInt, String memberString) {
        this.memberInt = memberInt;
        this.memberString = memberString;
    }

    /**
     * 메소드에 대한 설명 홀리쉿
     * @param string 입력 인자(파라미터)에 대한 설명을 적습니다.
     * @return 리턴값에 대한 설명은 여기에 적습니다
     */
    public int methodA(String string){
        return string.length();
    }
    public static void main(String[] args) {
        JavaDocs j= new JavaDocs(1,"string");
        j.methodA("string");
    }
}
