package com.zs25.programs;

import java.util.Scanner;

public class LetterCount {
    public static void main(String[] args){
        FindCount findCount = new FindCount();
        findCount.getInputs();
        int result = findCount.countLetter();
        System.out.println("The number of '"+findCount.letter +
                "' present in the word \"" +findCount.text+ "\" : "+result );
    }
}
class FindCount{
    String text;
    char letter;

    public void getInputs(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        text = sc.nextLine();
        System.out.print("Enter the letter you want to count: ");
        letter = sc.next().charAt(0);
    }
    public int countLetter(){
        int count =0;
        for(int i=0; i<text.length(); i++){
            if(text.charAt(i) == letter){
                count++;
            }
        }
        return count;
    }
}
