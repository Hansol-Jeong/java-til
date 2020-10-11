package com.company;

import javax.swing.*;
import java.awt.*;

public class SwingFrame extends JFrame {

    public SwingFrame() {
        setTitle("300X300 swing frame");
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingFrame swing = new SwingFrame();
        swing.getContentPane();
    }
}
