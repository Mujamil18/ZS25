package com.zs25.concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProducerConsumerProblem {
    public static void main(String[] args){

    }
}
class SharedBuffer{
    private List<Integer> buffer;
    private final int SIZE = 5;
    private static final int EOF = -1;

    SharedBuffer(){
        buffer = new ArrayList<>();
    }
    public int getData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of items to be produced");
        int n = sc.nextInt();
        return n;
    }
    public void produce(){
        int n = getData();
        for(Integer i : buffer){
            buffer.add(i);
            System.out.println(Thread.currentThread().getName() + " added "+ i);
        }
        System.out.println(Thread.currentThread().getName() + " added " + SharedBuffer.EOF);
        buffer.add(SharedBuffer.EOF);
    }
    public void consume(){
        int n = getData();
        for(Integer i: buffer){
            if(buffer.isEmpty()) {
                buffer.remove(i);
                System.out.println();
            }
        }
    }
}
class Producer{

}
class Consumer{

}
