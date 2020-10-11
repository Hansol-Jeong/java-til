package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

//package com.company;
//
//import javax.swing.*;
//import java.awt.*;
//
////간단한 스윙 응용프로그램을 만들어보자
//public class MakeSwing extends JFrame {
//    public MakeSwing() {
//        setTitle("Swing App");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        Container c = getContentPane();
//        c.setLayout(new BorderLayout());
//        JPanel a= new JPanel();
//        JPanel b = new JPanel();
//        a.setLayout(new FlowLayout());
//        b.setLayout(null);
//        c.add(a,BorderLayout.NORTH);
//        c.add(b,BorderLayout.CENTER);
//        a.setBackground(Color.GRAY);
//        b.setBackground(Color.ORANGE);
//        a.add(new Button("OPEN"));
//        a.add(new Button("READ"));
//        a.add(new Button("CLOSE"));
//        JLabel jLabel = new JLabel("1");
//        jLabel.setSize(10,10);
//        jLabel.setLocation(150,150);
//        System.out.println(b.getSize());
////        JLabel jLabel2 = new JLabel("1");
////        jLabel2.setSize(150,150);
////        jLabel2.setLocation(100,100);
//        b.add(jLabel);
////        b.add(jLabel2);
//
//        setVisible(true);
//        setSize(300,300);
//
//
//    }
//
//    public static void main(String[] args) {
//        new MakeSwing();
//    }
//}

public class MakeSwing {
    public MakeSwing() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setBackground(Color.gray);
        panel1.setLayout(new FlowLayout());
        panel1.add(new JButton("OPEN"));
        panel1.add(new JButton("READ"));
        panel1.add(new JButton("CLOSE"));

        panel2.setBackground(Color.orange);
        panel2.setLayout(null);
        for(int i =1; i<4; i++){
            JLabel j = new JLabel(Integer.toString(i));
            j.setSize(10,10);
            j.setLocation(i*20,i*20);//위치는 해당 패널을 기준으로 한다
            panel2.add(j);
        }
        panel.setLayout(new BorderLayout());
        panel.add(panel1,BorderLayout.NORTH);
        panel.add(panel2,BorderLayout.CENTER);
        frame.add(panel);

        frame.setSize(300,300);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new MakeSwing();
    }
}
