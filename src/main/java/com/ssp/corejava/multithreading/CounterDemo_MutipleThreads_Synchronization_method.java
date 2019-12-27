package com.ssp.corejava.multithreading;

public class CounterDemo_MutipleThreads_Synchronization_method {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();

		Thread increment = new IncrementThread(counter);
		Thread decrement = new DecrementThread(counter);

		increment.start();
		decrement.start();

		increment.join();
		decrement.join();

		System.out.println(counter.value());

	}

	private static class IncrementThread extends Thread {
		private Counter counter;

		public IncrementThread(Counter counter) {
			this.counter = counter;
		}

		public void run() {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
			}
		}
	}

	private static class DecrementThread extends Thread {
		private Counter counter;

		public DecrementThread(Counter counter) {
			this.counter = counter;
		}

		public void run() {
			for (int i = 0; i < 1000; i++) {
				counter.decrement();
			}
		}
	}

	private static class Counter {
		private int count = 0;

		public synchronized void increment() {
			count++;
		}

		public synchronized void decrement() {
			count--;
		}

		public int value() {
			return count;
		}
	}
}
