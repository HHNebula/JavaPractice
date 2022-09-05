package exception.practice;

public class TestException {

	public static void main(String[] args) {

		try {
			methodA();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// throws가 작성된 메서드에서 발생된 예외는 호출된 스택에서 try-catch 문을 이용해 처리한다.
	public static void methodA() throws Exception { 
		methodB();
	}

	// throws ExceptionName = 메서드 호출 시 오류가 발생할 가능성이 크다는 것을 알려줌
	// 예외처리를 해줘야함을 명시함
	public static void methodB() throws Exception {
		throw new Exception("메소드B 예외발생"); // 예외를 발생시킴
	}

}
