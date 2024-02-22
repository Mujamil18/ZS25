package com.mydemo.project1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Messages implements Serializable
{
    String message;
    String recipient;
    public Messages()
    {
    }
    public Messages(String recipient, String message){
        this.recipient = recipient;
        this.message = message;
    }
    public Messages getMessageDetails(String loginName, ArrayList<Users> uList){
        Scanner sc = new Scanner(System.in);
        String r="", m="";
//        if(uList.size() > 1 ) {
            System.out.println("Select a recipient to send a message");
            r = sc.nextLine();
            if (!loginName.equals(r)) {
                System.out.println("Type a message");
                m = sc.nextLine();
            }
            else {
                System.out.println("User not found");
            }
//        }
//        else{
//            System.out.println("It seems you have no friends!! :(");
//        }

        return new Messages(r, m);
    }

    public String getRecipient()
    {
        return this.recipient;
    }
    public String getMessage()
    {
        return this.message;
    }
    public String toString()
    {
        return  "MESSAGE --> " +  message+" SENT TO --> " + recipient+"\n";
    }

}
