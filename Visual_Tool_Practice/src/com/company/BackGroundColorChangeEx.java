package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BackGroundColorChangeEx {
    public BackGroundColorChangeEx() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setTitle("하기싫어");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.RED);

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (KeyEvent.getKeyText(keyCode).equals("F1")) {
                    panel.setBackground(Color.green);
                    System.out.println("F1 pressed");
                }
                else if (Character.toString(e.getKeyChar()).equals("%")) {
                    panel.setBackground(Color.YELLOW);
                    System.out.println("% pressed");
                }
            }
        });
        panel.setFocusable(true);
        panel.requestFocus();
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BackGroundColorChangeEx();
    }
}
