package network.tcp;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {

	public static void main(String[] args) throws IOException {

		int port = 8500;
		ServerSocket server = new ServerSocket(port);

		while (true) {

			// 클라이언트의 요청 대기
			Socket client = server.accept();

			// 클라이언트로의 입출력 스트림 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter pw = new PrintWriter(client.getOutputStream());

			while (true) {
				String message = br.readLine();

				if (!message.equals("exit")) {
					System.out.println(client.getInetAddress().getHostAddress() + "가 보낸 메세지 : " + message);

					pw.println("메세지 받기 성공");
					pw.flush();
				} else {
					System.out.println("접속 종료");
					break;
				}
			}

			if (br != null)
				br.close();
			if (pw != null)
				pw.close();
			if (client != null)
				client.close();

		}

	}

}
