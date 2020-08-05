package com.company;

public class SingletonPattern {
    public static SingletonPattern instance= new SingletonPattern();
    private SingletonPattern(){}
    public static SingletonPattern getInstance(){
        return instance;
    }
}

class SingletonPatternTest {
    public static void main(String[] args) {
        SingletonPattern instanceOne = SingletonPattern.getInstance();
        SingletonPattern instanceTwo = SingletonPattern.getInstance();
        System.out.println(instanceOne == instanceTwo);
    }
}