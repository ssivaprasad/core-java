package com.ssp.corejava.multithreading.synchronization;

public class CounterDemo_ThreadLocal {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();

		Thread increment = new IncrementThread(counter);
		Thread decrement = new DecrementThread(counter);

		increment.start();
		decrement.start();

		System.out.println(counter.value());
	}

	private static class IncrementThread extends Thread {
		private Counter counter;

		public IncrementThread(Counter counter) {
			this.counter = counter;
		}

		public void run() {
			counter.increment();
			System.out.println("After Incrementing: "+counter.value());
		}
	}

	private static class DecrementThread extends Thread {
		private Counter counter;

		public DecrementThread(Counter counter) {
			this.counter = counter;
		}

		public void run() {
			counter.decrement();
			System.out.println("After Decrementing: "+counter.value());
		}
	}

	private static class Counter {
		private int count = 0;
		private static final ThreadLocal<Integer> c = new ThreadLocal(){
			@Override
			protected Object initialValue() {
				return 0;
			}
		};
		
		public void increment() {
			for (int i = 0; i < 1000; i++) {
				//count++;
				c.set(c.get().intValue()+1);
			}
		}

		public void decrement() {
			for (int i = 0; i < 1000; i++) {
				//count--;
				c.set(c.get().intValue()-1);
			}
		}

		public int value() {
			return c.get();
		}
	}
}
