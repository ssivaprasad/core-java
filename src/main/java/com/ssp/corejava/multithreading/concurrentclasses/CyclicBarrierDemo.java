package com.ssp.corejava.multithreading.concurrentclasses;

import java.util.concurrent.CountDownLatch;

public class CyclicBarrierDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);

		new Task(latch);
		new Task(latch);
		new Task(latch);

		System.out.println("Main Thread Running");
		latch.await();
		System.out.println("Main Thread Completed");
	}

	private static class Task extends Thread {
		private CountDownLatch latch;

		public Task(CountDownLatch latch) {
			this.latch = latch;
			start();
		}

		@Override
		public void run() {
			putThreadInSleep(1000);
			System.out.println("[" + Thread.currentThread().getName() + "] File Processing Complted");
			latch.countDown();
		}

		private void putThreadInSleep(int msec) {
			try {
				Thread.sleep(msec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
