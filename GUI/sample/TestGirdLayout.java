package sample;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGirdLayout extends JFrame {

	public TestGirdLayout() {
		setTitle("GridLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new GridLayout(3, 2)); // 3행 2열의 그리드 레이아웃 배치

		for (int i = 0; i < 6; i++) {
			add(new JButton("Button"));
		}

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestGirdLayout();
	}

}
