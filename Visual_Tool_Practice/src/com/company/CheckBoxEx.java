package com.company;

import javax.swing.*;
import java.awt.*;

public class CheckBoxEx {
    public CheckBoxEx() {
        JFrame frame = new JFrame("체크박스 예제");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = frame.getContentPane();
        c.setLayout(new FlowLayout());

        JCheckBox apple = new JCheckBox("사과");
        JCheckBox pear = new JCheckBox("배");
        JCheckBox cherry = new JCheckBox("체리",new ImageIcon("img\\cry.jpg"));
        c.add(apple); c.add(pear); c.add(cherry);
        cherry.setBorderPainted(true);
        cherry.setSelectedIcon(new ImageIcon("img\\Trump.jpg"));

        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBoxEx();
    }
}
