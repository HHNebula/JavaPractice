package gui.practice;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutEx extends JFrame {

    public FlowLayoutEx() {
        setTitle("Flow Layout Ex"); // 타이틀 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 종료

        Container c = getContentPane(); // 컨텐트 팬을 가져옴
        c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40)); // FlowLayout 배치관리자 설정

        c.add(new Button("add"));
        c.add(new Button("sub"));
        c.add(new Button("mul"));
        c.add(new Button("div"));
        c.add(new Button("Calculate"));

        setSize(300, 200);
        setVisible(true);

    }

    public static void main(String[] args) {

        new FlowLayoutEx();

    }

}
