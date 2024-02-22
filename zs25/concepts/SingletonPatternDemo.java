package com.zs25.concepts;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        SingletonPattern obj = SingletonPattern.getInstance();
        System.out.println(obj.toString());
        for(int i=1; i<100; i++) {
            Thread t = new Thread(obj, ""+i);
            System.out.println(t);
        }
    }
}
