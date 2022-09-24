package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackground {
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ClientGUI gui;
	private String msg;
	private String nickName;

	public void setGui(ClientGUI gui) {
		this.gui = gui;
	}

	// 클라이언트 접속에 대한 메소드
	public void connect() {
		try {
			// 연결할 서버의 정보를 설정
			socket = new Socket("127.0.0.1", 7777);
			System.out.println("서버에 연결됨");
			// 서버와 주고 받을 입,출력 통로 생성
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			// 접속 후 서버에서 닉네임을 인식
			out.writeUTF(nickName);
			System.out.println("Client : 닉네임 전송완료 ");
			while (in != null) { // 입력한 문자열을 화면에 출력하는 기능
				msg = in.readUTF();
				gui.appendMsg(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String msg) {
		try {
			out.writeUTF(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setNickname(String nickName) { // 닉네임 Setter
		this.nickName = nickName;
	}
}
