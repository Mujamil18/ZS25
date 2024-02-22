package com.mydemo.project1;
import java.util.*;

public class Accessibility
{
    FileAdapter fa = new FileAdapter();
//    UserDetails userObject = new UserDetails();
    /* UserDetails class is for getting user credentials (name , email id , account type, password) */

//    UserLogin login = null;
    public void openApplication() {
        Scanner sc = new Scanner(System.in);
        int mainOption;
        do {
            System.out.println("1.Create Account\n2.Login\n0.Quit");
            mainOption = sc.nextInt();
            switch (mainOption) {
                case 1: //Create Account
                    /* invoking getUserDetails() method from Users class and
                    assigning returned value to the Users object */
                    Users users = new Users();
                    users = users.getUserDetails();
                    fa.writeUserDetails(users);
                    fa.createUserFile(users);
                    break;
                case 2: //Login
                    System.out.println("Login");
                    if(fa.readUsersFromFileToList()){
                        System.out.println("No users found");
                        return;
                    }
                    UserLogin login = new UserLogin();
                    login = login.getLoginDetails();
                    if(fa.checkLoginUser(login.getName())){
                        userAccessibility(login);
                    }
                    else{
                        System.out.println("Invalid Username or Password");
                    }
                    break;
                case 3:

                case 0:
                    System.out.println("Program Exited");
            }
        } while (mainOption != 0);
}
    public void userAccessibility(UserLogin login)
    {
        Scanner sc = new Scanner(System.in);
        int accessOption;
        do {
            System.out.println("\n1.Send Message\n2.View Message\n0.Logout");
            accessOption = sc.nextInt();
            sc.nextLine();
            switch(accessOption)
            {
                case 1:
                    ArrayList<Users> uList = fa.listUsers(login.getName());
                    if(uList.size() > 1) {
                        Messages msgs = new Messages();
                        msgs = msgs.getMessageDetails(login.getName(), uList);
                        //invoking Message Constructor to get message
//                        boolean checkRecipient = fa.checkLoginUser(msgs.getRecipient());
                        if(fa.checkLoginUser(msgs.getRecipient())) {
                            fa.writeMessagesToFile(msgs, login.getName());
                            fa.writeSentMessages(msgs, login.getName());
                        }
                        else{
                            System.out.println("Invalid User");
                        }
                    }
                    else{
                        System.out.println("It seems you have no friends!! :(");
                    }
                    break;
                case 2:
                    System.out.println("View Message");
                    String fileName = login.getName();
                    fa.readMessageFromFile(fileName);
                    break;
                case 3:
                    System.out.println("Delete Message");
                    break;
                case 4:
                    System.out.println("Search");
                    break;
                case 0:
                    System.out.println("Back");
            }
        }while(accessOption != 0);
    }
}
