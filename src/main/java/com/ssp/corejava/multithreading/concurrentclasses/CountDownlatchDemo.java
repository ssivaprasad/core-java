package com.ssp.corejava.multithreading.concurrentclasses;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CountDownlatchDemo {
	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, ()-> System.out.println("Main Task Completed"));

		System.out.println("Main Thread Running");
		
		new Task(cyclicBarrier);
		new Task(cyclicBarrier);
		new Task(cyclicBarrier);
		
		System.out.println("Main Thread Completed");
	}

	private static class Task extends Thread {
		private CyclicBarrier cyclicBarrier;

		public Task(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
			start();
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				System.out.println("[" + Thread.currentThread().getName() + "] Task Processing Complted");
				cyclicBarrier.await();
				System.out.println("[" + Thread.currentThread().getName() + "] Another Task Processing Complted");
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}

	}
}
