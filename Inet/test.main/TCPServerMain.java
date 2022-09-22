package test.main;

import test.tcp.TCPEchoServer;

public class TCPServerMain {
	
	public static void main(String[] args) {
		// TCPEchoClient 프로그램을 구동하며 서비스 포트번호를 9007로 정함
		new TCPEchoServer().tcpServer(9007);
	}

}
