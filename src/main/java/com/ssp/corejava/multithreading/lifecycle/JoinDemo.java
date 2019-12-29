package com.ssp.corejava.multithreading.lifecycle;

public class JoinDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("== >> [" + Thread.currentThread().getName() + "] , I am doing my work ....");
		Thread t1 = SleepDemo.sleep("Thread1", 1000);
		t1.start();
		t1.join();
		System.out.println("== >> [" + Thread.currentThread().getName() + "] , Thread Completed");

	}
}
