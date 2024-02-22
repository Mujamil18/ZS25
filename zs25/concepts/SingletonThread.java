package com.zs25.concepts;

public class SingletonThread {

    public static void main(String[] args) {
        Thread t1 = new Thread(new SetterThread());
        Thread t2 = new Thread(new GetterThread());
        t1.start();
        t2.start();
    }
}
class SetterThread implements Runnable{
    public void run(){
        Singleton obj = Singleton.getInstance();
//        System.out.println(obj.toString());
        obj.setMessage("setting message from SetterThread");
        System.out.println("Message set successfully");
    }
}
class GetterThread implements Runnable{
    public void run(){
        Singleton obj = Singleton.getInstance();
//        System.out.println(obj.toString());
        String data = obj.getMessage();
        System.out.println("Receiving data from GetterThread: "+data);
    }
}

