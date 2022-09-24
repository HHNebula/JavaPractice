package chat.server;

import java.io.IOException;

public class ServerRun {
	public static void main(String[] args) {
		// 서버를 구동하기 위한 메소드
		try {
			new ServerGUI();
		} catch (IOException e) {
			System.err.println(e.getMessage() + "\n서버 프로그램 실행 실패!!");
		}

	}
}
