package com.company;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {
    public Test() {
        setTitle("Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        JPanel a = new JPanel();
        JPanel b = new JPanel();


        GridLayout grid = new GridLayout(4,2);
        grid.setVgap(5);
        setLayout(grid);
        c.add(a);
        c.add(b);
        System.out.println(getLayout());

        setSize(600,600);
        a.setBackground(Color.RED);
        b.setBackground(Color.BLUE);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }
}
