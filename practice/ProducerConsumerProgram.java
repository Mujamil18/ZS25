//package com.thread.practice;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class ProducerConsumerProgram {
//    public static void main(String[] args) {
//        ArrayList<Integer> arrList = new ArrayList<>();
//        Producer producer = new Producer(arrList, 10, 50);
//        Thread producerThread = new Thread(producer);
//        producerThread.start();
//
//        Consumer consumer = new Consumer(arrList);
//        Thread consumerThread = new Thread(consumer);
//        consumerThread.start();
//
//    }
//}
//class MyList {
//    private ArrayList<Integer> list;
//    int capacity;
//    int total;
//
//    MyList(ArrayList<Integer> list, int capacity, int total) {
//        this.list = list;
//        this.capacity = capacity;
//        this.total = total;
//    }
//
//    public void addData(int data) {
//        try {
//            while (list.size() == capacity) {
//                wait();
//            }
//            list.add(data);
//            notify();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//class Producer implements Runnable{
//    private ArrayList<Integer> arrList;
//    private final int capacity;
//    private final int totalNumberOfData;
//    Producer(ArrayList<Integer> arrList, int capacity, int totalNumberOfData){
//        this.arrList = arrList;
//        this.capacity = capacity;
//        this.totalNumberOfData = totalNumberOfData;
//    }
//    synchronized public void run(){
//        System.out.println("producer");
//        int value = 1;
//        try {
//            for(int i = 0; i < totalNumberOfData; i++) {
//                this.arrList.add(value);
//                System.out.println(Arrays.toString(this.arrList.toArray()));
//                if (this.arrList.size() == capacity) {
//                    wait();
//                }
//                else{
//                    value++;
//                    notify();
//                }
//
//            }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//}
//class Consumer implements Runnable{
//    private ArrayList<Integer> arrList;
//    Consumer(ArrayList<Integer> arrList){
//        this.arrList = arrList;
//    }
//   public void run(){
////       System.out.println("consumer");
////       try {
////           while(arrList)
////           }
////           else {
////               wait();
////           }
////
////       }
////       catch(Exception e){
////           e.printStackTrace();
////       }
//
//    }
//}
