package com.ssp.corejava.multithreading.lifecycle;

public class YieldDemo {
	public static void main(String[] args) {
		Thread thread1 = new Worker1();
		thread1.start();
		
		for (int i = 0; i < 100; i++) {
			System.out.println("Main");
			Thread.yield();
		}
	}

	private static class Worker1 extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println("Thread1");
			}
		}
	}
}
