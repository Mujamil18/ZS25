package special.programs;

import java.util.Scanner;

public class SubstringPalindrome {
    public static void main(String[] args) {
        SubstringPalindrome strPal = new SubstringPalindrome();
        String input = strPal.getString();
        strPal.printSubstringPalindrome(input);

    }
    public String getString(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = sc.nextLine();
        return str;
    }
    public void printSubstringPalindrome(String str){
        String temp, tempRev = "";
        for(int i=0; i<str.length(); i++){
            for(int j=i+2; j<str.length(); j++){
                temp = str.substring(i, j);
                System.out.println("Temo: "+temp);
                tempRev = "";
                for(int k =0 ; k<temp.length(); k++){
                    tempRev = temp.charAt(k) + tempRev;
                }
                System.out.println("TempRev: "+ tempRev);
                if(tempRev.equals(temp)){
                    System.out.println(temp);
                }
            }
        }
    }
}
