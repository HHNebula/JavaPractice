package chat.client;

import javax.swing.JOptionPane;

public class ClientRun {
	public static void main(String[] args) {
		// 사용자 GUI를 구동하기 위한 메소드
		String nickName = JOptionPane.showInputDialog("닉네임을 입력하세요.");
		new ClientGUI(nickName);
	}
}
