package com.ssp.corejava.multithreading.lifecycle;

public class InterrupingDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("== >> [" + Thread.currentThread().getName() + "] , I am doing my work ....");

        Thread t1 = SleepDemo.sleep("Thread1", 10000);
        t1.start();

        Thread.sleep(1000);
        t1.interrupt();
        System.out.println("== >> [" + Thread.currentThread().getName() + "] , Thread Completed");
    }
}
