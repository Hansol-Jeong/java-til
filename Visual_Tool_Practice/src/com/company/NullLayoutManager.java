package com.company;

import javax.swing.*;
import java.awt.*;

public class NullLayoutManager extends JFrame {
    public NullLayoutManager() {
        setTitle("Null LayoutManagerEx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,500);

        Container c = getContentPane();
        setLayout(null);

        JLabel la = new JLabel("Hello");
        la.setLocation(400,400);

        for (int i = 0; i<9; i++) {
            JButton b = new JButton(Integer.toString(i));
            b.setLocation((i+1)*15, (i+1)*15);
            b.setSize(100,100);
            c.add(b);
        }
    }

    public static void main(String[] args) {
        new NullLayoutManager();
    }
}
