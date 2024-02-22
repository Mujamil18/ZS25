package com.zs25.programs;

import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        PlayGame playGame = new PlayGame();
        playGame.startPlaying();
    }
}

class Player{
    String playerName;
    int guessedNumber;
    int noOfGuesses;
    public void setPlayerName(String name){
        this.playerName = name;
    }
    public String getPlayerName(){
        return playerName;
    }
    public void setGuessedNumber(int num){
        guessedNumber = num;
    }
    public int getGuessedNumber(){
        return guessedNumber;
    }
}
class PlayGame {
   int noOfPlayers;
   static int answer;
   String finalName="";

    public void generateNumber(){
      answer = (int) (Math.random()* 10)+1;
   }
   /* method to get the number of players */
   public int getNoOfPlayers(){
       Scanner sc = new Scanner(System.in);
       System.out.print("How many players? ");
       noOfPlayers = sc.nextInt();
       return noOfPlayers;
   }
   /* method to create player according to number of players */
   public Player[] getPlayers(){
       Scanner sc = new Scanner(System.in);
       String name; //variable to store name of player name
       int n = getNoOfPlayers();
       //creating array of Player type to store player objects
       Player[] player = new Player[n];
       for(int i=0, j=1; i<n; i++, j++){
           Player p = new Player(); //creating new player object(no. of players)
           /* Each player is an object */

           System.out.print("Player "+j+" Name: ");
           //getting player name as input for each object
           name = sc.nextLine();
           p.setPlayerName(name); //setting name of tbe player
           player[i] = p; //assigning player object in the Player[]
       }
       return player;
   }
   public void playerDetails(Player[] players){
       System.out.println("----------------------------");
       System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT+"PLAYERS: "+ConsoleColors.RESET);
       for(Player p : players){
           System.out.print(p.getPlayerName()+ " ");
       }
       System.out.println();
   }
   public boolean checkNumber(int number){
       if(number == answer){
           return true;
       }
       return false;
   }
   public void startPlaying(){
       // getting player array and storing in an array variable (Player type)
       Player[] p = getPlayers();
       playerDetails(p); //printing player details
       System.out.println("* * * * * * * * * * * *");
       System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+ ConsoleColors.GREEN_BACKGROUND + "     GAME STARTS!!!    " + ConsoleColors.RESET);
       System.out.println("* * * * * * * * * * * *");
       generateNumber(); //generates random number
       System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "FIND THE NUMBER (1 - 10)" +ConsoleColors.RESET);
       System.out.println("-------------------------");
       Scanner sc = new Scanner(System.in);
       int number = 0;
       do{
           for(int i=0; i<p.length; i++){
               System.out.print(p[i].getPlayerName()+"'s turn: ");
               number = sc.nextInt() ; //getting current player's number
               p[i].setGuessedNumber(number);
               p[i].noOfGuesses++;
               if (number == answer){
                   System.out.println(ConsoleColors.GREEN + "CORRECT \uD83E\uDD29" + ConsoleColors.RESET);
                   System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + p[i].getPlayerName() + " WON!!\uD83C\uDFC6 the match");
                   finalName = p[i].getPlayerName();
                   gamesPlayed(p);
                   break;
               }
               else{
                   System.out.println(ConsoleColors.RED + "WRONG \uD83D\uDE41" + ConsoleColors.RESET );
               }
           }
       }while(!checkNumber(number));
       System.out.println();
   }
   public void gamesPlayed(Player[] players){
       System.out.println(ConsoleColors.WHITE_UNDERLINED + "LEADER BOARD" + ConsoleColors.RESET);
       for(Player p : players){
           if(p.getPlayerName().equals(finalName)){
               System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT + p.getPlayerName() + "  ---- "+ p.noOfGuesses + " guesses");
               System.out.println("  ---- WINNER \uD83C\uDFC6" + ConsoleColors.RESET);
           }
           else {
               System.out.println(p.getPlayerName() + "  ---- " + p.noOfGuesses + " guesses");
           }
       }
   }
}
