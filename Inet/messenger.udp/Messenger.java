package messenger.udp;

import java.net.*;

public class Messenger {
	private MyFrame f;
	private DatagramSocket socket;
	private InetAddress address = null;
	private final int myPort;
	private final int otherPort;

	public Messenger(int myPort, int otherPort) {
		this.myPort = myPort;
		this.otherPort = otherPort;
		try {
			address = InetAddress.getByName("127.0.0.1");
			socket = new DatagramSocket(myPort);
			f = new MyFrame(address, otherPort, socket);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public MyFrame getMyFrame() {
		return f;
	}
}
