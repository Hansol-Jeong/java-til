package com.company;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame {
    public BorderLayoutEx() {
        setTitle("BorderLayoutEx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        c.setLayout(new BorderLayout(30,20));
        c.add(new JButton("1"),BorderLayout.CENTER);
        c.add(new JButton("2"), BorderLayout.EAST);
        c.add(new JButton("3"),BorderLayout.WEST);
        c.add(new JButton("4"),BorderLayout.SOUTH);
        c.add(new JButton("5"),BorderLayout.NORTH);

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutEx();
    }
}
