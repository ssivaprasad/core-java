package com.ssp.corejava.multithreading.concurrentclasses;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class BlockingQueueDemo {
  public static void main(String[] args) {
    BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
    new Producer(blockingQueue);
    new Consumer(blockingQueue);
  }

  private static class Producer extends Thread {
    private BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> blockingQueue) {
      this.blockingQueue = blockingQueue;
      start();
    }

    @Override
    public void run() {
      IntStream.range(1, 50).forEach(value -> {
        System.out.println("Producer Produced: " + value);
        try {
          blockingQueue.put(value);
          TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
    }
  }

  private static class Consumer extends Thread {
    private BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
      this.blockingQueue = blockingQueue;
      start();
    }

    @Override
    public void run() {
      while (true) {
        try {
          int value = blockingQueue.take();
          System.out.println("Consumer Consumed: " + value);
          TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
