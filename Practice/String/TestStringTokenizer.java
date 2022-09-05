package String.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TestStringTokenizer {

	public static void main(String[] args) throws IOException {

		// BufferReader 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// StringTokenizer st에 Buffer를 이용하여 입력
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 토큰이 남아있으면 출력 ( 별도로 기준을 입력하지 않으면 공백 기준 )
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

		br.close();

	}

}
