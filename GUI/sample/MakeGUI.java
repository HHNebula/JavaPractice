package sample;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

// JFrame 상속 클래스
public class MakeGUI extends JFrame {

	// 생성자를 통해 화면 구현
	public MakeGUI() {
		setTitle("Sample GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setBackground(Color.WHITE);

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MakeGUI();
	}

}
