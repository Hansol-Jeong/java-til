package com.company;

import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame {
    public GridLayoutEx() {
        setTitle("GridLayoutEx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout grid = new GridLayout(4,2);
        grid.setVgap(5);

        Container c = getContentPane();
        c.setLayout(grid);
        System.out.println(getLayout());
        c.add(new JLabel("이름"));
        c.add(new JTextField(""));
        c.add(new JLabel("학번"));
        c.add(new JTextField(""));
        c.add(new JLabel("학과"));
        c.add(new JTextField(""));
        c.add(new JLabel("과목"));
        c.add(new JTextField(""));

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        GridLayoutEx gridLayoutEx = new GridLayoutEx();
        System.out.println(gridLayoutEx.getLayout());

    }
}
