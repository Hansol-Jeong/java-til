package com.company;
import java.util.ArrayList;
import java.util.List;

public class DateDataBase {
    static List<List<MakeDate>> monthList = new ArrayList<>();
    public DateDataBase() {
        for (int i = 1; i<13; i++) {
            List<MakeDate> dateList = new ArrayList<>();
            for(int j = 1; j<32; j++) {
                dateList.add(new MakeDate(i,j));
            }
            monthList.add(dateList);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
       DateDataBase c =  new DateDataBase();
        System.out.println(c.monthList.get(1));
    }
    public int monthlySum(int month) {
        return 스트림 리듀스로 구해보기
    }
}
class MakeDate {
    int spent=0;
    int income=0;
    int month;
    int date;
    public MakeDate(int month, int date) {
        this.month = month; this.date = date;
    }

    public int getSpent() {
        return spent;
    }
    public void setSpent(int spent) {
        this.spent = spent;
    }
    public int getIncome() {
        return income;
    }
    public void setIncome(int income) {
        this.income = income;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }

    public void spentMoney(int spent) {
        this.spent +=spent;
    }
    public void addIncome(int income) {
        this.income +=income;
    }
    @Override
    public String toString() {
        return month + "월" +" "+date+"일";
    }
    public int dailySum(){
        return income-spent;
    }
}
