package com.thread.practice;

public class ThreadDemo {
    public static void main(String[] args) {
//        NewThread nt = new NewThread();
//        nt.t.start();
        MyThread mt = new MyThread();
        mt.start();
        Thread t = Thread.currentThread();
        try{
            for(int i=1; i<=5; i++){
                System.out.println(t.getName() + " "+i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
//Implementing Runnable interface
class NewThread implements Runnable{
    Thread t;
    NewThread(){
        t = new Thread(this, "Demo Thread");
        System.out.println("New Thread : "+ t);
    }
    public void run(){
        try{
            for(int i=1; i<=5; i++){
                System.out.println(t.getName() + " "+ i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
//extending Thread class
class MyThread extends Thread{

    MyThread(){
        super("Demo Thread");
        System.out.println(this);
    }
    public void run(){
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(this+" "+i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
