package com.network.practice;

import java.net.InetAddress;

public class InetTest {
    public static void main(String[] args) {
        try {
            InetAddress in = InetAddress.getByName("www.HerbSchildt.com");
            System.out.println("Get By Name - " +in);
            byte[] ipArray = in.getAddress();
            for(int i =0; i<ipArray.length; i++){
                System.out.println(ipArray[i]);
            }
            InetAddress ip[] = InetAddress.getAllByName("www.nba.com");
            for(int i=0; i<ip.length; i++){
                System.out.println("Get All By Name - " + ip[i]);
            }
            System.out.println("Local Host - " +InetAddress.getLocalHost());

            /* If these method failed return host, it will throw an exception called
            UnknownHostException.
             */
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
