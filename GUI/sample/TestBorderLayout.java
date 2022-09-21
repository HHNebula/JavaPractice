package sample;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestBorderLayout extends JFrame {

	public TestBorderLayout() {
		setTitle("BorderLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 기본 Layout 이 BorderLayout 이므로 생략 가능
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JButton east = new JButton("동");
		JButton west = new JButton("서");
		JButton south = new JButton("남");
		JButton north = new JButton("북");
		JButton center = new JButton("중앙");

		add(east, "East");
		add(BorderLayout.WEST, west);
		add(south, BorderLayout.SOUTH);
		add("North", north);
		add(center, BorderLayout.CENTER);

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestBorderLayout();
	}

}
