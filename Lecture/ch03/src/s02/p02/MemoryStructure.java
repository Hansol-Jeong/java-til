package s02.p02;

/**
 * 클래스와 객 ㅔ의 메모리 구조
 *
 */
public class MemoryStructure {//클래스 영역
    int x,y;//힙 영역
    String string = "String!!!";//힙 영역, 상수풀

    public void method(int value){//클래스 영역
        //int value->스택 영역
        char c = 'w';//스택 영역, 매소드를 콜할 때 생겼다가 사라진다, 주소값은 64bit
       }
}
