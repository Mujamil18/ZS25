package com.zs25.programs;

import java.util.Scanner;

public class NimGame {
    public static void main(String[] args) {
        Play play = new Play();
        play.startGame();

    }
}
class Elements{
    private int[] data;
    private int size;
    public Elements(){}
    public Elements(int[] data){
        this.data = data;
    }
    public static int getNumberOfElements(){
        return (int)(Math.random()*20)+5;
    }
    public int[] getData(){
        return data;
    }
    public void setData(int[] data){
        this.data = data;

    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return this.data.length;
    }
    public Elements getElements(){
        this.size = getNumberOfElements();
        int[] value = new int[this.size];
        for(int i=0, j=1; i<value.length; i++, j++){
            value[i] = j;
        }
        return new Elements(value);
    }
    public Elements removeElements(int i){
        data = new int[data.length-1];
        return new Elements(data);
    }
    public String toString(){
        String res = "";
        if(data != null || data.length > 0) {
            res = "[ ";
            for (int i = 0; i < data.length; i++) {
                if (i != data.length - 1) {
                    res += data[i] + ", ";
                } else {
                    res += data[i] + " ]";
                }
            }
        }
        else{
            res = "[]";
        }
        return res;
    }

}
class Play{
//    int[] elements;
//    int size;
   Scanner sc = new Scanner(System.in);
//
//    public int[] getTotalNumberOfElements(){
//        int size;
//        System.out.print("Enter the total number of elements: ");
//        size = sc.nextInt();
//        elements = new int[size];
//        for(int i=0, j=1; i<elements.length; i++, j++){
//            elements[i] = j;
//        }
//        return elements;
//    }

    public int playerTurn(){
        return sc.nextInt();
    }
    public int computerTurn(){
        return (int)(Math.random()*2)+1;
    }

    public void startGame(){
        System.out.println("Game start!!");
        Elements elements = new Elements();
        elements = elements.getElements();
        System.out.println(elements);
        System.out.println(elements.getSize());
        int n = elements.getSize();
        int playerNum, compNum;
        int[] arr = elements.getData();
        while(n > 0){
            System.out.print("Player's turn: " );
            playerNum = playerTurn();
            n = check(playerNum, n, arr);
            System.out.println(n);
            elements.setData(arr);
            System.out.println(elements);


//            try{
//                Thread.sleep();
//            }
            System.out.print("Computer's turn: ");
            compNum = computerTurn();
            System.out.print(compNum+"\n");
            n = check(compNum, n, arr);
            System.out.println(n);
            elements.setData(arr);
            System.out.println(elements);
        }
    }
    public int check(int num, int n, int[] arr){
        if(num == 1){
            arr[n-1] =0;
            n-=1;
        }
        else if(num == 2){
            arr[n-1] =0;
            arr[n-2] =0;
            n-=2;
        }
        else{
            System.out.println("Please choose 1 or 2");
        }
        return n;
    }


}
