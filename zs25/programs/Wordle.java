package com.zs25.programs;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Wordle {
    public static void main(String[] args) {
        String[] words = {"agile", "apple", "aisle", "beast", "blend", "black", "chart", "cause", "cloth", "death", "drive"};
        String finalWord = words[getRandomWord(words)];
//		System.out.println(finalWord);
        Wordle wordle = new Wordle();
        wordle.playGame(finalWord);
    }
    public static int getRandomWord(String[] array) {
        int index;
        Random random = new Random();
        index = random.nextInt(array.length);
        return index;
    }
    public void playGame(String word) {
        Scanner sc = new Scanner(System.in);
        String input;
        int attempts=0;
        do {
            System.out.print("Enter a 5 letter word: ");
            input = sc.nextLine();
            if(!(word.length() == input.length())) {
                System.out.println("Enter 5 letters, please...");
            }
            else {
                if(word.equals(input)) {
                    System.out.println("Wooohooo!!!, YOU GOT IT :)");
                    break;
                }
                else {
                    ArrayList<Integer> correctPos = new ArrayList<>();
                    ArrayList<String> lettersPresent = new ArrayList<>();
                    attempts++;
                    for(int i=0, j=0; i<word.length(); i++) {
                        if(word.charAt(i) == (input.charAt(i))) {
                            correctPos.add(i);
                        }
                        while(j<word.length()) {
                            String letter = String.valueOf(input.charAt(j++));
                            if((word.contains(letter)) && (word.indexOf(letter) != input.indexOf(letter))) {
                                lettersPresent.add(letter);
//                                lettersPresent.add(letter.charAt(0));
                            }
                        }
                    }
                    System.out.println("Correct Positions");
                    for(int i:correctPos) {
                        System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT + (i+1) + ConsoleColors.RESET+" " );
                    }
                    System.out.println();
                    System.out.println("Letters present but in the wrong position");
                    for(String c: lettersPresent) {
                        System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + c + ConsoleColors.RESET + " ");

                    }
                    System.out.println();
//                    for(int i=0; i<lettersPresent.size(); i++) {
//                        String c = lettersPresent.get(i);
//                        if (input.contains(c)) {
//                            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + c + ConsoleColors.RESET + " ");
//                        } else {
//                            System.out.print(input.charAt(i) + " ");
//                        }
//                    }

//                    for(int i=0; i<lettersPresent.size(); i++){
//                        for(int j =0; j<input.length(); j++){
//                            if(input.charAt(j) != lettersPresent.get(i)){
//                                System.out.print(input.charAt(i) + " ");
//                            }
//                            else{
//                                char c = lettersPresent.get(j);
//                                System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + c + ConsoleColors.RESET + " ");
//                            }
//                        }

//                    }

                }
            }
            System.out.println();

        }while(attempts < 6);
        if(attempts==6) {
            System.out.println("Out of attempts :(, Replay!!!");
        }
    }

}
