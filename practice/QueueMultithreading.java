//package com.thread.practice;
//
//import java.io.Serializable;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//public class QueueMultithreading {
//    public static void main(String[] args) {
////        SharedBuffer sb = new SharedBuffer(5);
////        System.out.println("Thread started");
////        Producer producer = new Producer(sb);
////        Thread producerThread = new Thread(producer);
////        producerThread.start();
////
////        Consumer consumer = new Consumer(sb);
////        Thread consumerThread = new Thread(consumer);
////        consumerThread.start();
////
//        User user = new User();
//        SharedBuffer buffer = new SharedBuffer(5);
//
//        // Using an ExecutorService for managing threads
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//        // Creating producer and consumer runnables
//        Producer producer = new Producer(buffer, user);
//        Consumer consumer = new Consumer(buffer, user);
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
//            executorService.awaitTermination(5, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Processing completed!");
////
//    }
//}
//class SharedBuffer{
////    private Queue<Integer> buffer = new LinkedList<>();
//    private Queue<User> buffer = new LinkedList<>();
//    private int capacity;
//
//    public SharedBuffer(int capacity){
//        this.capacity = capacity;
//    }
//    public synchronized void produce(User user) throws InterruptedException {
//        while(buffer.size() == capacity){
//            wait();
//        }
//        buffer.add(user.getInput());
//        System.out.println("Produced : "+ user);
//        notifyAll();
//    }
//    public synchronized User consume() throws InterruptedException {
//        while(buffer.isEmpty()){
//            wait();
//        }
//        User user = buffer.poll();
//        System.out.println("Consumed : "+ user);
//        notifyAll();
//
//        return user;
//    }
//}
//class Producer implements Runnable{
//    private SharedBuffer buffer;
//    private User user;
//
//    public Producer(SharedBuffer buffer, User user){
//        this.buffer = buffer;
//        this.user  = user;
//    }
//    public void run(){
//        for(int i=1; i<= 5; i++){
//            try {
//                buffer.produce(user);
//                Thread.sleep(100);
//            }
//            catch(InterruptedException ie){
//                Thread.currentThread().interrupt();
//            }
//        }
//    }
//}
//class Consumer implements Runnable{
//    private SharedBuffer buffer;
//    private User user;
//
//    public Consumer(SharedBuffer buffer, User user){
//        this.buffer = buffer;
//        this.user = user;
//    }
//    public void run(){
//        for(int i=1; i<=5; i++){
//            try{
//                buffer.consume();
//                Thread.sleep(200);
//            }
//            catch(InterruptedException ie){
//                Thread.currentThread().interrupt();
//            }
//        }
//    }
//}
//class User implements Serializable {
//    private String name;
//    private String password;
//
//    User(){}
//    User(String name, String password){
//        this.name = name;
//        this.password = password;
//    }
//    public String getName(){
//        return name;
//    }
//    public void setName(String name){
//        this.name = name;
//    }
//    public void setPassword(String password){
//        this.password = password;
//    }
//    public User getInput(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter User name: ");
//        String name = sc.nextLine();
//        System.out.println("Enter Password: ");
//        String password = sc.nextLine();
//
//        return new User(name, password);
//
//    }
//    public String toString(){
//        return "User is : "+this.name;
//    }
//}