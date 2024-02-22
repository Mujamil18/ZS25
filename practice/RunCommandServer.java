package com.network.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class RunCommandServer {

    RunCommandServer(String command) throws Exception{
        ServerSocket ss = new ServerSocket(4001);
        System.out.println("Port is open");

//        while(true) {
            Socket socket = ss.accept();
            System.out.println("Client " + socket.getInetAddress() + " connected");

            BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outputBuffer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

//        Scanner sc = new Scanner(System.in);
//        String command = sc.nextLine();
            outputBuffer.println(command);
            Scanner sc = new Scanner(inputBuffer);
            String message = "";
            while(sc.hasNextLine()) {
                message += sc.nextLine()+"\n";
            }
        System.out.println("Client says: " + message);

            socket.close();
            System.out.println("Socket is closed");
        }

//    }

    public static void main(String[] args) {
        try{
            new RunCommandServer("top");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
