package test.synch;

import test.common.Buffer;

public class Producer implements Runnable {

	private Buffer buffer;

	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			buffer.put(i);
			System.out.println("생산자: " + i + "번 케익을 생산하였습니다.");
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
