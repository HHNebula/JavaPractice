package gui.practice;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame {

    public BorderLayoutEx() {
        setTitle("Border Layout Ex"); // 타이틀 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 종료

        Container c = getContentPane(); // 컨텐트 팬을 가져옴
        c.setLayout(new BorderLayout(15, 5));

        c.add(new Button("add"), BorderLayout.NORTH);
        c.add(new Button("sub"), BorderLayout.SOUTH);
        c.add(new Button("mul"), BorderLayout.WEST);
        c.add(new Button("div"), BorderLayout.EAST);
        c.add(new Button("Calculate"), BorderLayout.CENTER);

        setSize(300, 200);
        setVisible(true);

    }

    public static void main(String[] args) {

        new BorderLayoutEx();

    }

}
