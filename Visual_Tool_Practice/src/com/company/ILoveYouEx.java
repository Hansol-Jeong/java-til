package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ILoveYouEx {
    JLabel label = new JLabel("I Love You");
    public ILoveYouEx() {
        JFrame frame = new JFrame();
        Container c = frame.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(label, BorderLayout.NORTH);
        label.setOpaque(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ㅇ우어어");
        label.setBackground(Color.green);
        label.setFocusable(true);
        label.requestFocus();

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //익명 내부클래스로 쓰면 로컬변수까지 다 쓸수있고 내부클래스로 쓰면 인스턴트변수까지 쓸 수 있고 독립클래스로 쓴다면 필요파라미터 받아와서 써야지
                label.setText("사랑해");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("I Love You");
            }
        });
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ILoveYouEx();
    }
}
