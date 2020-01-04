package com.ssp.corejava.multithreading.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CollableAndFutureDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newSingleThreadExecutor();
		System.out.println("Trying to submit the task ...");
		Future<Long> result = service.submit(new Factorial(10));
		System.out.println("Submitted the task ...");
		Long value = result.get();
		System.out.println("Factorial: " + value);
		service.shutdown();
	}

	private static class Factorial implements Callable<Long> {
		private int num;

		public Factorial(int num) {
			this.num = num;
		}

		@Override
		public Long call() throws Exception {
			long result = 1;

			while (num >= 1) {
				result = result * num;
				num = num - 1;
			}
			return result;
		}
	}
}
