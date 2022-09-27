package test.common;

public class Buffer {

	private int data;
	private boolean isEmpty = true;

	public synchronized int get() {
		while (isEmpty) {
			try {
				wait(); // notify를 기다림
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isEmpty = true;
		notifyAll(); // get() 에 notify
		return data;
	}

	public synchronized void put(int data) {
		while (!isEmpty) {
			try {
				wait(); // notify를 기다림
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isEmpty = false;
		this.data = data;
		notifyAll(); // get() 에 notify
	}

}
