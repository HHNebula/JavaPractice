package test.udp;

import java.io.*;
import java.net.*;

public class UDPEchoClient {

	public void clientUDP(String ip) {
		
		// 주소 설정 - localhost
		InetAddress inetaddr = null;
		
		try {
			inetaddr = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
		
		DatagramSocket dSock = null;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			dSock = new DatagramSocket();
			String str = null;
			
			do {
				
				// 데이터그램 송신
				System.out.print("\tInsert Msg > ");
				str = br.readLine();
				DatagramPacket send = new DatagramPacket(str.getBytes(), str.getBytes().length, inetaddr, 9007);
				dSock.send(send);
				if (str.equals("exit"))
					break;
				
				// 데이터그램 수신
				byte[] buffer = new byte[str.getBytes().length];
				DatagramPacket receive = new DatagramPacket(buffer, buffer.length);
				dSock.receive(receive);
				String echo = new String(receive.getData(), 0, receive.getData().length);
				System.out.println("\tSERVER> " + echo);
				
			} while (str != null);
			System.out.println("UDPEchoClient를 종료합니다.");
			
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			dSock.close();
		}
	}
	
}
