package com.ssp.corejava.multithreading;

public class CounterDemo_Sequential {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();

		for (int i = 0; i < 1000; i++) {
			counter.increment();
		}

		for (int i = 0; i < 1000; i++) {
			counter.decrement();
		}

		System.out.println(counter.value());
	}

	private static class Counter {
		private int count = 0;

		public void increment() {
			count++;
		}

		public void decrement() {
			count--;
		}

		public int value() {
			return count;
		}
	}
}
