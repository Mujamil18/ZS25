package special.programs;

import java.util.Scanner;

public class RotateMatrix {
    public static void main(String[] args) {
        Matrix m = new Matrix();
        m = m.getData();
        System.out.println(m);
        m = m.rotateMatrix();
        System.out.println(m);
    }
}
class Matrix{
    int[][] matrix;
    int row;
    int column;

    Matrix(){
        row = 3;
        column = 3;
        matrix = new int[][]{{1, 2, 3},
                             {4, 5, 6},
                             {7, 8, 9}};
    }
    Matrix(int row, int column, int[][] matrix){
        this.row = row;
        this.column = column;
        this.matrix = matrix;
    }

    Matrix(int[][] matrix){
        this.row = matrix.length;
        this.column = matrix[0].length;
        this.matrix = matrix;
    }

    Matrix(int row, int column){
        this.row = row;
        this.column = column;
    }

    public Matrix getData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of rows and columns: ");
        int row = sc.nextInt();
        int column = sc.nextInt();
        int[][] data = new int[row][column];
        System.out.println("Enter the matrix elements: ");
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                data[i][j] = sc.nextInt();
            }
        }
        return new Matrix(row, column, data);
    }
    public Matrix rotateMatrix(){
        int r;
        int[][] newData = new int[this.row][this.column];
        for(int i=0; i<this.row; i++){
            r = this.row;
            for(int j=0; j<this.column; j++){
                newData[i][j] = this.matrix[r-1][i];
                r--;
            }
        }
//        return new Matrix(this.row, this.column, newData);
        return new Matrix(newData);
    }

    @Override
    public String toString(){
        String arr = "";
        for(int i=0; i<this.row; i++){
            for(int j=0; j<this.column; j++){
//                System.out.println(this.matrix[i][j] + " ");
                arr += this.matrix[i][j] + " ";
            }
            arr += "\n";
        }
        return arr;
    }
}
