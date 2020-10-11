package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseMotionEx {
    private JLabel label = new JLabel("No Motion Event");
    public MouseMotionEx() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("어어어 하기싫다 ㅋ");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        frame.add(panel);
        panel.add(label);

        panel.addMouseListener(new MyMouseListener());//내부에서 알아서 업캐스팅해서 쓰겠지.
        panel.addMouseMotionListener(new MyMouseListener());

        frame.setSize(300,300);
        frame.setVisible(true);
    }
    class MyMouseListener implements MouseListener, MouseMotionListener {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            label.setText(e.getX()+", "+e.getY());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            label.setText(e.getX()+", "+e.getY());
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            Container c= (Container)e.getSource();
            c.setBackground(Color.CYAN);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            Container c= (Container)e.getSource();
            c.setBackground(Color.YELLOW);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            label.setText(e.getX()+", "+e.getY());
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            label.setText(e.getX()+", "+e.getY());
        }
    }

    public static void main(String[] args) {
        new MouseMotionEx();
    }
}
