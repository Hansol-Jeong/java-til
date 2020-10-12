package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventListenerEx {
    public ActionEventListenerEx() {
        JFrame frame = new JFrame();//JFrame객체가 만들어질 때 컨텐트팬또한 만들어 진다.
        frame.setLayout(new FlowLayout());
        frame.setTitle("익명클래스로 Action 이벤트 리스너 만들기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Action");
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton)e.getSource();//버튼 b는 이벤트 e의 소스
                if (b.getText().equals("Action"))
                    b.setText("액션");
                else
                    b.setText("Action");
                frame.setTitle(b.getText());
            }
        });
        frame.setSize(300,300);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new ActionEventListenerEx();

    }
}
