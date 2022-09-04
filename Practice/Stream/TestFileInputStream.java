package stream.practice;

import java.io.FileInputStream;
import java.io.IOException;

public class TestFileInputStream {

	// 읽어들이고자 하는 파일이 경로에 없을 수 있기 때문에 예외처리는 강제됨
	public static void main(String[] args) throws IOException {

		try {

			// 경로상 파일을 스트림의 입력 단에 연결하여 객체 fin 생성
			FileInputStream fin = new FileInputStream("C:\\workspace\\java\\SOO_JAVA\\src\\stream\\test.txt");

			int c; // 바이트를 담을 변수 생성

			while ((c = fin.read()) != -1) { // 파일 끝까지 한 바이트씩 c 에 저장, 더 읽을 바이트가 없다면 -1이 반환됨
				System.out.print((char) c); // 저장된 바이트코드를 문자로 변환하여 출력
			}

			fin.close(); // 스트림은 닫아줘야 함

		} catch (IOException e) {

			System.out.print("비정상 종료");
			e.printStackTrace(); // 예외 발생 스택 정보를 출력함

		}

	}

}
