package com.company;

import java.util.ArrayList;
import java.util.List;

interface Subject2 {//변화하는 수치
    void addObserver(Observer2 observer);
    void removeObserver(Observer2 observer);
    void updateObserver();
}
interface Observer2 {//업데이트 되는 수치
    void update();
}

class Clock2 implements Subject2{
    int time;
    List<Observer2> observer2List;
    public Clock2(int time) {
        this.time = time;
        observer2List= new ArrayList<>();
    }

    @Override
    public void addObserver(Observer2 observer) {
        observer2List.add(observer);
    }

    @Override
    public void removeObserver(Observer2 observer) {
        observer2List.remove(observer);
    }

    @Override
    public void updateObserver() {
        for(Observer2 observer: observer2List) {
            observer.update();
        }
    }
    public void setTime(int time) {
        this.time = time;
        updateObserver();
    }
}
class Doctor2 implements Observer2{
    public Clock2 clock;
    public String state = "보통";
    public Doctor2(Clock2 clock) {
        this.clock = clock;
        this.clock.addObserver(this);
    }

    @Override
    public void update() {
        if (clock.time==9) {
            state="야근";
        }
    }
}
public class Main2 {
    public static void main(String[] args) {
        Clock2 clock = new Clock2(3);
        Doctor2 doctor = new Doctor2(clock);
        Doctor2 doctor1 = new Doctor2(clock);

        System.out.println(doctor.state);
        System.out.println(doctor1.state);

        clock.setTime(9);

        System.out.println(doctor.state);
        System.out.println(doctor1.state);//이제 이걸 어떻게 적용시킬 수 있느냐


    }
}
