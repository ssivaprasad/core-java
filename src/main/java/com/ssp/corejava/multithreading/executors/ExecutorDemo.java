package com.ssp.corejava.multithreading.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
	public static void main(String[] args) {
		//ExecutorService service = Executors.newFixedThreadPool(5);
		//ExecutorService service = Executors.newCachedThreadPool();
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		List<Task> tasks = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			tasks.add(new Task());
		}

		tasks.forEach(task -> service.submit(task));

		service.shutdown();
	}

	private static class Task implements Runnable {
		@Override
		public void run() {
			System.out.println("[" + Thread.currentThread().getName() + "], Running Task");
		}
	}
}
