package special.programs;

import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter 12-hr format time: ");
        String str= scanner.nextLine();

        String outputTime = "";
        //Getting the first element in string as an integer
        int h1= (int) str.charAt(0)-'0';

        //Getting second element in string as an integer
        int h2= (int) str.charAt(1)-'0';

        //Combining the first and second element in time format
        int hh= ( h1 * 10 ) + ( h2 % 10);

        int i;

        //if the time AM
        if(str.charAt(8)=='A')
        {
            if(hh==12) {
//                System.out.print("00");
                outputTime += "00";
                for (i = 2; i <= 7; i++) {
                    outputTime += str.charAt(i);
//                    System.out.print(str.charAt(i));
                }
            }
            else {
                for(i=0; i<=7; i++) {
                    outputTime += str.charAt(i);
//                    System.out.print(str.charAt(i));
                }
            }
        }
        //if the time PM
        if(str.charAt(8) == 'P')
        {
            if(hh==12)
            {
                for(i=0; i<=7; i++) {
                    outputTime += str.charAt(i);
//                    System.out.print(str.charAt(i));
                }
            }
            else
            {
                hh += 12;
//                System.out.print(hh);
                outputTime += hh;
                for(i=2; i<=7; i++) {
                    outputTime += str.charAt(i);
//                    System.out.print(str.charAt(i));
                }
            }
        }
        System.out.println("24-hour format: " + outputTime);
    }
}