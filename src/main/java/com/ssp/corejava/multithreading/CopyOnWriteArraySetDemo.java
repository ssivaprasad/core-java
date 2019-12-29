package com.ssp.corejava.multithreading;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {
	public static void main(String[] args) {
		Set<String> set = new CopyOnWriteArraySet<>();
		//Set<String> set = new HashSet<>();

		set.add("Siva");
		set.add("Prasad");
		set.add("Sivaprasads");
		
		for (String name : set) {
			System.out.println("Name: " + name);
			if ("Siva".equals(name)) {
				set.add("Somarouthu");
			}
			System.out.println(set);
		}
	}
}
