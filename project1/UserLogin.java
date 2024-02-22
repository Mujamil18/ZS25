package com.mydemo.project1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.*;

public class UserLogin implements Serializable
{
    private String name;
    private String password;

    public UserLogin(){}
    public UserLogin(String name , String password) {
        this.name = name;
        this.password = password;
    }
    public UserLogin getLoginDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Name --> ");
        String name= sc.nextLine();
        System.out.print("Password --> ");
        String password = sc.nextLine();
        return new UserLogin(name, password);
    }
    public String getName()
    {
        return this.name;
    }
    public String getPassword()
    {
        return this.password;
    }

}
