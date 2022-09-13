package gui.test;

import javax.swing.*;
import java.awt.*;

public class GridLayoutSample extends JFrame {

    public GridLayoutSample() {

        setTitle("학생 정보 입력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout grid = new GridLayout(5, 2); // 4x2 그리드 레이아웃 배치 관리자 생성
        grid.setVgap(10); // 수직 간격 10px 부여

        Container c = getContentPane(); // 컨텐트 팬을 가져옴
        c.setLayout(grid); // grid 를 배치 관리자로 지정

        c.add(new JLabel("\t이름"));
        c.add(new JTextField());
        c.add(new JLabel("\t나이"));
        c.add(new JTextField());
        c.add(new JLabel("\t과목"));
        c.add(new JTextField());
        c.add(new JLabel("\t전공"));
        c.add(new JTextField());
        c.add(new Button("OK"));
        c.add(new Button("Cancel"));

        setSize(300, 200);
        setVisible(true);

    }

    public static void main(String[] args) {

        new GridLayoutSample();

    }

}
