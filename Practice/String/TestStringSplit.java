package String.practice;

public class TestStringSplit {

	public static void main(String[] args) {

		String str = "a b cde f g"; // 공백이 포함된 문자열 생성

		String[] split = str.split(" "); // 공백을 기준으로 문자열을 나눠 배열로 생성

		for (String item : split) { // split 배열의 요소들을 item에 저장
			System.out.println(item); // item 출력
		}

	}

}
