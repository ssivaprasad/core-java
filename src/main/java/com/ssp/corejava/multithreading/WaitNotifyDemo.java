package com.ssp.corejava.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class WaitNotifyDemo {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		producer.start();
		consumer.start();
	}

	private static class Producer extends Thread {
		private Queue<Integer> queue;

		public Producer(Queue<Integer> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					try {
						while (queue.size() <= 3) {
							Integer value = (int) ((Math.random()) * 100);
							System.out.println("[Producer] produced: " + value);
							queue.offer(value);
							sleep(2000);
							queue.notify();
						}
						System.out.println("Queue is Full, Waiting for Consumer to Consume");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private static class Consumer extends Thread {
		private Queue<Integer> queue;

		public Consumer(Queue<Integer> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					try {
						while (!queue.isEmpty()) {
							int value = queue.poll();
							System.out.println("[Consumer] consumed: " + value);
							sleep(2000);
							queue.notify();
						}
						System.out.println("Queue is Empty, Waiting for Producer to produce");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
