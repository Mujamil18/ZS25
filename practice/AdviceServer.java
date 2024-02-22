package com.socket.practice;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdviceServer {
    HashMap<InetAddress, Integer> ipAddress = new HashMap<>();
    public static void main(String[] args) {
        AdviceServer adSer = new AdviceServer();
//        adSer.listen("fortune");
        adSer.listen("fortune");
        adSer.getIpList();
    }
    public void listen(String command){
        String toExit = "";
//        ArrayList<InetAddress> ipList = new ArrayList<>();
        try{
            ServerSocket ss = new ServerSocket(4440);
            System.out.println("server is waiting for client!!!");
            Runtime r = Runtime.getRuntime();
            String commandResult = "";
            int n=0, count =0;
            while(n<3) {
//                while (true) {
                    Socket com = ss.accept();
                    System.out.println("Client " + com.getInetAddress() + "  Connected");
                    InetAddress ipAdd = com.getInetAddress();
                    if(searchExistingIpAddress(ipAdd)){
                        count++;
                    }
//                System.out.println("Client's IP: "+ip);
                    Process p = r.exec(command);
                    ipAddress.put(ipAdd, count);
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(com.getOutputStream()));
                    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String s;
                    while((s= br.readLine()) != null){
                        commandResult += s+"\n";
                    }
                    pw.println(commandResult);

//                pw.write("Hi");172.24.206.210
                    pw.flush();
                    pw.close();
                    n++;
                }
        }
        catch(Exception ee){
            System.out.println("error "+ ee);
        }
    }
    public boolean searchExistingIpAddress(InetAddress ip){
        boolean ipAddressExisted = false;
        for(Map.Entry m : ipAddress.entrySet()){
            if((m.getKey()).equals(ip)){
                ipAddressExisted  = true;
                break;
            }
        }
        return ipAddressExisted;
    }
    public void getIpList(){
        System.out.println("Clients connected: ");
        for(Map.Entry i : ipAddress.entrySet()){
            System.out.println("Host: "+ i.getKey() + " Connected: "+ i.getValue()+ " times" );
        }
    }
}

