package com.zs25.programs;
import java.util.Scanner;
class AlgebraCalc{
    int a;
    int b;
    int c;

    public float findX() {
        return (float) ((c - b) / a);
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of a: ");
        a = sc.nextInt();
        System.out.print("Enter the value of b: ");
        b = sc.nextInt();
        System.out.print("Enter the value of c: ");
        c = sc.nextInt();
    }

}
public class AlgebraCalculator{
    public static void main(String[] args){
        AlgebraCalc calc = new AlgebraCalc();
        calc.input();
        System.out.println(calc.findX());
    }
}
