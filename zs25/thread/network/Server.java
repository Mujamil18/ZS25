package com.zs25.thread.network;

import com.zs25.programs.ConsoleColors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class Server {
    HashMap<InetAddress, Integer> ipAddress = new HashMap<>();
    public static void main(String[] args) {
        try{
            Server s = new Server();
            s.openConnection();
//            s.getConnectedClients();

        }
        catch(Exception e){
            System.out.println("issue in main");
            e.printStackTrace();
        }

    }
    public void openConnection(){
        ServerSocket ss = null;
        Socket socket = null;
        int clientCount =0;
        try{
            ss = new ServerSocket(4555);
            System.out.println("Waiting for Client");
            while(true){
                socket = ss.accept();
                clientCount++;
                InetAddress ipAdd = socket.getInetAddress();

                System.out.println("Client "+clientCount + " connected with " + socket.getInetAddress());

                ClientHandler clientHandler = new ClientHandler(socket, ipAdd);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
class ClientHandler implements Runnable{
    private Socket s;
    private InetAddress ip;

    ClientHandler(Socket s, InetAddress ip){
        this.s = s;
        this.ip = ip;
    }
    public void run(){
        try {
            System.out.println();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            pw.println("Welcome to the Server! Type 'bye' to exit.");

            String clientMessage;
            while ((clientMessage = br.readLine()) != null) {

                if (clientMessage.equalsIgnoreCase("bye")) {
                    pw.println("Goodbye! Closing connection.");
                    break;
                }
                System.out.println();
                System.out.println("Client "+ ip+" says: "+ConsoleColors.BLUE_BOLD+ clientMessage+ConsoleColors.RESET );
                System.out.print("Enter message to client: ");
                String message = input.readLine();
                pw.println(message);
            }

            br.close();
            pw.close();
            s.close();

            System.out.println("Client disconnected");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
