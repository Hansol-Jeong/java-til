package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Chapter10OpenChallenge {
    JLabel label4 = new JLabel("시작합니다.");
    public Chapter10OpenChallenge() {
        JFrame frame = new JFrame();
        Container c = frame.getContentPane();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        c.setLayout(new GridLayout(2,1));
        frame.setTitle("Gamble");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        c.add(panel1); c.add(panel2);
        panel1.setBackground(Color.gray);
        panel1.setLayout(new GridLayout(3,3,10,10));
        JLabel label1 = new JLabel("0");JLabel label2 = new JLabel("0");JLabel label3 = new JLabel("0");

        panel2.add(label4);
        panel1.add(new Label()); panel1.add(new Label()); panel1.add(new Label());
        List<JLabel> labelList = Arrays.asList(label1,label2,label3);
        ListIterator<JLabel> iter = labelList.listIterator();
        while(iter.hasNext()) {
            JLabel label = iter.next();
            label.setBackground(Color.MAGENTA);
            label.setOpaque(true);
            panel1.add(label);
        }
        panel1.add(new Label()); panel1.add(new Label()); panel1.add(new Label());
        panel1.setFocusable(true);
        panel1.requestFocus();
        panel1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode==KeyEvent.VK_ENTER) {
                    label1.setText(Integer.toString((int)(Math.random()*10)));
                    label2.setText(Integer.toString((int)(Math.random()*10)));
                    label3.setText(Integer.toString((int)(Math.random()*10)));
                    updatePanel2();
                }
            }

            private void updatePanel2() {
                if (Integer.parseInt(label1.getText())==Integer.parseInt(label2.getText())&&Integer.parseInt(label1.getText())==Integer.parseInt(label3.getText()))
                    label4.setText("추카");
                else
                    label4.setText("아쉽");
//    }

            }
        });



        frame.setSize(300,300);
        frame.setVisible(true);
    }

//    private void updatePanel2(String a, String b, String c) {
//        if (Integer.parseInt(a)==Integer.parseInt(b)&&Integer.parseInt(a)==Integer.parseInt(c)) {
//            label4.setText("추카");
//        }
//        else
//            label4.setText("아쉽");
//    }

    public static void main(String[] args) {
        new Chapter10OpenChallenge();
    }
}
