package com.zs25.concepts;

public class SingletonPattern extends Thread{
    private static SingletonPattern obj = null;
    private SingletonPattern(){

    }
    public static SingletonPattern getInstance(){
        if(obj == null) {
            obj = new SingletonPattern();
        }
        else{
            System.out.println("test: "+ obj.toString());
        }
        return obj;
//        return new SingletonPattern();
    }
}

