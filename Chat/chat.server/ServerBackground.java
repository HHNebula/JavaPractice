package chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServerBackground {
	private ServerSocket serverSocket; // 서버 소켓
	private Socket socket; // 받아올 소켓 저장
	private ServerGUI gui;
	private String msg;
	private int count; // 현재 접속자 수를 세는 변수
	//사용자들의 정보를 저장하는 맵 객체 선언
	private Map<String, DataOutputStream> clientMap = new HashMap<String, DataOutputStream>();

	public void setGui(ServerGUI gui) {
		this.gui = gui;
	}

	//서버 생성 시 서버 정보 설정
	public void setting() {
		try {
			//사용자들이 동시 접속 시 맵 에 정보가 순차적으로 저장될 수 있게 동기화
			Collections.synchronizedMap(clientMap);
			//서버의 포트 번호 설정
			serverSocket = new ServerSocket(7777);
			while (true) {
				//방문자를 제한없이 받아 멀티쓰레드로 배분
				System.out.println("접속자 대기 중.....");
				socket = serverSocket.accept(); // 여기서 클라이언트 받음
				System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
				//새로운 사용자의 정보를 소켓에 담아 쓰레드로 생성한다.
				Receiver receiver = new Receiver(socket);
				receiver.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//맵에 사용자 정보를 저장하고 화면에 접속 정보를 표현하는 메소드
	public void addClient(String nick, DataOutputStream out) throws IOException {
		String message = nick + "님이 접속하셨습니다.\n";
		sendMessage(message);
		gui.appendMsg(message);
		clientMap.put(nick, out);
		System.out.println(">>> 현재 접속자 : " + (++count));
	}

	// 맵에 사용자 정보를 삭제하고 화면에 접속 정보를 표현하는 메소드
	public void removeClient(String nick) {
		String message = nick + "님이 나가셨습니다. \n";
		sendMessage(message);
		gui.appendMsg(message);
		clientMap.remove(nick);
		System.out.println(">>> 현재 접속자 : " + (--count));
	}

	//메세지 내용을 BroadCasting 방식으로 전파
	public void sendMessage(String msg) {
		Iterator<String> iterator = clientMap.keySet().iterator(); // keySet() 으로 연속처리
		String key = "";
		while (iterator.hasNext()) { // 각 사용자 정보 객체마다 하나씩 처리
			key = iterator.next();
			try {
				clientMap.get(key).writeUTF(msg);
			} catch (IOException e) {
				// e.printStackTrace();
			}
		}
	}

	// ------------------리시버---------------------------
	class Receiver extends Thread {
		
		private DataInputStream in; // 사용자가 전송한 데이터를 읽어 들이는 통로 생성
		private DataOutputStream out; // 사용자에게 데이터를 출력할 통로 생성
		private String nick;

		// 사용자 정보를 받아 Thread를 통해 소켓을 생성
		public Receiver(Socket socket) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				nick = in.readUTF();
				addClient(nick, out);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try { // 입력한 문자열을 화면에 출력하는 기능
				while (in != null) {
					msg = in.readUTF();// UTF 문자셋으로 읽어 오는 메소드
					sendMessage(msg);
					gui.appendMsg(msg);
				}
			} catch (Exception e) {
				//사용자가 접속 종료, 즉 GUI 종료 시 실행할 내용 작성
				removeClient(nick);
			}
		}
	}
}
