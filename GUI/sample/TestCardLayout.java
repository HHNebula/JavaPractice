package sample;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestCardLayout extends JFrame {

	public TestCardLayout() {
		setTitle("CardLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		CardLayout card = new CardLayout();
		c.setLayout(card);

		// 3개의 카드 생성
		JPanel card1 = new JPanel();
		JPanel card2 = new JPanel();
		JPanel card3 = new JPanel();

		// 카드에 색상 지정
		card1.setBackground(Color.RED);
		card2.setBackground(Color.ORANGE);
		card3.setBackground(Color.GREEN);

		// 카드에 라벨 추가
		card1.add(new JLabel("Card 1"));
		card2.add(new JLabel("Card 2"));
		card3.add(new JLabel("Card 3"));

		// 카드에 이벤트 추가
		card1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) // 마우스 왼쪽 버튼
					card.next(card1.getParent());
				if (e.getButton() == 3) // 마우스 우측 버튼
					card.previous(card1.getParent());
			}
		});

		card2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) // 마우스 왼쪽 버튼
					card.next(card2.getParent());
				if (e.getButton() == 3) // 마우스 우측 버튼
					card.previous(card2.getParent());
			}
		});

		card3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) // 마우스 왼쪽 버튼
					card.next(card3.getParent());
				if (e.getButton() == 3) // 마우스 우측 버튼
					card.previous(card3.getParent());
			}
		});
		
		// 프레임에 카드 추가
		add(card1);
		add(card2);
		add(card3);

		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestCardLayout();
	}
	
}
