//package com.thread.practice;
//
//public class ThreadLifeCycle {
//    public static void main(String[] args) {
//        Runnable runnable = new DefaultRunnable("hello");
//        Thread t = new Thread(runnable, "mujithread");
//        t.start();
//
//    }
//}
//class DefaultRunnable implements Runnable{
//    private String externalString;
//    DefaultRunnable(String externalString){
//        this.externalString = externalString;
//    }
//    public void run(){
//        System.out.println("I am a Thread. My name is "+ Thread.currentThread().getName());
//    }
//}
