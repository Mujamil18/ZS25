package com.zs25.programs;
import java.util.Scanner;

public class PlayQuizGame{
    public static void main(String[] args) {
        QuizGame quizGame = new QuizGame();
        quizGame.startGame();
    }
}
class QuizGame {
    String[] questions = {"\uD83C\uDF0D+\uD83E\uDD5B", "\uD83E\uDD8C+\uD83E\uDD4B", "\uD83E\uDD34+\uD83D\uDC78\uD83C\uDFFB", "\uD83D\uDCF1\uD83D\uDD01\uD83D\uDCF1/ \uD83D\uDC96️ + \uD83D\uDC47\uD83C\uDFFB\uD83D\uDDD3️", "\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB+\uD83D\uDE45\uD83C\uDFFB+\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83C\uDF93"};
    String[] answers = {"worldcup", "maan karate", "raja rani", "love today", "velai illa pattadhari"};

    public String getPlayer(){
        GamePlayer player = new GamePlayer();
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.print("Your Name? ");
        name = ConsoleColors.PURPLE_BOLD_BRIGHT+sc.next()+ConsoleColors.RESET;
        player.setName(name);
        return player.getName().toUpperCase();
    }
    public int generateRandomIndex(){
        return (int) (Math.random() * (questions.length-1));
    }
    public void startGame(){
        String playerName = getPlayer();
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Welcome "+ playerName +"!.."+ ConsoleColors.RESET+"\nAre you ready for the game?");
        System.out.println("-----------------------------------------");
        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+"INSTRUCTIONS"+ConsoleColors.RESET);
        System.out.println("1. You will be given 5 questions and 3 lives\n2. You have to answer all the questions to win the game\n3. If you fail to make it within 3 lives, you lose");
        Scanner sc = new Scanner(System.in);
        int indexNum, lives = 3;
        boolean isCorrect = false, hasAnswer= false;
        String answer;
//        indexNum = generateRandomIndex(); // generate random number for index
//        indexNum = 4;
//        System.out.println(indexNum);
        for (int i = 0; i < questions.length; i++) {
            System.out.println("----------------------------");
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + "QUESTION " +(i+1) +": "+ ConsoleColors.RESET + questions[i] );
            System.out.println("  "+ConsoleColors.CYAN_BOLD_BRIGHT+ "LIVES: "+ lives + ConsoleColors.RESET);
            while(lives > 0) {
                hasAnswer= false;
                System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT + "ANSWER: " + ConsoleColors.RESET);
                answer = sc.nextLine();
                for(String j: answers){
                    if(answer.equals(j)){
                        hasAnswer = true;
                    }
                }
                if (hasAnswer) {
                    System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT+"Correct \uD83D\uDC4F\uD83C\uDFFB , You are Cool \uD83D\uDE0E "+ConsoleColors.RESET);
                    isCorrect = true;
                    break;
                }
                else {
                    isCorrect= false;
                    lives--;
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Not Correct \uD83D\uDE41..! Try Again" + ConsoleColors.RESET);
                }
            }
            if(lives == 0){
                break;
            }
        }
        if(!isCorrect){
            System.out.println("You lost you lives \uD83D\uDC94\uD83E\uDD7A");
            System.out.println(ConsoleColors.RED_BOLD+"GAME OVER"+ConsoleColors.RESET);
        }
        else{
            System.out.print("You answered all questions.");
            System.out.println("  "+ConsoleColors.RED_BOLD_BRIGHT+ "LIVES: "+ lives + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Well Done! " + playerName + ConsoleColors.RESET + "..! \uD83E\uDD73 ");
        }
    }
}
class GamePlayer{
    private String name="";
    GamePlayer(){

    }
    GamePlayer(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}


