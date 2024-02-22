package com.network.practice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FortuneCommand {
    public static void main(String[] args) {
        FortuneCommand fc = new FortuneCommand();
        fc.runCommand("java -version");


    }
    public void runCommand(String command){
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try{
            p = r.exec(command);
            String s;
            InputStream error = p.getErrorStream();
            InputStream res = p.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(error));
            while((s = br.readLine()) != null){
                System.out.println(s);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
