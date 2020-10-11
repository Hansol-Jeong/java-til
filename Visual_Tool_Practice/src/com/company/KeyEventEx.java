package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyEventEx {
    private JLabel [] keyMessage;
    public KeyEventEx() {
        JFrame frame = new JFrame();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        frame.add(panel1); frame.add(panel2);
        panel1.setBackground(Color.gray); panel2.setBackground(Color.green);
        panel1.setLayout(new FlowLayout());
        frame.setTitle("key리스너 예제");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new GridLayout(1,2));
         panel1.addKeyListener(new KeyAdapter() {
             @Override
             public void keyTyped(KeyEvent e) {
                 //super.keyTyped(e);//keyListener.keyTyped(e) 결국 아무 내용도 없지 않나?
                 System.out.println("Key Typed");
             }

             @Override
             public void keyPressed(KeyEvent e) {
                 int keyCode = e.getKeyCode();
                 char keyChar = e.getKeyChar();

                 keyMessage[0].setText(Integer.toString(keyCode));
                 keyMessage[1].setText(Character.toString(keyChar));
                 keyMessage[2].setText(KeyEvent.getKeyText(keyCode));
                 System.out.println("KeyPressed");
             }

             @Override
             public void keyReleased(KeyEvent e) {
                 System.out.println("Key Released");
             }
         });
         keyMessage =new JLabel [3];
         keyMessage[0] = new JLabel("getKeyCode()");
        keyMessage[1] = new JLabel("getChar()");
        keyMessage[2] = new JLabel("getKeyText()");

        for(int i = 0; i<keyMessage.length;i++) {
            panel1.add(keyMessage[i]);
            keyMessage[i].setOpaque(true);
            keyMessage[i].setBackground(Color.YELLOW);
        }
        panel1.setFocusable(true);
        panel1.requestFocus();
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new KeyEventEx();
    }
}
