package com.company;

public class SingletonPattern {
//새로운 객체 생성할 수 없어야해
    //클래스.메소드 하면 객체 생겨야해 메소드에서 객체 구현 해야겟지
    public static SingletonPattern instance= new SingletonPattern();//클래스단에서 인스턴스 생성전에 객체를 하나 만들고
    private SingletonPattern(){}//생성자 생성을 다른 클래스에서 진행할 수 없어
    public static SingletonPattern getInstance(){
        return instance;//getInstance하면 이미 생성된 instance를 반환
    }
}

class SingletonPatternTest {
    public static void main(String[] args) {
        //SingletonPattern instance = new SingletonPattern(); // should fail 싱글톤 패턴의 새로운 객체 instance는 새로운 싱글톤 패턴 생성자로 초기화
        SingletonPattern instanceOne = SingletonPattern.getInstance();//Singleton 이란 클래스는 instance란 객체하나를 공유하고 새로운 객체를 만들수 없다
        SingletonPattern instanceTwo = SingletonPattern.getInstance();


        System.out.println(instanceOne == instanceTwo); // should be true
    }
}