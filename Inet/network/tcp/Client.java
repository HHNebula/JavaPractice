package network.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		
		int port = 8500;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			
			// 2, 4, 5, 6
			String serverIP = InetAddress.getLocalHost().getHostAddress();
			Socket socket = new Socket(serverIP, port);
			
			if (socket != null) {
				
				// 8
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream());
				Scanner sc = new Scanner(System.in);
				do {
					System.out.print("대화 입력 : ");
					String message = sc.nextLine();
					pw.println(message);
					pw.flush();
					if (message.equals("exit")) {
						break;
					}
					String recieveMessage = br.readLine();
					System.out.println(recieveMessage);
				} while (true);
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
