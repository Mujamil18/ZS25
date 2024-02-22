package com.zs25.thread.network;

import com.zs25.programs.ConsoleColors;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 4555);

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            // Receiving and displaying the server's response
            String serverResponse;
            while ((serverResponse = br.readLine()) != null) {

                if (serverResponse.equalsIgnoreCase("Goodbye! Closing connection.")) {
                    break;
                }
                System.out.println("Server says: " +ConsoleColors.CYAN_BOLD +serverResponse + ConsoleColors.RESET);
                System.out.print("Enter message to server: ");
                String message = input.readLine();

                pw.println(message);
            }


            // Sending a message to the server



            // Close the socket and streams
            socket.close();
            br.close();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

