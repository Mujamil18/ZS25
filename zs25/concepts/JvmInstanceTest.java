package com.zs25.concepts;

public class JvmInstanceTest {
    public static void main(String[] args) {
//        System.out.println("hello");
        Singleton obj = Singleton.getInstance();
        System.out.println(obj.getMessage());
        System.out.println(obj);
    }
}
