package com.company;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class MovingHello {
    public MovingHello() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setTitle("살려줘");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("Hello");
        label.setSize(100,20);
        label.setLocation(20,20);
        panel.add(label);

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int x=label.getX(); int y= label.getY();
                int keyCode=e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP: y-=10; break;
                    case KeyEvent.VK_DOWN: y+=10; break;
                    case KeyEvent.VK_LEFT: x-=10; break;
                    case KeyEvent.VK_RIGHT: x+=10; break;
                }
                label.setLocation(x,y);
            }
        });
        panel.setFocusable(true);
        panel.requestFocus();
        frame.setSize(300,300);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new MovingHello();
    }
}
