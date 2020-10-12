package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComponentEx {
    public JComponentEx() {
        JFrame frame = new JFrame("JComponent공통 메소드 예제");
        Container c = frame.getContentPane();
        c.setLayout(new FlowLayout());
        JButton b1 = new JButton("Magenta/Yellow Button");
        JButton b2 = new JButton("===Disabled Button===");
        JButton b3 = new JButton("getX(), getY()");

        b1.setBackground(Color.YELLOW);
        b1.setForeground(Color.MAGENTA);
        b1.setFont(new Font("Arial",Font.ITALIC,20));
        b2.setEnabled(false);//버튼 비활성화
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton)e.getSource();
                frame.setTitle(b.getX()+"," +b.getY());
                System.out.println(b.getLocationOnScreen().getX()+", "+b.getLocation().getY());
            }
        });
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.add(b1); frame.add(b2); frame.add(b3);
    }

    public static void main(String[] args) {
        new JComponentEx();
    }
}
