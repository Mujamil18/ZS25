//package com.zs.programs;
//
////packages we need for this program
//import java.util.Random;
//import java.util.Scanner;
//
////Driver class
//public class NumberGuessing {
//    public static void main(String[] args){
//       PlayGame play = new PlayGame(); //object for PlayGame class
//       play.getNumber(); //getting input from user
//       play.startGuessing(); //start checking values
//    }
//}
//class PlayGame{
//    /* Used Random class to generate random integer number.
//       It generates between 0 and 9 , so we are adding 1 to it. */
//    int randomNumber = new Random().nextInt(10)+1;
//    int guessNumber = 0; //number to be entered by user
//    int guesses = 0; // no. of guesses
//
//    //method to get number from the user
//    public void getNumber(){
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter a number between 1 - 10 : " );
//        guessNumber = sc.nextInt();
//        guesses++;
//    }
//    //method to check the randomNumber and input entered by the user (guessNumber)
//    public boolean checkNumber(){
//        if(randomNumber == guessNumber){
//            return true;
//        }
//        return false;
//    }
//    /* method to start the guess game , if the number is correct, then
//       prints statements outside the loop and if the number is not correct,
//       then the while loop will be executed and asks for the next turn. */
//    public void startGuessing(){
//    /* while condition checks for checkNumber method and
//       if it returns true the condition applies false with (!) operator,
//       then the loop won't be executes and if it returns false,
//       then it is true and the loop will be executed. */
//        while(!checkNumber()){
//            System.out.println("Try again!!!");
//            getNumber();  //Code Reusability
//            //calling getNumber() method to get input again
//        }
//        System.out.println("YOU WON!!! \uD83C\uDFC6");
//        if(guesses <= 3) {
//            System.out.println("You won with " + guesses + " guesses \uD83E\uDD29");
//        }
//        System.out.println("You made it with " + guesses + " guesses");
//    }
//}
