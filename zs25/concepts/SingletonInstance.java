package com.zs25.concepts;

public class SingletonInstance {
    private static SingletonInstance obj;
    private String msg = "hello";
    private SingletonInstance(){

    }
    public static SingletonInstance getInstance(){
        if(obj == null){
            obj = new SingletonInstance();
        }
        return obj;
    }
    public String getMsg(){
        return msg;
    }
}
