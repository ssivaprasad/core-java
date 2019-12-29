package com.ssp.corejava.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);
	}
}
