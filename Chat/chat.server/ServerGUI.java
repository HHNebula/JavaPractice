package chat.server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 20000000L; // 컴파일 시 인식할 객체 고유 ID
	private JTextArea jta = new JTextArea(40, 25); // 채팅 창
	private JTextField jtf = new JTextField(25); // 글 입력 부분
	private ServerBackground server = new ServerBackground(); // 채팅을 담당할 백그라운드(뒷 작업 영역)선언

	public ServerGUI() throws IOException {
		setBounds(200, 100, 400, 600);
		setTitle("서버부분");
		jta.setEditable(false);
		jta.setFont(new Font("맑은고딕", Font.PLAIN, 18)); // 글자 폰트, 크기 변경
		jta.setBackground(new Color(230, 255, 230));
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		server.setGui(this);
		server.setting(); // GUI 실행 시 서버도 같이 동작 시킨다.
	}

	@Override
	public void actionPerformed(ActionEvent e) {
// 문자 입력 창에 글을 입력 시 구동할 이벤트 설정
		String msg = "운영자 : " + jtf.getText() + "\n";
		System.out.print(msg);
		server.sendMessage(msg);
		appendMsg(msg);
		jtf.setText(""); // 입력 후 내용 초기화
	}

	public void appendMsg(String msg) {
		jta.append(msg);
	}
}
