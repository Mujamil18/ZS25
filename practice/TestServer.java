package com.socket.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {

    }
    public void openConnection() {
        ServerSocket ss;
        Socket socket;

        try {
            ss = new ServerSocket(5000);
            socket = ss.accept();
            System.out.println("Client " + socket.getInetAddress() + " connected");

            InputStreamReader stream = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(stream);
            String s = reader.readLine();
            System.out.println("Client says: "+ s);

        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
