package com.runtime.practice;

import java.io.IOException;

public class RuntimeTest {
    public static void main(String[] args) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());
        Process process = runtime.exec("ls");
        process.waitFor();
    }
}
