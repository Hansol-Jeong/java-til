package com.company;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventEx {
    private JLabel label = new JLabel("아 하기싫다");
    public MouseEventEx() {
        JFrame frame = new JFrame();
        frame.setTitle("Mouse이벤트 예제");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setLocation(e.getX(),e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        frame.setLayout(null);
        label.setSize(100,10);
        label.setLocation(30,30);
        frame.add(label);

        frame.setSize(250,250);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MouseEventEx();
    }
}

