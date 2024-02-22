package com.socket.practice;

import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

public class AdviceClient {
    public static void main(String[] args) {
        AdviceClient adCli = new AdviceClient();
        adCli.connect();

    }
    public void connect(){
        Socket com = null;
        try {
            com = new Socket("localhost", 4440);
//            com = new Socket("172.24.206.210", 4440);
            System.out.println("Connected successfully to the server");
//            BufferedReader br = new BufferedReader(new InputStreamReader(com.getInputStream()));
            InputStreamReader is = new InputStreamReader(com.getInputStream());
            Scanner sc = new Scanner(is);
            System.out.println("Server says: \n"+sc.nextLine());

//            String message = br.readLine();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(com.getOutputStream()), true);
            pw.println("Thank you");

        }
        catch(Exception ee){
            ee.printStackTrace();
//            System.out.println(ee);
        }
        finally{
            try {
                if (com != null) {
                    com.close();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}
