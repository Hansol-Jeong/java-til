package com.company;

import javax.print.Doc;
import java.util.ArrayList;

interface Observer {
    void update();
}
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class Clock implements Subject {
    public ArrayList<Observer> observerArrayList;
    public String time;

    public Clock(String time) {
        this.observerArrayList = new ArrayList<>();
        this.time = time;
    }

    @Override
    public void addObserver(Observer observer) {
        observerArrayList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerArrayList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer:observerArrayList) {
            observer.update();
        }
    }
    public void setTime(String time) {
        this.time = time;
        notifyObservers();
    }
}

class Doctor implements Observer {
    public Clock clock;
    public String state = "보통";

    public Doctor(Clock clock) {
        this.clock = clock;
        this.clock.addObserver(this);
    }

    @Override
    public void update() {
        if(clock.time.equals("9")) {
            state= "야근";
        }
    }
}
public class Main {

    public static void main(String[] args) {
	Clock c = new Clock("8");//8시이고 ArrayList를 가진 Clock객체 c를 생성
	Doctor doctor = new Doctor(c);//각각의 사람은 동일 c를 파라미터로 받음 거기서 c.add(해당객체)
	Doctor doctor1 = new Doctor(c);

        System.out.println(doctor.state);
        System.out.println(doctor1.state);

        c.setTime("9");//set하는 순간 c가 각각의 사람객체의 시간을 업데이트 시킴
        System.out.println(doctor.state);
        System.out.println(doctor1.state);
    }
}
