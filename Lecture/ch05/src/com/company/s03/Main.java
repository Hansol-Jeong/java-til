package com.company.s03;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static java.lang.annotation.ElementType.*;

/**
 * 애노테이션
 * 사전적의미는?->주석
 * 실제는?->JVM, 컴파일러, 프레임워크에서 사용할 수 있도록 전달하는 메타데이터
 *
 * 기본 애노테이션
 * -@Override, @Deprecated, @SuppressWarnings, @FunctionalInterface /@De~:앞으로 사용되지 않을 뇨속(클래스, 메소드, 변수, etc...), @SuppressWarnings("unused): 특정 경고 메세지를 무시하도록 컴파일러에 전달(회색 없앰)
 * @FunctionalInterface:
 */
//@Target, @Retention: 메타 에노테이션
//@Target: 애노테이션을 사용할 수 있는 대상을 설정
//TYPE: 클래스, 인터페이스, 애노테이션, 열거형
//FIELD: 필드(멤버 변수), 열거형 상수
//METHOD: 메소드
//PARAMETER: 메소드의 입력 파라미터
//CONSTRUCTOR: 클래스의 생성자
//LOCAL_VARIABLE: 로컬 변수
//MODULE: 모듈
//ANNOTATION_TYPE: 애노테이션
//PACKAGE: 패키지
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.SOURCE)//애노테이션 정보를 어디까지 유지할 것인가를 결정하는 Policy(정책) 예를들어 SOURCE는 컴파일러가 사용, (.java->.class로 변경하는 과정에서 쓰임, .class파일에 포함x)
    //CLASS: .class에 포함. JVM에 올라오지는 않음
    //RUNTIME: .class에 포함, JVM에 올라와서 Reflection API에서 사용 가능
@interface SuppressWarningsClone {

    String[] value();
}

/**
 * 멤버변수를 대상으로 하는, Reflection API에서 쓸 수 있는 애노테이션
 * 애노테이션 속성은 String[] 인 value와 "기본값" 기본값을 가지는 valueTwo로 이루어짐
 */
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface  MyAnnotation {
    //애노테이션 속성 (기본 속성 이름은 value)
    String [] value();//이름 다르게 하면 사용법이 달라짐, 무조건 걍 value()로 해, Annotation문법에선 변수뒤에 ()붙여야돼
    String valueTwo() default  "기본값"; //디폴트 값을 정해줄 수 있고, 이건 Annotation에서만 적용되는 문법
    //필드에서 사용할 수 있고, 런타임에서 사용할 수 있고(Reflection API사용 가능)
}
class AnnotationUsage{
    @MyAnnotation("game")//바로 밑줄에만 적용됨, value값이 "game"으로 적용됨 gameName에는 "game"이라는 정보가 저장되어 있다.
    String gameName = "여러분의 틱택토";

    @MyAnnotation(value = "server",valueTwo = "localhost")//범주, 내용(value, valueTwo)
    String serverIP;

    @MyAnnotation(value = "server",valueTwo = "8080")
    String serverPort;

    @MyAnnotation("game")
    String gameMode = "AI vs. AI";

    @MyAnnotation(value = "db", valueTwo = "localhost") //database에는 db, localhost라는 정보가 들어있다.
    String database;//이런거 스프링에서 쓰인다 원래 자바문법에서 할 수 없는 것들을 쓰기 위해서

}
public class Main {
    @SuppressWarnings("unused")
    int x;//사용하지 않은것에 대해 워닝을 억제해라
    public static void main(String[] args) throws IllegalAccessException {
 @SuppressWarnings("unused")
        int x;
 AnnotationUsage obj = new AnnotationUsage();
        Map<String, Object> gameProp = new HashMap<>();
        Map<String, Object> serverProp = new HashMap<>();
        Map<String, Object> dbProp = new HashMap<>();

        Field[] fields = AnnotationUsage.class.getDeclaredFields();//밑에 내용을 가져온 것임, 필드 정보 가져오는 부분(Reflection API) class는 object에 정의되어있는 정적 변수이고, class안에 getDeclaredFields가 정의되어 있다.
//        {
//            @MyAnnotation("game")//바로 밑줄에만 적용됨, value값이 "game"으로 적용됨 gameName에는 "game"이라는 정보가 저장되어 있다.
//                    String gameName = "여러분의 틱택토";
//
//            @MyAnnotation(value = "server",valueTwo = "localhost")
//            String serverIP;
//
//            @MyAnnotation(value = "server",valueTwo = "8080")
//            String serverPort;
//
//            @MyAnnotation("game")
//            String gameMode = "AI vs. AI";
//
//            @MyAnnotation(value = "db", valueTwo = "localhost") //database에는 db, localhost라는 정보가 들어있다.
//                    String database;//이런거 스프링에서 쓰인다 원래 자바문법에서 할 수 없는 것들을 쓰기 위해서
//        }
        for(Field field: fields) {
            MyAnnotation annotation = field.getDeclaredAnnotation(MyAnnotation.class);//필드에서 Annotation정보 가져오는 부분(Reflection API
            if(field.get(obj)==null ) {//필드내용이 정의가 안되어있으면
                field.set(obj, annotation.valueTwo());//valueTwo()로 동작하도록 한다.
            }
            if(annotation.value()[0].equals("game")) {
                gameProp.put(field.getName(), field.get(obj));
            } else if(annotation.value()[0].equals("server")) {
                serverProp.put(field.getName(), field.get(obj));
            } else
                dbProp.put(field.getName(), field.get(obj));
        }
        System.out.println(gameProp);
        System.out.println(serverProp);
        System.out.println(dbProp);
    }
}
