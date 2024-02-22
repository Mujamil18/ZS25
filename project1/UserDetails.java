package com.mydemo.project1;

import java.util.Scanner;

public class UserDetails
{
    Scanner sc = new Scanner(System.in);
    public Users getUserDetails()
    {
//        Users user = new Users();
        System.out.println("Create Account");
        System.out.print("Name --> ");
        String name = sc.nextLine();
//        user.setName(name);
        System.out.print("Email Id --> ");
        String email = sc.nextLine();
//        user.setEmail(email);
        System.out.print("Account Type (User / Admin) --> ");
        String accountType = sc.nextLine();
//        user.setAccountType(accountType);
        Password obj=new Password();
        while(!obj.checkStrength());
        System.out.println("Hi " + name + "! You're logged in :)");
        String password = obj.password;
//        user.setPassword(password);
        return new Users(name, email, accountType, password);
    }
    public UserLogin getLoginDetails()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name --> ");
        String name= sc.nextLine();
        System.out.print("Password --> ");
        String password = sc.nextLine();
        return new UserLogin(name, password);
    }
//    public String searchUser()
//    {
//        System.out.print("Enter an USER to search ");
//        String name = sc.nextLine();
//        return name;
//    }
}
