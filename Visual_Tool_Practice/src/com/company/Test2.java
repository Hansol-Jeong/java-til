package com.company;

import javax.swing.*;

public class Test2 {
    public Test2() {
        JFrame frame = new JFrame();
        frame.setTitle("테스트");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton();
        button.setName("버튼");
        button.setText("버튼");
        frame.add(button);
        if(button.getName().equals("버튼")) {
            button.setText("button");
        }//name은 그냥 ID같은거구나
        frame.setVisible(true);
        frame.setSize(300,300);
    }

    public static void main(String[] args) {
        new Test2();
    }
}
