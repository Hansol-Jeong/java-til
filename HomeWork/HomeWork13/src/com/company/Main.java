package com.company;


import java.util.ArrayList;

/**
 * List 인터페이스를 구현하여 IntArrayList 클래스를 완성하시오.
 *
 * List는 순서가 있는 연속된 값으로, List 인터페이스에 선언되어 있는 메소드의 기능은 아래와 같다.
 *
 * - append(): List의 마지막에 value를 삽입한다.
 * - prepend(): List의 시작점에 value를 삽입한다. 기존의 데이터를 한 칸씩 뒤로 옮긴다.
 * - insert(): index에 value를 삽입한다. 기존 데이터를 한 칸씩 뒤로 옮긴다.
 * - remove(): index의 value를 삭제한다. 기존 데이터를 한 칸씩 앞으로 당긴다.
 * - get(): index의 value를 반환한다.
 * - length(): List의 길이를 출력한다.
 *
 * IntArrayList는 int []를 이용하여 List를 구현한다.
 * - 생성자에서는 capacity를 입력받으며, 배열의 크기가 부족할 때마다 2배씩 증가시킨다.
 */

interface List {
    public void append(int value);
    public void prepend(int value);
    public void insert(int index, int value);
    public void remove(int index);
    public int get(int index);
    public void length();
    public int lengthNum();
    public void ifOverCapacity(int value);
}

class IntArrayList implements List {
    protected int capacity;
    private int [] Solray;
    private int lastNum=0;

    public IntArrayList(int capacity) {
        this.capacity= capacity;
        Solray= new int [capacity];
    }

    @Override
    public void append(int value) {
        ifOverCapacity(value);
            Solray[lastNum++]=value;
    }

    @Override
    public void prepend(int value) {
        ifOverCapacity(value);
        if(lastNum ==0)
            Solray[lastNum++]=value;
       else {
           int [] newSolray = new int[lastNum+1];
            for (int i = 0; i < lastNum; i++)
                newSolray[i+1]=Solray[i];
            newSolray[0]=value;
            Solray=newSolray;
            lastNum++;
        }
    }

    @Override
    public void insert(int index, int value) {
        ifOverCapacity(value);
        if(index+1>=lastNum) {
            System.out.println("그런인덱스 없습니다");
            return;
        }
        else if (index==0)
            prepend(value);
        else {
            int [] newSolray = new int[lastNum+1];
            for (int i = 0; i < index ; i++)
                newSolray[i]=Solray[i];

            newSolray[index]=value;

            for (int i = index; i < lastNum ; i++)
                newSolray[i+1]=Solray[i];

            Solray=newSolray;
            lastNum++;;
        }
    }

    @Override
    public void remove(int index) {
        if(lastNum==0||index+1>=lastNum)
            System.out.println("장난치지 마십시오 주인님");
        else{
            for(int i = index; i<lastNum-1; i++)
                Solray[i]=Solray[i+1];
            lastNum--;
        }
    }

    @Override
    public int get(int index) {
        return Solray[index];
    }

    @Override
    public void length() {
        System.out.println("배열의 길이는: "+lengthNum());
    }

    @Override
    public int lengthNum() {
        return lastNum;
    }

    @Override
    public void ifOverCapacity(int value) {
        if(lastNum==capacity){
            int [] newSolray = new int[2*capacity];
            if (lengthNum() >= 0) System.arraycopy(Solray, 0, newSolray, 0, lengthNum());
            Solray = newSolray;
            capacity=2*capacity;
        }
    }

    public void show(){
        for(int i=0; i<lengthNum();i++)
            System.out.print(Solray[i]+ " ");
        System.out.println();
        System.out.println("lastNum: "+lengthNum());
        System.out.println("capacity: "+capacity);
        System.out.println();
    }
}

public class Main{
    public static void printList(intArray<Integer> list) {
        for (int i = 0; i < list.lengthNum(); i++) {
            System.out.printf("%d ", list.get(i));
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(10);
        for (int i = 0; i < 20; i++) {
            list.append(i);
        }
        printList(list);

        list.remove(5);
        printList(list);

        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        printList(list);

        list.insert(5, 100);
        printList(list);


    }
}