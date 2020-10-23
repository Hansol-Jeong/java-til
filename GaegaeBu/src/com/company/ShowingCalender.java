package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ShowingCalender {
    Scanner scan = new Scanner(System.in);
    int selectedMonth;
    int selectedDate;
    public ShowingCalender() {
        DateDataBase db = new DateDataBase();
        {
        System.out.println("월 선택");
            int i = 1;
            for (List<MakeDate> month : db.monthList) {
                System.out.printf("%5s", i + "월"); System.out.printf("(%10d)", monthlySum(i));
                if (i % 4 == 0) System.out.println();//이게되누
                i++;
            }
        }//월 선택 메시지
        {
            int i = 1;
            selectedMonth = scan.nextInt();
            System.out.println(selectedMonth+"월의 일별정리");
            for (MakeDate dates: db.monthList.get(selectedMonth-1)) {
                System.out.printf("%5s",dates.date+"일"); System.out.printf("(%10d)", dailySum(i));
                if (i % 4 == 0) System.out.println();
                i++;
            }
        }


    }

    public static void main(String[] args) {
        ShowingCalender cal = new ShowingCalender();
    }
}
