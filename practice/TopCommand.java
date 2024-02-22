package com.runtime.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TopCommand {
    public static void main(String[] args)
    {
        try {
            ProcessBuilder pb = new ProcessBuilder("top", "-l", "1");
            Process p = pb.start();
            String text;
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((text = reader.readLine()) != null) {
                System.out.println(text);
            }
            int exitCode = p.waitFor();
            if (exitCode != 0) {
                System.out.println("Exited with " + exitCode);
            }
        }
        catch(Exception ee){
            System.out.println();
            ee.printStackTrace();
        }
    }
}
