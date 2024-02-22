package com.zs25.programs;

import java.util.Scanner;

public class ExceptionHandling{
    public static void main(String[] args) {
        ExceptionHandling obj = new ExceptionHandling();
        System.out.println(obj.returnInteger());
    }
    public int returnInteger(){
        int t=1;
        boolean isExceptionCaught = false;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter a number: ");
            t = Integer.parseInt(sc.nextLine());
//            System.out.println(t);
            return t;
        }
        catch (NumberFormatException nfe){
            System.out.println("Exception caught");
            System.out.println("Invalid Input!!. Input is not an integer");
            isExceptionCaught = true;
            return t;
        }
        finally{
            System.out.print("Finally: ");
            if(isExceptionCaught){
                return 0;
            }
            else {
                return t;
            }
        }
    }
}
