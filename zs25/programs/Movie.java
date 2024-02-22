package com.zs25.programs;

import java.util.Scanner;

public class Movie {
    static String RESET = "\u001B[0m";
    static String RED = "\u001B[41m";
    static String GREEN = "\u001B[32m";
    static  String GREEN_BG="\u001B[42m";
    static String YELLOW = "\u001B[33m";
    static byte life=3;

    String coat="\uD83E\uDD7C";
    String sScope="\uD83E\uDE7A";
    String teacher="\uD83D\uDC68\u200D\uD83C\uDFEB";
    String king = " \uD83E\uDD34";
    String queen="\uD83D\uDC78";
    String earth=" \uD83C\uDF0E";
    String alien = "\uD83D\uDC7D";
    String trophy = "\uD83C\uDFC6";
    String celbrate="\uD83C\uDF89";
    String ans[]={"doctor","teacher","raja rani","bhoomi","Alien"};




    public static void main(String[] args) {
        Movie equiz= new Movie();
        equiz.game();

    }
    public void playerName(){

    }
    public String game(){
        Scanner sc= new Scanner(System.in);
        byte idx=0;
        while (life>0){
            System.out.println("Guess this puzzle \uD83E\uDDE9 ?");

            System.out.println(GREEN+"Life:"+life+RESET);
            System.out.println(doctor());
            String answer=sc.next().toLowerCase();
            System.out.println(inputChecker(idx,answer));
            idx+=1;

            System.out.println(GREEN+"Life:"+life+RESET);
            System.out.println(teacher());
            String answer2=sc.next().toLowerCase();
            System.out.println(inputChecker(idx,answer2));
            idx+=1;
            System.out.println();

            System.out.println(GREEN+"Life:"+life+RESET);
            System.out.println(rajaRani());
            String answer3=sc.next().toLowerCase();
            System.out.println(inputChecker(idx,answer3));
            idx+=1;
            System.out.println();

            System.out.println(GREEN+"Life:"+life+RESET);
            System.out.println(earth());
            String answer4=sc.next().toLowerCase();
            System.out.println(inputChecker(idx,answer4));
            idx+=1;
            System.out.println();

            System.out.println(GREEN+"Life:"+life+RESET);
            System.out.println(alien());
            String answer5=sc.next().toLowerCase();
            System.out.println(inputChecker(idx,answer5));

            System.out.println(RED+"Game over"+RESET);


        }
        if (life>0){
            System.out.println(GREEN_BG+"You won"+trophy+RESET);
        }
        return "You loose \uD83D\uDE22";
    }

    //unicode methods
    public String doctor(){
        return coat+"+"+sScope;

    }
    public String teacher(){
        return teacher;
    }
    public String rajaRani(){
        return king+"+"+queen;
    }
    public String alien(){
        return alien;
    }
    public String earth(){
        return earth;
    }
    public  String inputChecker(int idx,String answer){
        if (answer.equals(ans[idx])){
            return GREEN+"You got it ! "+celbrate+RESET;
        }
        life-=1;
        return RED+"You lost 1 life"+RESET;
    }

}
