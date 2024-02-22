package com.runtime.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class LsCommand {
    public static void main(String[] args)
    {
        try {
            ProcessBuilder pb = new ProcessBuilder("pwd");
//            File file = new File("/home/local/ZOHOCORP/mujamil-con1091/IdeaProjects/MyProjects/src/com/runtime/practice/LsCommand.java");
//            pb.directory(new File("/home/local/ZOHOCORP/mujamil-con1091/Documents"));
            Process p = pb.start();
            String text;
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((text = reader.readLine()) != null) {
                System.out.println(text);
            }
            int exitCode = p.waitFor();
            if(exitCode != 0) {
                System.out.println("Exited with "+exitCode);
            }
        }
        catch(Exception ee){
            ee.printStackTrace();
        }

    }
}
