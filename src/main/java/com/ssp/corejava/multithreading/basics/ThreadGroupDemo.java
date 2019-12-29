package com.ssp.corejava.multithreading.basics;

public class ThreadGroupDemo {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
		
		ThreadGroup g = new ThreadGroup("Group");
		ThreadGroup sg = new ThreadGroup(g,"SubGroup");
		System.out.println(g.getParent().getName());
		System.out.println(sg.getParent().getName());
	}
}
