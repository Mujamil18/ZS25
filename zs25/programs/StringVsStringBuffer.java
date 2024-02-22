package com.zs25.programs;

public class StringVsStringBuffer {
    public static void main(String[] args) {

        long start = System.nanoTime();
        long startMemory = Runtime.getRuntime().freeMemory();
        System.out.println("Memory at initial: "+startMemory);
//        testStringBuffer();
        testString();
        long end = System.nanoTime();
        long endMemory = Runtime.getRuntime().freeMemory();

        System.out.println("Time taken : "+ (end-start));
        System.out.println("Memory taken: "+ (startMemory - endMemory));
    }
    public static void  testStringBuffer(){
        StringBuffer sb = new StringBuffer();

        for(int i=1; i<1000; i++){
            sb = sb.append(i).append(":");
        }
        System.out.println(sb);
    }
    public static void testString(){
        String s = "";
        for(int i=1; i<1000; i++){
            s = s.concat(i+":");
        }
        System.out.println(s);
    }
}
