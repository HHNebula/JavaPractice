package test.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPEchoClient {

	public void clientTCP(String ip, int port) {
		Socket sock = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		PrintWriter wr = null;
		BufferedReader stdin = null;

		try {
			// 서버로 접속
			sock = new Socket(ip, port);
			System.out.println("!! 접속 성공 !!");

			// 서버와 통신을 위한 stream, 표준입력 변수
			in = sock.getInputStream();
			out = sock.getOutputStream();
			br = new BufferedReader(new InputStreamReader(in));
			wr = new PrintWriter(new OutputStreamWriter(out));
			stdin = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			String echo = null;

			// 서버와 통신
			do {
				System.out.print("\tInsert Msg > ");
				msg = stdin.readLine();

				// "exit" 입력으로 접속 끊기
				if (msg.equals("exit")) {
					sock.close();
					break;
				}

				// 에코 메세지 출력
				wr.println(msg);
				wr.flush();
				echo = br.readLine();
				System.out.println("\tSERVER > " + echo);

			} while (msg != null);
		} catch (IOException ie) {
			System.out.println(ie);
		} finally {
			try {
				sock.close();
				in.close();
				out.close();
				br.close();
				wr.close();
				stdin.close();
			} catch (IOException ie) {
				System.out.println(ie);
			}
		}
	}

}
