package sample;

import java.awt.GridLayout;

import javax.swing.*;

public class GUIEx extends JFrame {

	public GUIEx() {
		setTitle("컨테이너 & 컴포넌트");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 2, 20, 20));

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		panel1.setLayout(new GridLayout(3, 1));
		panel1.add(new JLabel("JLabel - Panel 1"));
		panel1.add(new JTextField("TextField"));
		panel1.add(new JButton("Ok"));
		panel1.setSize(200, 300);

		panel2.setLayout(new GridLayout(5, 1));
		panel2.add(new JLabel("JLabel - Panel 2"));
		panel2.add(new JRadioButton("JRadioButton"));
		panel2.add(new JRadioButton("JRadioButton"));
		panel2.add(new JCheckBox("JCheckBox"));
		panel2.add(new JCheckBox("JCheckBox"));
		panel2.setSize(200, 300);

		add(panel1);
		add(panel2);

		setVisible(true);

	}

	public static void main(String[] args) {
		new GUIEx();
	}

}
