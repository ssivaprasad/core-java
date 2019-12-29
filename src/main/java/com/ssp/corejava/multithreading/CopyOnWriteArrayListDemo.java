package com.ssp.corejava.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		//List<String> list = new CopyOnWriteArrayList<>();

		list.add("Siva");
		list.add("Prasad");

		for (String name : list) {
			System.out.println("Name: " + name);
			if ("Siva".equals(name)) {
				list.add("Somarouthu");
			}
			System.out.println(list);
		}
	}
}
