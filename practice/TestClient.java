package com.socket.practice;

import java.net.Socket;

public class TestClient {
    public static void main(String[] args) {

    }
    public void connectToServer(){
        Socket socket;
        try{
            socket = new Socket("localhost", 5000);



        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
