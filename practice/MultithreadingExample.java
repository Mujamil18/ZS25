//package com.thread.practice;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//class SharedBuffer {
//    private Queue<Integer> buffer = new LinkedList<>();
//    private final int capacity;
//
//    public SharedBuffer(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public synchronized void produce(int data) throws InterruptedException {
//        while (buffer.size() == capacity) {
//            // Buffer is full, wait for a consumer to consume
//            wait();
//        }
//        buffer.add(data);
//        System.out.println("Produced: " + data);
//        notifyAll(); // Notify consumers that data is available
//    }
//
//    public synchronized int consume() throws InterruptedException {
//        while (buffer.isEmpty()) {
//            // Buffer is empty, wait for a producer to produce
//            wait();
//        }
//        int data = buffer.poll();
//        System.out.println("Consumed: " + data);
//        notifyAll(); // Notify producers that space is available
//        return data;
//    }
//}
//
//class Producer implements Runnable {
//    private SharedBuffer buffer;
//
//    public Producer(SharedBuffer buffer) {
//        this.buffer = buffer;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 1; i <= 10; i++) {
//            try {
//                buffer.produce(i);
//                Thread.sleep(100); // Simulate some time taken for production
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//    }
//}
//
//class Consumer implements Runnable {
//    private SharedBuffer buffer;
//
//    public Consumer(SharedBuffer buffer) {
//        this.buffer = buffer;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 1; i <= 10; i++) {
//            try {
//                buffer.consume();
//                Thread.sleep(200); // Simulate some time taken for consumption
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//    }
//}
//
//public class MultithreadingExample {
//    public static void main(String[] args) {
//        SharedBuffer buffer = new SharedBuffer(5);
//
//        // Using an ExecutorService for managing threads
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//        // Creating producer and consumer runnables
//        Producer producer = new Producer(buffer);
//        Consumer consumer = new Consumer(buffer);
//
//        // Submitting tasks to the executor
//        executorService.submit(producer);
//        executorService.submit(consumer);
//
//        // Shutting down the executor after tasks are completed
//        executorService.shutdown();
//
//        try {
//            // Waiting for all tasks to finish or until a timeout occurs
//            executorService.awaitTermination(10, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Processing completed!");
//    }
//}
