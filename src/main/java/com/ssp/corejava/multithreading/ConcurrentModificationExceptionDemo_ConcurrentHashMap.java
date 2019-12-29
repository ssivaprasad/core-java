package com.ssp.corejava.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModificationExceptionDemo_ConcurrentHashMap {
	public static void main(String[] args) {
		Map<Integer, String> map = new ConcurrentHashMap<>();

		Worker1 t1 = new Worker1(map);
		Worker2 t2 = new Worker2(map);

		t1.start();
		t2.start();
	}

	private static class Worker1 extends Thread {
		Map<Integer, String> map;

		public Worker1(Map<Integer, String> map) {
			this.map = map;
		}

		@Override
		public void run() {
			map.put(11, "Siva");
			map.put(21, "Prasad");
			map.put(31, "Somarouthu");

			for (Integer key : map.keySet()) {
				System.out.println("[Thread1], Key: " + key + ", value: " + map.get(key));
				putThreadInSleep(1000);
			}
		}
	}

	private static class Worker2 extends Thread {
		Map<Integer, String> map;

		public Worker2(Map<Integer, String> map) {
			this.map = map;
		}

		@Override
		public void run() {
			putThreadInSleep(100);
			map.put(41, "SivaprasadS");
			System.out.println("[Thread2] : " + map);
		}
	}
	
	private static void putThreadInSleep(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
