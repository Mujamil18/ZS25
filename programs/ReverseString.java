package special.programs;

import java.util.Scanner;

public class ReverseString {
    String input;
    public static void main(String[] args) {
        ReverseString rev = new ReverseString();
        String input = rev.getInput();
        rev.reverseString(input);

    }
    public String getInput(){
        System.out.println("Enter a String: ");
        String input = new Scanner(System.in).nextLine();
        return input;
    }
    public void reverseString(String input){
        String[] inputArr = input.split(" ");
        String[] temp = new String[inputArr.length];
        String t ="";
        char c;
        String spChars="";
        for(int i=0, j=inputArr.length-1; j>=0; i++, j--){
            temp[i] = inputArr[j];
            for(int s=0; s<temp[i].length(); s++){
                if(temp[i].charAt(s) >= 33 && temp[i].charAt(s) <= 47) {
//                    spChars += temp[i].charAt(s);
                }
                else{
                    t += temp[i].charAt(s);
                }
            }
            System.out.println(t);
        }
    }
}
