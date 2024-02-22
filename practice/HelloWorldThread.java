package com.thread.practice;

import java.io.LineNumberReader;

public class HelloWorldThread {
    public static void main(String[] args) {
        NumberThread numberThread = new NumberThread();
        Thread nt = new Thread(numberThread);
        nt.start();
        System.out.println(nt.isAlive());

        StringThread strThread = new StringThread("Hello World!", numberThread.n);
        Thread st = new Thread(strThread);
        st.start();
        System.out.println(st.isAlive());

    }
}
class NumberThread implements Runnable{
    int n = 10;
    NumberThread(){
        this.n = 5 ;
    }
    NumberThread(int n){
        this.n = n;
    }
    public void run(){
        for(int i=0; i<n; i++){
            System.out.println(i);
        }
    }
}
class StringThread extends Thread{
    String str;
    int n = 10;
    StringThread(String str){
        this.str = str;
    }
    StringThread(String str, int n){
        this.str = str;
        this.n = n;
    }
    public void run(){
        for(int i=0; i<n; i++) {
            System.out.println(str);
        }
    }
}
