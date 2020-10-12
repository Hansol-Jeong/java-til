package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

class Chapter10_2 {
    public Chapter10_2() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("꾸에엥");
        Container c = frame.getContentPane();

        c.setBackground(Color.RED);
        c.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                c.setBackground(Color.YELLOW);
                c.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        c.setBackground(Color.GREEN);//이렇게하면 그냥 릴리즈 말고 드래그 했다고 뗴어질 때만 색이변해 개쩐다
                    }
                });
            }
        });
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
class Chapter10_3 {
    public Chapter10_3() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("꾸에엥");
        Container c = frame.getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER));
        StringBuffer buffer = new StringBuffer("Love Java");

        JLabel label = new JLabel(buffer.toString());
        c.add(label);
        label.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode==KeyEvent.VK_LEFT) {
                    if (label.getText().equals("Love Java")) {
                        StringBuffer buffer1 = new StringBuffer(label.getText());
                        label.setText(buffer1.reverse().toString());
                    } else if (label.getText().equals(buffer.reverse().toString())) {
                        StringBuffer buffer1 = new StringBuffer(label.getText());
                        label.setText(buffer1.reverse().toString());
                    }
                }
            }
        });
        label.setFocusable(true);
        label.requestFocus();
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
class Chapter10_4 {
    JLabel label = new JLabel();
    StringBuffer buffer = new StringBuffer("Love Java");
    StringBuffer buffer2 = new StringBuffer(buffer);
    public Chapter10_4() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("꾸에엥");
        Container c = frame.getContentPane();

        label.setText(buffer.toString());
        c.add(label);
        label.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) {
                    buffer2=new StringBuffer(buffer2.substring(1)+buffer2.substring(0,1));
                    label.setText(buffer2.toString());
                }
            }
        });

        label.setFocusable(true);
        label.requestFocus();
        frame.setSize(300,300);
        frame.setVisible(true);

    }
}
class Chapter10_5 {//가장 먼저 추가한 컴포넌트가 가장 위로온다.(가장 나중에 추가하면 뒤로간다. 배경을 마지막에?)
    StringBuffer buffer = new StringBuffer("Love Java");
    JLabel label = new JLabel(buffer.toString());
    public Chapter10_5() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("꾸에엥");
        Container c = frame.getContentPane();
        JLabel label1 = new JLabel();
        label1.setSize(10,10);
        label1.setBackground(Color.red);
        label1.setOpaque(true);
        label1.setLocation(50,50);
        c.add(label1);
        c.setLayout(null);
        frame.setSize(300,300);
        frame.setVisible(true);
        c.add(label);
        label.setFont(new Font("초기 폰트",Font.PLAIN,5));
        label.setSize(label.getText().length()*(label.getFont().getSize()),label.getFont().getSize());
        label.setLocation(50,50);
        label.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                char keyChar = e.getKeyChar();
                Font font = label.getFont();
                int size = font.getSize();
                if (Character.toString(keyChar).equals("+")) {
                    label.setFont(new Font("아몰라",Font.PLAIN,size+5));//name, sytle, size
                    label.setSize((int)(label.getText().length()*(label.getFont().getSize())/1.8),label.getFont().getSize());
                    System.out.println("+");
                    System.out.println(label.getLocationOnScreen().getX()+","+label.getLocationOnScreen().getY());
                }
                else if (Character.toString(keyChar).equals("-")) {
                    label.setFont(new Font("응몰라",Font.BOLD,size-5));
                    label.setSize((int)(label.getText().length()*(label.getFont().getSize())/1.8),label.getFont().getSize());
                    System.out.println("-");
                    System.out.println(label.getLocationOnScreen().x+","+label.getLocationOnScreen().getY());//정수,실수
                }
            }
        });
//        c.setComponentZOrder(label,2);
//        c.setComponentZOrder(label1,1);//swing에 적용안돼
        label.setOpaque(true);
        label.setBackground(Color.green);
        label.setFocusable(true);
        label.requestFocus();


    }
}
class Chapter10_6 {
    JLabel label = new JLabel("C");
    public Chapter10_6() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("꾸에엥");
        Container c = frame.getContentPane();
        c.setLayout(null);
        c.add(label);
        label.setSize(100,20);

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setLocation((int)(Math.random()*100),(int)(Math.random()*100));
            }
        });

        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
class Chapter10_7 {
    JLabel label = new JLabel("Love JavA");
    JFrame frame = new JFrame();
    Container c = frame.getContentPane();
    public Chapter10_7() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("꾸에엥");
//        c.setLayout(new FlowLayout(FlowLayout.CENTER));
        c.setLayout(null);
        label.setSize(300,300);
        c.add(label);
        label.setFont(new Font("dmd",Font.PLAIN,50));
        c.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int n = e.getWheelRotation();
                Font font = label.getFont();
                int fontSize = font.getSize();
                if(n<0) {
                    label.setFont( new Font("응",Font.PLAIN,fontSize-5));
                    System.out.println("dmd");
                }
                if(n>0) {
                    label.setFont(new Font("응",Font.PLAIN,fontSize+5));
                    System.out.println("sds");
                }
            }
        });

        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
class Chapter10_EX {
    public static void main(String[] args) {
//        new Chapter10_2();
//        new Chapter10_3();
//        new Chapter10_4();
        new Chapter10_5();
//        new Chapter10_6();
//        new Chapter10_7();
    }
}
