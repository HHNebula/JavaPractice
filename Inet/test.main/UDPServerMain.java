package test.main;

import test.udp.UDPEchoServer;

public class UDPServerMain {
	
	public static void main(String[] args) {
		new UDPEchoServer().serverUDP(9007);
	}

}
