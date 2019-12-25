package com.ssp.corejava.multithreading;

public class ThreadPriorities {
	public static void main(String[] args) {
		System.out.println("Default Main Thread Priority: "+Thread.currentThread().getPriority());

		Thread thread1 = new Thread(() -> {});
		System.out.println("Thread1 Priority: "+thread1.getPriority());

		System.out.println();

		Thread.currentThread().setPriority(7);
		System.out.println("Main Thread Priority:  "+Thread.currentThread().getPriority());
		
		System.out.println();
		
		Thread thread2 = new Thread(() -> {});
		System.out.println("Thread2 Priority: "+thread2.getPriority());
		thread2.setPriority(4);
		System.out.println("Thread2 Priority: "+thread2.getPriority());
	}
}
