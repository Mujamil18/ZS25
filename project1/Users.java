package com.mydemo.project1;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Users implements Serializable
{
    private String name;
    private String email;
    private String accountType;
    private String password;
    LocalDateTime accountCreatedTime;

    public Users(){

    }
    public Users(String name){
        this.name = name;
    }


    public Users(String name, String email, String accountType, String password)
    {
        this.name = name;
        this.email = email;
        this.accountType = accountType;
        this.password = password;
        this.accountCreatedTime = LocalDateTime.now();
    }
    public Users getUserDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Create Account");
        System.out.print("Name --> ");
        String name = sc.nextLine();
        System.out.print("Email Id --> ");
        String email = sc.nextLine();
        System.out.print("Account Type (User / Admin) --> ");
        String accountType = sc.nextLine();
        Password obj=new Password();
        while(!obj.checkStrength());
        System.out.println();
        System.out.println("Welcome " + name + "!");
        String password = obj.password;
        return new Users(name, email, accountType, password);
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setEmail(String email)
    {
        this.email= email;
    }
    public String getAccountType()
    {
        return this.accountType;
    }
    public void setAccountType(String accountType)
    {
        this.accountType= accountType;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
//    public LocalDateTime getAccountCreatedTime(){
//        return LocalDateTime.now();
//    }

    @Override
    public String toString() {
        return this.name +" " + this.password+ " "+accountCreatedTime+"\n";
    }

}

