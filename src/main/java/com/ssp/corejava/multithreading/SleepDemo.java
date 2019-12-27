package com.ssp.corejava.multithreading;

public class SleepDemo {
	public static Thread sleep(String threadName, int msec) {
		Runnable myRunnable = () -> {
			try {
				System.out.println("== >> [" + threadName + "] , I am doing my work ....");
				Thread.sleep(msec);
				System.out.println("== >> [" + threadName + "] , I completed my work");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		return new Thread(myRunnable, threadName);
	}

	public static void main(String[] args) {
		Thread t1 = sleep("Thread 1", 1000);
		t1.start();
	}
}
