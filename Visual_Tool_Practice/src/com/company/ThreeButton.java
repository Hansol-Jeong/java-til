package com.company;

import javax.swing.*;
import java.awt.*;

public class
ThreeButton extends JFrame {
    public ThreeButton() {
        setTitle("3버튼 JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        //이부분 살짝 빡셋다. 우선 getContentPane()은 JFrame의 메소드이고 그걸 상속받았으니 그냥 쓸 수 있지. 그래서 getContentPane()하면 현재 프레임에
        //붙어있는 컨텐트를 알아내는 거야, 다시말해, JFrame객체가 생성될 때 컨텐트 팬이 생기고, getContetnPane()은 그 컨텐트팬을 알아내는 거고,
        //JFrame의 조상인 Container클래스로 그걸 받갰다는 거야. 그럼 그건 JFrame객체지.
        contentPane.setBackground(Color.ORANGE);
        contentPane.setLayout(new FlowLayout());//이건 배치관리자인데 좀있다 할거임.

        contentPane.add(new JButton("OK"));
        contentPane.add(new JButton("Cancel"));
        contentPane.add(new JButton("Ignore"));

        setSize(300,300);
        setVisible(true);

    }

    public static void main(String[] args) {
        new ThreeButton();
    }
}

