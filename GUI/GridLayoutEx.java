package gui.practice;

import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame {

    public GridLayoutEx() {
        setTitle("Grid Layout Ex");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new GridLayout(4, 3, 5, 5));

        for (int i = 1; i < 10; i++) {
            c.add(new Button(i + ""));
        }

        c.add(new Button("*"));
        c.add(new Button("0"));
        c.add(new Button("#"));

        setSize(300, 400);
        setVisible(true);

    }

    public static void main(String[] args) {

        new GridLayoutEx();

    }

}
