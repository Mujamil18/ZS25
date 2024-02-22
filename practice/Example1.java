package com.thread.practice;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Producer producer = new Producer(buffer);
        Thread producerThread = new Thread(producer);
        producerThread.setName("Producer");

        Consumer consumer = new Consumer(buffer);
        Thread consumerThread = new Thread(consumer);
        consumerThread.setName("Consumer");

        producerThread.start();
        consumerThread.start();


    }
}
class Producer implements Runnable{
    private SharedBuffer buffer;
    private int data;

    Producer(SharedBuffer buffer){
        this.buffer = buffer;
        this.data = getData();
    }
    public int getData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Data to be produced: ");
        int data = sc.nextInt();
        return data;
    }
    public void run(){
        try {
            for (int i = 1; i <= this.data; i++) {
                buffer.produce(i);
                Thread.sleep(500);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
class Consumer implements Runnable{
    private SharedBuffer buffer;

    Consumer(SharedBuffer buffer){
        this.buffer = buffer;
    }
    public void run(){
        int data;
        int size = buffer.getCapacity();
        try {
            for(int i=0; i< size; i++)
            data = buffer.consume();
            Thread.sleep(500);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
class SharedBuffer{
    private Queue<Integer> list;
    private final int capacity;
    SharedBuffer(){
        list = new LinkedList<>();
        capacity = 5;
    }
    public int getCapacity(){
        return capacity;
    }
    public synchronized void produce(int data) throws InterruptedException{
        System.out.println("List size: "+ list.size());
        while(list.size() == capacity){
            wait();
        }
        list.add(data);
        System.out.println(Thread.currentThread().getName() + " produced " + data);
        notifyAll();
    }
    public synchronized int consume() throws InterruptedException{
        while(list.isEmpty() && list.size() < capacity){
            wait();
        }
        int data = list.poll();
        System.out.println(Thread.currentThread().getName() + " consumed " + data);
        notifyAll();
        return data;
    }

}
