package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoubleClick {
    public DoubleClick() {
        JFrame frame = new JFrame();//JFrame이 생길 때 컨텐트 팬이 생긴다
        Container c = frame.getContentPane();//이게 그 컨탠트 팬
        frame.setTitle("더블클리쿠 예제");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
//        frame.add(panel);

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==2) {
                    int r; int b; int g;
                    r=(int)(Math.random()*256);
                    g=(int)(Math.random()*256);
                    b=(int)(Math.random()*256);
                    c.setBackground(new Color(r,g,b));
                }
            }
        });
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new DoubleClick();
    }
}
