package s01;

/**
 * Wrapper 클래스 (Wrapper class)
 *  - 기본형 타입을 객체로 쓰기 위해 있는 클래스
 *  = 기본형 타입이 허용되지 않는 분법에 기본형 타입을 쓰기 위해서 제공
 *
 *  byte -> Byte
 *  char -> Character
 *  short -> Short
 *  int -> Integer
 *  float -> Float
 *  double -> Double
 *  boolean -> Boolean
 */
public class WrapperClass {
    public static Integer add(Integer x, Integer y) {
        return x+y;
    }

public static <T> T bypass (T x) {
    return x;
}

    public static void main(String[] args) {
        Integer integer = new Integer(10);
        Integer integer1 = Integer.valueOf(10);

        Character character = new Character('d');
        Character character1 = Character.valueOf('f');

        // Autoboxing
        Integer interger2 = 4;
        System.out.println(add(4,2));

        bypass(5);

        int x = Integer.parseInt("100");
        int y = new Integer("100");
        int z = integer.valueOf("200");

        int m = new Integer(10);
    }
}
