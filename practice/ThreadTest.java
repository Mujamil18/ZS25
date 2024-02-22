package com.thread.practice;

import javax.swing.plaf.InternalFrameUI;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        MyThread2 thread2 = new MyThread2();
        Thread t= Thread.currentThread();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(t.getName() + ": " + i);
                Thread.sleep(300);
            }
            System.out.println("main thread exitted");
        }
        catch(InterruptedException ioe){
            System.out.println("Main thread stopped");
        }
        thread1.t.start();
        thread2.t.start();



//        Thread t = new Thread(new RunnableImpl(), "mythread");
//        t.start();
//        t = new Thread(new Test(), "testThread");
//        t.start();



//        Thread t = Thread.currentThread();
//        System.out.println("Current thread: "+ t);
//        t.setName("Muji's Thread");
//        System.out.println("After name changed: "+ t);
//        try {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(i);
//                Thread.sleep(1000);
//            }
//        }
//        catch(InterruptedException ioe){
//            System.out.println("Main thread interrupted");
//        }
    }
}
class MyThread1 implements Runnable{
    Thread t;
    MyThread1(){
        t = new Thread(this, "thread1");
    }
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("Thread 1 : "+i);
        }
        System.out.println("Thread 1 exitted");
    }
}
class MyThread2 implements Runnable{
    Thread t;
    MyThread2(){
        t = new Thread(this, "thread2");
    }
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("Thread 2 : " +i);
        }
        System.out.println("Thread 2 exitted");
    }
}

