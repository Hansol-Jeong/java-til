package com.company;

import javax.swing.*;
import java.awt.*;

public class JLabelEx {
    public JLabelEx() {
        JFrame frame = new JFrame("레이블 예제(라벨아냐?)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = frame.getContentPane();
        c.setLayout(new GridLayout(3,1));

        JLabel textLabel = new JLabel("사랑한다");
        ImageIcon imageIcon = new ImageIcon("img/cry.jpg");
        JLabel imageLabel = new JLabel(imageIcon);

        JLabel label = new JLabel("홀리씻",new ImageIcon("img\\No god.jpg"),SwingConstants.CENTER);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(textLabel);
        c.add(panel); c.add(imageLabel); c.add(label);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new JLabelEx();
    }
}
