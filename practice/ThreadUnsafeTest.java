package com.thread.practice;

import java.util.ArrayList;

public class ThreadUnsafeTest {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        for(int i=97; i<(97+26); i++){
            list.add((char)i);
        }
        System.out.println(list);
        for(Character i: list){
            System.out.println(i);
            if( i == 'c'){
                list.remove(i);
            }
//            System.out.println(list);
        }
    }
}
