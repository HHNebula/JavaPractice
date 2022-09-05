package etc.practice;

public class TestSingleton { // 싱글톤 패턴 : 객체의 인스턴스가 오직 1개만 생성되는 패턴을 의미

	// static 인스턴스 선언
	public static TestSingleton instance;

	private TestSingleton() {} // 생성자는 private로 하여 접근 차단

	public static TestSingleton getInstance() { // 메서드를 통해 인스턴스 리턴
		if (instance == null) { // 인스턴스가 비어있다면
			instance = new TestSingleton(); // 비어있을 경우에만 생성
		}
		return instance; // 인스턴스 반환
	}

}

// 인스턴스마다 데이터가 필요 없는 경우 및 클래스 공간이 큰 경우 싱글톤 패턴 사용
