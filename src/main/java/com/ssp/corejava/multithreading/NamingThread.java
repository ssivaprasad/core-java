package com.ssp.corejava.multithreading;

public class NamingThread {
    public static void main(String[] args) {
        System.out.println("Default main Thread Name: "+Thread.currentThread().getName());
        Thread.currentThread().setName("My New Thread"); // Changing name of main thread
        System.out.println("Main Thread Name: "+Thread.currentThread().getName());

        System.out.println();

        Thread thread1 = new Thread(() -> {});
        System.out.println("Thread1 Name: "+ thread1.getName());
        thread1.setName("My Thread 1"); // Changing name of thread1
        System.out.println("Thread1 Name: "+ thread1.getName());

        System.out.println();
        Thread thread2 = new Thread(() -> {}, "Thread_2");
        System.out.println(thread2.getName());
    }
}
