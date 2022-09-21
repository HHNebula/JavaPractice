package sample;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestFlowLayout extends JFrame {

	public TestFlowLayout() {
		setTitle("FlowLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.RIGHT)); // 우측 부터 채움
		c.setLayout(new FlowLayout(FlowLayout.LEFT)); // 좌측 부타 체음
		c.setLayout(new FlowLayout(FlowLayout.CENTER)); // 가운데 정력

		for (int i = 0; i < 5; i++) {
			add(new JButton("Button"));
		}

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestFlowLayout();
	}

}
