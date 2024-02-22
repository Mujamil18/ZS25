package com.mydemo.project1;


import java.io.*;
import java.util.ArrayList;

public class FileAdapter {
    /* created files for User and Admin separately FILEPATH1 for users and FILEPATH2 for admins */
    private static final String USERS= "/home/local/ZOHOCORP/mujamil-con1091/MailBox/Users.txt";
    private static final String ADMINS = "/home/local/ZOHOCORP/mujamil-con1091/MailBox/Admins.txt";
    File file = null;
//    private static String loginName;
    private ArrayList<Users> userList = new ArrayList<>();

    /* method to write user details to a file , if the account type is user, that will be stored in Users file
    and if it is admin , then it will be stored in Admins file*/
    public void writeUserDetails(Users user) {
        FileWriter fw = null;
        try {
            if (user.getAccountType().equals("user")) {
                fw = new FileWriter(USERS, true);
                fw.write(user.toString());
//                System.out.println(user);
            } else if (user.getAccountType().equals("admin")) {
                fw = new FileWriter(ADMINS, true);
                fw.write(user.toString());
//                System.out.println(user);
            } else {
                System.out.println("INVALID ACCOUNT TYPE!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
    //method to get the file path respective to the user
    public String getFilePath(Users user) {
        return "/home/local/ZOHOCORP/mujamil-con1091/MailBox/" + user.getName() + ".txt";
    }

    //method to create a file for a registered users while creating account
    public void createUserFile(Users user) {
        String userFile = getFilePath(user);
        FileWriter fw = null;
        try {
            file = new File(userFile);
            fw = new FileWriter(file);
//            System.out.println("File Created for you in this path --> " + userFile);
//            System.out.println("File name --> " + user.getName() + ".txt");
            System.out.println("Your Inbox is ready ;)\n");
            System.out.println("Please Login with your credentials");
//            loginName = user.getName();
            fw.write("THIS IS " + user.getName()+"'s INBOX, YOUR SENT AND RECEIVED MESSAGES WILL APPEAR HERE\n\n");

        } catch (Exception ee) {
            ee.printStackTrace();
        }
        finally
        {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public boolean readUsersFromFileToList() {
        boolean isFileEmptyOrNotExists = false;
        String[] userDetails;
        String s;
        FileReader fr = null;
        try {
            fr = new FileReader(USERS);
            BufferedReader br = new BufferedReader(fr);

            while ((s = br.readLine()) != null) {
                userDetails = s.split(" ");
//                System.out.println(userDetails[0] + " " + userDetails[1]);
                Users user = new Users(userDetails[0]);
                userList.add(user);
            }

        } catch (IOException e) {
            isFileEmptyOrNotExists = true;
//            e.printStackTrace();
//            System.out.println("No users found");
        }
        finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException fe) {
                    fe.printStackTrace();
                }
            }
        }
        return isFileEmptyOrNotExists;
    }
    public boolean checkLoginUser(String name){
//        readUsersFromFileToList();
        boolean userRegistered = false;
//        ArrayList<Users> users = readUsersFromFileToList();
        for(Users u : userList){
            if(u.getName().equals(name)){
                userRegistered = true;
            }
        }
        return userRegistered;
    }
    public ArrayList<Users> listUsers(String name){
        System.out.print("Users: ");
        for(Users u: userList){
            if(!u.getName().equals(name)) {
                System.out.print(u.getName() + " ");
            }
        }
        System.out.println();
        return userList;
    }

    public void writeSentMessages(Messages msgs, String loginName)
    {
        String fromFilePath = "/home/local/ZOHOCORP/mujamil-con1091/MailBox/"+loginName+".txt";
        FileWriter fw = null;
        try
        {
            fw = new FileWriter(fromFilePath, true);
            fw.write(msgs.toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
//    method to write messages to a recipient file, if the recipient is already registered
    public void writeMessagesToFile(Messages msgs, String loginName) {
        String toFilePath = "/home/local/ZOHOCORP/mujamil-con1091/MailBox/" + msgs.getRecipient() + ".txt";
        FileWriter fw = null;
        try {
//            if(check) {
                fw = new FileWriter(toFilePath, true);
                fw.write( " FROM : " + loginName + "     MESSAGE: "+ msgs.getMessage() +"\n");
                System.out.println("Message sent Successfully!");
//            }
//            else {
//                System.out.println("USER DOESN'T EXISTS");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    /* method to read message from login account and display */
    public void readMessageFromFile(String userFileName) {
        FileReader fr = null;
        try {
            fr = new FileReader("/home/local/ZOHOCORP/mujamil-con1091/MailBox/"+userFileName+".txt");
//            int i;
            String line;
            BufferedReader bfr = new BufferedReader(fr);
            while ((line = bfr.readLine()) != null){
                System.out.println(line);
            }
//            while ((i = fr.read()) != -1) {
//                System.out.print((char)i);
//            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}







    /*method to read user Details from a file to check Login credentials and will let the user to login
        only after created account(if the username and password are in the file)
    public boolean readUserDetails(UserLogin login) {
        String[] registeredUsers;
        String s;
        String name = login.getName();
        String password = login.getPassword();
        String str = name + " " + password;
        boolean check = false;
        FileReader fr = null;
        try {
            fr = new FileReader(USERS);
            BufferedReader br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {
                registeredUsers = s.split(", ");
                for (String u : registeredUsers) {
                    if (str.equals(u)) {
                        check = true;
                        break;
                    }
                }
//                System.out.println(Arrays.toString(registeredUsers));
            }
            if (check) {
                accountCreated = true;
                loginName = login.getName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return accountCreated;
    }
    method to read the Users file to check whether the recipient is registered or not
    public boolean readRegisteredUsers(String name)
    {
        String[] registeredUsers;
        String s,n="", str;
        boolean checkRecipient = false;
        FileReader fr = null;
        try {
            fr = new FileReader(USERS);
            BufferedReader br = new BufferedReader(fr);
            System.out.println("Users: ");
            while ((s = br.readLine()) != null) {
                registeredUsers = s.split(", ");
                for (String u : registeredUsers) {
                    System.out.print(registeredUsers[0] + " ");
                    if (u.contains(name)) {
                        str = u;
                        n = "";
                        for (char i = 0; i < str.length(); i++) {
                            if (str.charAt(i) == ' ') {
                                break;
                            }
                            n += str.charAt(i);
                        }
//                        System.out.println("Name " + n);
                        if (name.equals(n)) {
                            checkRecipient = true;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return checkRecipient;
    }*/