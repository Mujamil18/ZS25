package com.thread.practice;

public class MultipleThreadDemo {
    public static void main(String[] args) {
        DemoThread dt1 = new DemoThread("Thread 1");
        DemoThread dt2 = new DemoThread("Thread 2");
        DemoThread dt3 = new DemoThread("Thread 3");

        dt1.t.start();
        dt2.t.start();
        dt3.t.start();

        try{
            Thread.sleep(10000);
        }
        catch(InterruptedException ie){
            System.out.println("Main Thread Interrupted");
            ie.printStackTrace();
        }
        System.out.println("Main Thread Exited");


    }
}
class DemoThread implements Runnable{
    Thread t;
    String name;
    DemoThread(String threadName){
        name = threadName;
        t = new Thread(this, "Child Thread");
        System.out.println(t);
    }
    public void run(){
        try{
            for(int i=1; i<1000; i++){
                System.out.println(name + " "+ i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
            System.out.println(name + " interrupted");
        }
    }
}
