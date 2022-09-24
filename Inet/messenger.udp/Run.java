package messenger.udp;

import javax.swing.JOptionPane;

public class Run {
	public static void main(String[] args) {

		int myPort;
		int otherPort;

		// Port 번호 입력 - String 형태로 입력되므로 정수형으로 형변환
		while (true) {
			try {
				String myPortStr = JOptionPane.showInputDialog("당신의 포트번호를 입력하세요");
				String otherPortStr = JOptionPane.showInputDialog("상대방 포트 번호를 입력하세요");

				if (myPortStr == null || otherPortStr == null)
					return;

				myPort = Integer.parseInt(myPortStr);
				otherPort = Integer.parseInt(otherPortStr);

				if (myPort == otherPort) {
					System.out.println("상대방 포트번호와 당신의 포트번호가 같을 수 없습니다.");
					continue;
				
				}
				
				if (1023 > myPort || myPort > 65531 || 1023 > otherPort || otherPort > 65531) {
					System.out.println("1024 ~ 65530 사이 숫자만 입력해주세요.");
					continue;
				}
				
				break;
				
			} catch (NumberFormatException ne) {
				System.out.println("1024 ~ 65530 사이 숫자만 입력해주세요.");
			}
		}

		Messenger messenger = new Messenger(myPort, otherPort);
		MyFrame frame = messenger.getMyFrame();
		frame.process();
	}

}
