//package com.zs.programs;
//
//import java.util.*;
//
//public class NumberGame {
//    public static void main(String[] args){
//        StartNumberGame startGame = new StartNumberGame();
//        startGame.chooseNumber();
//        startGame.printList();
//    }
//}
//class StartNumberGame {
//    Scanner sc = new Scanner(System.in);
//    ArrayList<Integer> numbersChosen = new ArrayList<>(1);
//    int player1 = new Random().nextInt(100) + 1;
//    int player2 = new Random().nextInt(100) + 1;
//
////    int player1, player2;
//    int p1Count =0, p2Count =0;
//    public void chooseNumber() {
//        int i=0, tempPlayer1, tempPLayer2;
//        do {
//            if (player1 <= 100 && player2 <= 100) {
//                if (player1 % player2 == 0 || player2 % player1 == 0) {
//                    numbersChosen.add(player1);
//                    numbersChosen.add(player2);
//                    player1();
//                    i++;
//                }
////                else if(){
////
////                }else {
////                    i++;
////                    player2();
////                }
//            }
//        }while(i<numbersChosen.size());
//
//    }
//    public int player1(){
//        do{
//            player1 = new Random().nextInt(100)+1;
//        }while(!numbersChosen.contains(player1));
//        return player1;
//    }
//    public int player2(){
//        do{
//            player2 = new Random().nextInt(100)+1;
//        }while(!numbersChosen.contains(player2));
//        return player2;
//    }
//
//        public void printList() {
//            System.out.println(numbersChosen);
//        }
//}
//
