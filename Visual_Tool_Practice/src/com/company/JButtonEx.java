package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JButtonEx {
    public JButtonEx() {
        JFrame frame = new JFrame("버트으으은");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = frame.getContentPane();
        c.setLayout(new FlowLayout());

        JButton button = new JButton("얼려둔 내마음을 녹이지마요",new ImageIcon("img\\376162_20555_3616.jpg"));
        button.setPressedIcon(new ImageIcon("img\\6064050.jpg"));
        button.setRolloverIcon(new ImageIcon("img\\cry.jpg"));
        c.add(button);
        JLabel label = new JLabel("dd");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new JButtonEx();
    }
}
