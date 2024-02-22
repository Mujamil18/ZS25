package com.zs25.concepts;

public class Singleton {
    private String message;
    private static Singleton singletonInstance;
    private Singleton(){
        message = "hello";
    }
    public static Singleton getInstance(){
        if(singletonInstance == null){
            singletonInstance = new Singleton();
        }
        return singletonInstance;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
