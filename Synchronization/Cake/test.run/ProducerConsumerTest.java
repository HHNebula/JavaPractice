package test.run;

import test.synch.*;
import test.common.Buffer;

public class ProducerConsumerTest {
	
	public static void main(String[] args) {
		
		// 공유 자원
		Buffer buffer = new Buffer();
		(new Thread(new Producer(buffer))).start();
		(new Thread(new Consumer(buffer))).start();

	}
	
}
