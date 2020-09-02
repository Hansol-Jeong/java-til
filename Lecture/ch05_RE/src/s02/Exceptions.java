package s02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;

/**
 * 오류 / 예외
 * 오류 - 메모리 부족 또는 프로글매 실행이 꼬이는 경우.
 * 더 이상 어떻게 프로글매을 복구해야 할 지 알 수 없다.
 * 프로글매의 문제를 해결하여 해결
 *
 * 예외(Exception)
 * - 오류에 비해서 심각도가 낮고 프로그램의 정상적인 흐름만 방해
 * ->파일을 읽으려 했으나, 해당 파일이 없음
 * ->네트워크 연결이 유실
 * -문제 상황을 처리하는 로직을 구현하여, 런타임에서 자연스럽게 해결 가능
 *
 * 예외 처리
 * - 예외가 발생했을 경우에, 이 상황을 '감지'하고 '처리' 하는 코드
 * - try ~ catch, throws, throw, finally 키워드를 사용
 *
 * Throwable 클래스를 상속하는 자식 클래스들로 이러한 문제를 해결
 */


public class Exceptions {
    public static void main(String[] args) {
        try {
            //예외가 발생할 수 있는 코드
            //예외가 발생할 경우 객체를 던짐(throw)
        } catch (Exception e) {
            //던져진 예외를 받음(catch)
            //Exception 클래스 및 그 자식 클래스를 사용
            //예외상황을 처리하는 코드
        }
        try {
            int[] integers = new int[10];
            integers[20] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());// 안빨간 글씨
            //e.printStackTrace();// 빨간 글씨
        }

        try {
            int[] integers = new int[20];
            System.out.println("던졌다");
        } catch (Exception e) {
            System.out.println("받았따!");
        } finally {
            {
                System.out.println("마침내!");
            }
        }
        FileInputStream file = null;
        try {
            file = new FileInputStream("a text");
            file.read();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일 처리 실패");
        } finally {
            System.out.println("파이날리");
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    System.out.println("앗,,,아앙");
                }
            }
        }
        try (FileInputStream file1 = new FileInputStream("a text")) {
            file1.read();
        } catch (IOException e) {
            System.out.println("파일 처리 실패");
        }
        System.out.println("Program ended normaly");
    }
}
class CheckExceptionThrow {
    void methodA() throws IOException {
        FileInputStream file1 = new FileInputStream("a.text");
        file1.read();
        file1.close();
    }

    void methodB() {
        try {
            methodA();

        } catch (IOException e) {
            System.out.println("메소드 실패");
        }

    }
}
class UncheckedExceptionThrows {
    void methodA(){
        int x = 10/0;
    }
    void methodB() {
        methodA();
    }

    public static void main(String[] args) {
        try{
            new UncheckedExceptionThrows().methodB();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}


class Foo {
    void methodA() throws IOException {}
}
class BarOne extends Foo {
    void methodA() throws  IOException {}
}
class BarTwo extends Foo {
    void methodA() throws FileNotFoundException {}
}
class BarThree extends  Foo {
    //void methodA() throws Exception {}
    //부모 클래스의 메소드를 오버라이드 할 때는
    //부모 클래스의 메소드의 예외보다 더 조상인 예외는 던질 수 없다.
    //오버라이딩 할 때 구현하는 내용을 어느정도 제한하고 있는 부분.
}