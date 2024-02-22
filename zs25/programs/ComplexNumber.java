package com.zs25.programs;

public class ComplexNumber {
    private double real;
    private double imaginary;
    ComplexNumber(){
        real = 5;
        imaginary = 5;
    }
    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    public ComplexNumber add(ComplexNumber complex){
        double realTemp = this.real + complex.real;
        double imgTemp = this.imaginary + complex.imaginary;

        return new ComplexNumber(realTemp, imgTemp);
    }
    public ComplexNumber subtract(ComplexNumber complex){
        double realTemp = this.real - complex.real;
        double imgTemp = this.imaginary - complex.imaginary;
        return new ComplexNumber(realTemp, imgTemp);
    }
    public ComplexNumber multiply(ComplexNumber complex){
        double tempReal1 = this.real * complex.real;
        double tempReal2 = (this.imaginary * complex.imaginary)*(-1);

        double tempImg1 = this.real * complex.imaginary;
        double tempImg2 = this.imaginary * complex.real;

        double realTemp = tempReal1 + tempReal2;
        double imgTemp = tempImg1 + tempImg2;
//        tempResult += (this.real * real1) + (tempImg1)+"i"+(tempImg2)+"i"+ (this.imaginary * imaginary1)*(-1);
        return new ComplexNumber(realTemp, imgTemp);
    }
    @Override
    public String toString(){
        String str = "";
        if(this.real != 0 && this.imaginary != 0) {
            str += this.real + " + i" + this.imaginary;
        }
        else{
            return "error";
        }
        return str;
    }

    public static void main(String[] args) {
        ComplexNumber comNum1 = new ComplexNumber(5, 10);
        ComplexNumber comNum2 = new ComplexNumber(2, 3);
        System.out.println("Addition: "+ comNum1.add(comNum2));
        System.out.println("Subtraction: " + comNum1.subtract(comNum2));
        System.out.println("Multiplication: " + comNum1.multiply(comNum2));
    }

}
