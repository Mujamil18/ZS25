package com.socket.practice;

import java.net.ServerSocket;
import java.net.Socket;

public class RemoteMonitor {
    public static void main(String[] args) {

    }
    public void listenToClient(){
        ServerSocket ss = null;
        try{
            ss = new ServerSocket(3000);
            System.out.println("Server is waiting to connect.....");
            Socket s = ss.accept();
            System.out.println("Client "+ ss.getInetAddress() + " connected ");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

