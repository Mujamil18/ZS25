package com.zs25.programs;

import java.util.Scanner;

public class ChessBoard {
    static String[][] chessPieces = {{" ♖ ", " ♗ ", " ♘ ", " ♕ ", " ♔ ", " ♘ ", " ♗ ", " ♖ "},
                                    {" ♙ ", " ♙ ", " ♙ ", " ♙ ", " ♙ ", " ♙ ", " ♙ ", " ♙ "},
                                    {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
                                    {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
                                    {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
                                    {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
                                    {" ♟ ", " ♟ ", " ♟ ", " ♟ ", " ♟ ", " ♟ ", " ♟ ", " ♟ "},
                                    {" ♜ ", " ♝ ", " ♞ ", " ♛ ", " ♚ ", " ♞ ", " ♝ ", " ♜ "}
                                    };
    int row = 8, column = 8;
    String color1 = ConsoleColors.BLACK_BACKGROUND;
    String color2 = ConsoleColors.WHITE_BACKGROUND;
    public ChessBoard(){

    }
    public ChessBoard(int row, int column){
        this.row = row;
        this.column = column;
    }
    public void setColor(String color1, String color2){
        this.color1 = color1;
        this.color2 = color2;
    }
//    public String[] setBoardColor(){
//
//    }
    public String toString() {
        String chessStr = "";
        String color;
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                color = (i+j)%2 == 0 ? this.color1 : this.color2;
                chessStr += color + chessPieces[i][j] + ConsoleColors.RESET;
            }
            chessStr += "\n";
        }
        return chessStr;
    }
    public String[] setBoardColors(){
        Scanner sc = new Scanner(System.in);
        String[] colors = new String[2];
        int option;
            System.out.println("1. RED/WHITE \n2. PURPLE/WHITE \n3. CYAN/GREEN ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    colors[0] = ConsoleColors.RED_BACKGROUND;
                    colors[1] = ConsoleColors.WHITE_BACKGROUND;
                    break;
                case 2:
                    colors[0] = ConsoleColors.PURPLE_BACKGROUND;
                    colors[1] = ConsoleColors.WHITE_BACKGROUND;
                    break;
                case 3:
                    colors[0] = ConsoleColors.CYAN_BACKGROUND;
                    colors[1] = ConsoleColors.GREEN_BACKGROUND;
                    break;
                case 0:
                    System.out.println("Default");
                    break;
                default:
                    colors[0] = ConsoleColors.BLACK_BACKGROUND;
                    colors[1] = ConsoleColors.WHITE_BACKGROUND;
                    break;

            }
        return colors;
    }

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        System.out.println(chessBoard);
        String[] colors = chessBoard.setBoardColors();
        chessBoard.setColor(colors[0], colors[1]);
        System.out.println(chessBoard);
    }
}
