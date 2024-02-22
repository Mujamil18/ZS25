package com.daily.questions;

public class ThreadExample extends Thread{
    String msg;
    ThreadExample(String msg){
        this.msg = msg;
        System.out.println("Hi");
    }
    public void run(){
        System.out.println(msg);
    }

    public static void main(String[] args) {
        ThreadExample obj1 =  new ThreadExample("Welcome");
        ThreadExample obj2 = new ThreadExample("hello");
    }
}
