//package com.zs.programs;
//
//public class MatrixOps {
//    public static void main(String[] args) {
////        Matrix matrix = new Matrix(2, 3, new int[][]{{10, 20, 30}, {30, 40, 50}});
////        System.out.println(matrix);
//        Matrix m1 = new Matrix(2, 2, new int[][]{{1, 2}, {3, 4}});
//        System.out.println(m1);
//        Matrix m2 = new Matrix(2, 2, new int[][]{{5, 6}, {7, 8}});
//        System.out.println(m2);
////        System.out.println(m1.addition(m2));
////        Matrix m = new Matrix();
//        Matrix m = m1.addition(m2);
//        System.out.println(m);
////        Matrix mat = new Matrix(2, 2, new int[][]{{1, 0}, {0, 1}});
////        System.out.println(mat.isIdentityMatrix());
//
//
//
//    }
//}
//class Matrix{
//    int[][] matrix;
//    int row, column;
//    public Matrix(){
//        row = 3;
//        column = 3;
//        matrix = new int[][]{{1, 2, 3},
//                            {4, 5, 6},
//                            {7, 8, 9}};
//    }
//    public Matrix(int[][] matrix){
//        this.matrix= matrix;
//    }
//    public Matrix(int row, int column, int[][] matrix ){
//        this.row = row;
//        this.column = column;
//        this.matrix = matrix;
//    }
//    @Override
//    public String toString(){ //method overriding
//        String matrixStr = "";
//        for(int i=0; i<this.row; i++){
//            for(int j=0; j<this.column; j++){
//                if(j ==0){
//                    matrixStr += "| ";
//                }
//                if(this.matrix[i][j] < 10){
//                    matrixStr += " ";
//                }
//                matrixStr += this.matrix[i][j] + " ";
//                if(j == this.column-1){
//                    matrixStr += " |";
//                }
//            }
//            matrixStr += "\n";
//        }
//        return matrixStr;
//    }
//    public Matrix addition(Matrix m1){
//        int[][] arr = new int[m1.row][m1.column];
//        if(this.row == m1.row && this.column == m1.column) {
//            for (int i = 0; i < m1.row; i++) {
//                for (int j = 0; j < m1.column; j++) {
//                    arr[i][j] = this.matrix[i][j] + m1.matrix[i][j];
//                }
//            }
//        }
//        else{
//            System.out.println("Rows and Columns are not equal");
//        }
//        return new Matrix(arr);
//    }
//    public boolean isIdentityMatrix() {
//        boolean isExists = false;
//        for (int i = 0; i < this.row; i++) {
//            for (int j = 0; j < this.column; j++) {
//                if ((i != j && this.matrix[i][j] != 1) || (i == j && this.matrix[i][j] != 0)) {
//                    isExists = true;
//                }
//                else{
//                    isExists = false;
//                }
//            }
//            if(!isExists){
//                break;
//            }
//        }
//        return isExists;
//    }
//}
//
