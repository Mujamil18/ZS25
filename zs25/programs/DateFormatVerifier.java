package com.zs25.programs;

import java.util.Scanner;

public class DateFormatVerifier {
    public static void main(String[] args) {
        VerifyDate verify = new VerifyDate();
        verify.checkFullDate();
    }
}
class VerifyDate {
    String date = "";
    public void checkFullDate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date: ");
        date = sc.nextLine();
        if(checkSeparator() && checkDate() && checkMonth() && checkYear()){
            System.out.println("The given Date format is CORRECT");
        }
        else{
            System.out.println("The given Date format in INCORRECT");
        }
    }
    public boolean checkSeparator(){
        if(date.charAt(2) == '/'  && date.charAt(5) == '/'){
            return true;
        }
        else if(date.charAt(2) == '.'  && date.charAt(5) == '.'){
            return true;
        }
        else if(date.charAt(2) == '-'  && date.charAt(5) == '-'){
            return true;
        }
        return false;
    }

    public int[] convertToString(){
        String[] dateStrArray = date.split("/");
        int[] dateIntArray = new int[dateStrArray.length];
        for(int i=0; i<dateStrArray.length; i++){
            if(dateStrArray[i].contains("/") || dateStrArray[i].contains("-") || dateStrArray[i].contains(".")) {
                System.out.println("Special characters is not allowed in date/month/year");
                break;
            }
            else{
                dateIntArray[i] = Integer.parseInt(dateStrArray[i]);
            }
        }
        return dateIntArray;
    }

    public boolean checkDate(){
        int date;
        date = convertToString()[0];
        if(date >= 1 && date <=31){
            return true;
        }
        else{
//            System.out.println("Invalid Date");
            return false;
        }
    }
    public boolean checkMonth(){
        int month;
        month = convertToString()[1];
        if(month >=1 && month <=12){
            return true;
        }
        else{
//            System.out.println("Invalid Month");
            return false;
        }
    }
    public boolean checkYear(){
        int year;
        year = convertToString()[2];
        if(year >=1900 && year <=2023){
            return true;
        }
        else{
//            System.out.println("Invalid Year");
            return false;
        }
    }
}
//31 days - 1, 3, 5, 7, 8, 10, 12
//30 days -  4, 6, 9, 11
//28/29 days - 2
