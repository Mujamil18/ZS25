//package com.zs.programs;
//
//import java.util.Scanner;
//
//public class MatrixOperations {
//
//    public static void main(String[] args) {
//        Matrix matrix1 = new Matrix();
//        matrix1 = matrix1.getMatrix();
//        System.out.println(matrix1);
////        System.out.println(matrix1.isUnitMatrix());
//
//    }
//}
//class Matrix{
//    int[][] matrix;
//    int row, column;
//
//    public Matrix(){
////        row = 3;
////        column = 3;
////        matrix = new int[][]{{1, 0, 0},
////                             {0, 1, 0},
////                             {0, 0, 1}};
//    }
//    public Matrix(int row, int column, int[][] matrix){
//        this.row = row;
//        this.column = column;
//        this.matrix = matrix;
//    }
//    public Matrix(int[][] matrix){
//        this.matrix = matrix;
//    }
//    public Matrix(int row, int column){
//        this.row = row;
//        this.column = column;
//    }
//    public Matrix getMatrix(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the rows and columns: ");
//        int row = sc.nextInt();
//        int column = sc.nextInt();
//        int[][] data = new int[row][column];
//        System.out.println("Enter your " + (row) + " x " + (column) + " Matrix elements: ");
//        for(int i=0; i<row; i++){
//            for(int j=0; j<column; j++){
//                data[i][j] = sc.nextInt();
//            }
//        }
//        return new Matrix(row, column, data);
//    }
////    public void printMatrix(){
////        System.out.println(this.row + " " + this.column);
////        for(int i=0; i<this.row; i++){
////            for(int j=0; j<this.column; j++){
////                System.out.print(this.matrix[i][j] + " ");
////            }
////            System.out.println();
////        }
////    }
//
//    public boolean isUnitMatrix(){
//        boolean isOneExist = false;
////        System.out.println(this.row + " "+this.column);
//        if(this.row == this.column) {
//            for (int i = 0; i < this.row; i++) {
//                for (int j = 0; j < this.column; j++) {
//                    if (i == j) {
////                        System.out.println(i+ " "+ j);
//                        if(this.matrix[i][j] == 1) {
//                            isOneExist = true;
//                        }
//                    }
//                }
//            }
//        }
//        return isOneExist;
//    }
//    public String toString() {
//        String matrixStr = "";
//        for(int i=0; i<this.row; i++){
//            for(int j=0; j<this.column; j++){
////                System.out.print(this.matrix[i][j] + " ");
////                System.out.println(this.row + " "+ this.column);
//                matrixStr += this.matrix[i][j] + " ";
//            }
//            matrixStr += "\n";
//        }
//        return matrixStr;
//    }
//}
