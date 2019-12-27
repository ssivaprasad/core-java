package com.ssp.corejava.multithreading;

public class CreatingThread {

	public static void main(String[] args) {
		Thread thread1 = new Worker1();
		Thread thread2 = new Thread(new Worker2());
		Thread thread3 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Worker3");
			}
		});
		
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

	private static class Worker1 extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println("Worker1");
			}
		}
	}

	private static class Worker2 implements Runnable {
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println("Worker2");
			}
		}
	}

}
