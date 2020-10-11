package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.net.JarURLConnection;
import java.util.concurrent.Flow;

class Ex2 {
    public Ex2() {
        JFrame frame = new JFrame();
        frame.setTitle("실습문제 2번");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout(5,7));
        frame.add(new Button("North"),BorderLayout.NORTH);
        frame.add(new Button("South"),BorderLayout.SOUTH);
        frame.add(new Button("Center"),BorderLayout.CENTER);
        frame.add(new Button("East"),BorderLayout.EAST);
        frame.add(new Button("West"),BorderLayout.WEST);

        frame.setVisible(true);
        frame.setSize(300,300);
    }
}
class Ex3 {
    public Ex3() {
        JFrame frame = new JFrame();
        frame.setTitle("실습문제 3번");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,10));
        for (int i = 0; i<10; i++) {
            JButton button = new JButton(Integer.toString(i));
            frame.add(button);
        }
        frame.setVisible(true);
        frame.setSize(300,300);
    }
}
class Ex4 {
    public Ex4() {
        JFrame frame = new JFrame();
        frame.setTitle("실습문제 4번");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,10));
        for (int i = 0; i<10; i++) {
            JButton button = new JButton(Integer.toString(i));
            frame.add(button);
            button.setBackground(Color.getHSBColor(i*10,i*20,i*30));
        }
        frame.setVisible(true);
        frame.setSize(300,300);
    }
}
class Ex5 {
    public Ex5() {
        JFrame frame = new JFrame();
        frame.setTitle("실습문제 5번");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));
        for (int i = 1; i<17; i++) {
            JLabel label = new JLabel(Integer.toString(i));
            panel.add(label);
            label.setOpaque(true);//이걸 해줘야 배경색이 변함
            label.setBackground(Color.getHSBColor(i*10,i*20,i*30));
        }
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(300,300);
    }
}
class Ex6 {
    public Ex6() {
        JFrame frame = new JFrame();
        frame.setTitle("실습문제 6번");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        for(int i = 0; i<10;i++) {
            JLabel label = new JLabel(Integer.toString(i));
            label.setOpaque(true);
            label.setBackground(Color.BLUE);
            label.setSize(20,20);
            label.setLocation((int)(Math.random()*200)+50,(int)(Math.random()*200)+50);
            frame.add(label);
        }

        frame.setVisible(true);
        frame.setSize(300,300);
        frame.setBackground(Color.gray);
    }
}
class Ex7 {
    public Ex7() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(); JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();JPanel panel3 = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(panel1,BorderLayout.NORTH);
        panel.add(panel2,BorderLayout.CENTER);
        panel.add(panel3,BorderLayout.SOUTH);
        {
            panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel label = new JLabel("수식입력");
            JTextField textField = new JTextField(15);
            panel1.add(label); panel1.add(textField);
        }
        {
            panel2.setLayout(new GridLayout(4, 4));
            for(int i = 0; i<10; i++) {
                JButton button = new JButton(Integer.toString(i));
                panel2.add(button);
            }
            panel2.add(new JButton("CE"));
            panel2.add(new JButton("계산"));
            panel2.add(new JButton("+"));
            panel2.add(new JButton("-"));
            panel2.add(new JButton("x"));
            panel2.add(new JButton("/"));
        }
        {
            panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel label = new JLabel("계산 결과");
            JTextField textField = new JTextField(15);
            panel3.setBackground(Color.YELLOW);
//            label.setSize(1000,1000);
//            label.setLocation(1000,1000);//배치관리자가 있는 이상 이런건 의미가 없다.
            panel3.add(label); panel3.add(textField);
        }

        frame.add(panel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
class Ex8 {
    public Ex8() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel.setLayout(new BorderLayout());
        panel1.setLayout(new FlowLayout());
        panel2.setLayout(null);
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel1,BorderLayout.NORTH);panel.add(panel2,BorderLayout.CENTER);panel.add(panel3,BorderLayout.SOUTH);
        frame.add(panel);

        frame.setTitle("실전문제 8번");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        {
            panel1.add(new JButton("열기"));
            panel1.add(new JButton("닫기"));
            panel1.add(new JButton("나가기"));
            panel.setBackground(Color.gray);
        }
        {
            for (int i = 0; i<10; i++) {
                JLabel label = new JLabel("*");
                label.setOpaque(true);
                label.setBackground(Color.RED);
                label.setSize(10,10);
                label.setLocation((int)(Math.random()*150)+50,(int)(Math.random()*150)+50);
                panel2.add(label);
                panel2.setBackground(Color.gray);
            }
        }
        {
            panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
            JButton button = new JButton("Word Input");
            JTextField textField = new JTextField(15);
            panel3.add(button); panel3.add(textField);
        }
        frame.setVisible(true);
        frame.setSize(300,300);
    }
}
public class Chapter9_EX {
    public static void main(String[] args) {
//        new Ex2();
//        new Ex3();
//        new Ex4();
//        new Ex5();
//        new Ex6();
//        new Ex7();
        new Ex8();
    }
}


