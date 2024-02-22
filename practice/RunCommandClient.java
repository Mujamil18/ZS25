package com.network.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class RunCommandClient {

    RunCommandClient() throws Exception{
        Socket socket = new Socket("localhost", 4001);
        System.out.println("Successfully connected to the server");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        String message = input.readLine();
//        System.out.println("Server says: "+ message);
        String result= runCommand(message);

//        output.println("Thanks");
        output.println(result);
        socket.close();
        System.out.println("Scoket is closed");
    }
    public static void main(String[] args) {
        try{
            new RunCommandClient();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public String runCommand(String command){

        Runtime r = Runtime.getRuntime();
        Process p = null;
        String result = "";
        try{
            p = r.exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s;
            while((s = br.readLine()) != null){
                result += s+"\n";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
