package test.main;

import test.udp.UDPEchoClient;

public class UDPClientMain {

	public static void main(String[] args) {
		new UDPEchoClient().clientUDP("localhost");
	}

}
