package com.zs25.programs;

import java.util.Scanner;

public class StringUtilityTool {
    public static void main(String[] args) {
        StringUtilities strUtilObj = new StringUtilities();
        strUtilObj.getText();
        int option;
        do {
            System.out.println("1. Character Count  2. Word Count  3. Line Count\n4. Contains  5. lowercase  6. UPPERCASE\n" +
                    "7. Reverse String   8. Toggle Cases");
            option = strUtilObj.getOption();
            switch (option) {
                case 1:
                    System.out.println("Character Count: "+ strUtilObj.countCharacters());
                    break;
                case 2:
                    System.out.println(strUtilObj.countWords());
                    break;
                case 3:
                    System.out.println(strUtilObj.countLines());
                    break;
                case 4:
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter the Character Sequence: ");
                    String charSeq = sc.nextLine();
                    System.out.println(strUtilObj.containsCharacters(charSeq));
                    break;
                case 5:
                    System.out.println(strUtilObj.toLowerCase());
                    break;
                case 6:
                    System.out.println(strUtilObj.toUpperCase());
                    break;
                case 7:
                    System.out.println(strUtilObj.reverse());
                    break;
                case 8:
                    System.out.println(strUtilObj.toggleCase());
                    break;
            }

        } while (option != 0);
    }
}
class StringUtilities{
    Scanner sc = new Scanner(System.in);
    String text = "";
    public int getOption(){
        System.out.println("Enter an option: ");
        int option = sc.nextInt();
        return option;
    }
    public void getText(){
        String str;
        System.out.println("Input: ");
        while(sc.hasNextLine()){
            str = sc.nextLine();
            if(str.equals("")){
                break;
            }
            text += str+"\n";
        }
    }
    public String replaceNextLine(){
        String temp;
        temp = text.replaceAll("\n", "");
        return temp;
    }
    public int countCharacters(){
//        String temp = text.strip();
         String temp = replaceNextLine();
//        System.out.println(temp);
//        temp = temp.strip();
//        System.out.println(temp);
        int count=0;
        for(int i=0; i<temp.length(); i++){
//            System.out.print(temp.charAt(i));
            count++;
        }
        return count;
    }
    public int countWords(){
        String temp = replaceNextLine();
        temp = temp.strip();
        System.out.println(temp);
        int count=0;
        for(int i=0; i<temp.length(); i++){
            if(temp.charAt(i) == ' ' || temp.charAt(i) == '\n'){
                count++;
            }
        }
        return count;
    }
    public int countLines(){
        int count=0;
//        text.strip(); //to remove spaces in between the string
        for(int i=0; i<text.length(); i++){
            if(text.charAt(i) == '\n'){
                count++;
            }
        }
        return count;
    }
    public boolean containsCharacters(String charSeq){
        if(text.contains(charSeq)){
            return true;
        }
        return false;

    }
    public String toLowerCase(){
        return text.toLowerCase();
    }
    public String toUpperCase(){
        return text.toUpperCase();

    }
    public String reverse(){
        String reverse ="";
        for(int i = text.length()-1; i>=0; i--){
            reverse += text.charAt(i);
        }
        return reverse;

    }
    public String toggleCase(){
        String toggledStr="";
        for(int i=0; i<text.length(); i++){
            if(text.charAt(i) >= 'A' && text.charAt(i) <= 'Z'){
                toggledStr += Character.toLowerCase(text.charAt(i));
            }
            else if(text.charAt(i) >= 'a' && text.charAt(i) <= 'z'){
                toggledStr += Character.toUpperCase(text.charAt(i));
            }
        }
        return toggledStr;

    }
}
