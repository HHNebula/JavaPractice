package multichat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class MultiChatServer {

	private HashMap<String, DataOutputStream> clients;

	public MultiChatServer() {
		clients = new HashMap<String, DataOutputStream>();
		Collections.synchronizedMap(clients); // 동기화
	}

	// ============================== 내부 클래스 ============================== //

	class ServerReceiver extends Thread {

		private Socket socket;
		private DataInputStream in;
		private DataOutputStream out;

		// 생성자 = new
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				this.in = new DataInputStream(socket.getInputStream());
				this.out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			String name = null;
			try {
				name = in.readUTF();
				sendToAll("#" + name + "님이 들어오셨습니다.");
				clients.put(name, out);
				System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");

				while (in != null) {
					sendToAll(in.readUTF());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				sendToAll("#" + name + "님이 나가셨습니다.");
				clients.remove(name);
				System.out.println("현재 접속자 수는 " + clients.size() + "입니다.");
			}
		}
	}

	// ============================== 내부 클래스 끝 ============================== //

	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("서버가 시작 되었습니다.");
			while (true) {
				socket = serverSocket.accept();
				System.out.println("새로운 유저가 로그인 하였습니다.");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendToAll(String msg) {
		for (String key : (Set<String>) clients.keySet()) {
			try {
				DataOutputStream out = (DataOutputStream) clients.get(key);
				out.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
