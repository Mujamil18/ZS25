package com.zs25.programs;
/* Packages and classes you import should go on the top of the program (outside the class) */


/* Defining class must start with 'class' keyword followed by classname.
    (which is defined by the user, and it should be meaningful for what that class going to do).
    public is the access modifier here.

    (This program is to let you know about the structure, naming conventions and
     proper coding of a java program, so here the classname is CodeConventions)
 */
public class CodeConventions {
    /* main method is the entry point to a java program
       A method name should start with lower case.

       If the method has two or more names,only the first word should start with lower case
       and the remaining word must start with Upper Case.
     */
    public static void main(String[] args){
        /* Creating objects and invoking/calling methods goes here */
        /* To access the members (variables and methods) of a class, we should create object */
        NumberSystem number = new NumberSystem(); //creating object
        //number is the object of NumberSystem class
        /* If you want a method to be executed, you must the call the method */
        number.setIntegerNumber();
        number.printIntegerNumber();
        number.setLongNumber();
        number.printLongNumber();

    }
}
class NumberSystem{
    /* A variable should be declared before accessing (Since Java is Statically Typed Language) */

    /* The variables declared here are GLOBAL VARIABLES
     (which is accessible in all the methods in the class). */
    int integerNumber;
    byte byteNumber;
    short shortNumber;
    long longNumber;
    boolean bool;

    public void setIntegerNumber(){
        integerNumber = 324765346;
    }
    //this method prints the integer number
    public void printIntegerNumber(){
        System.out.println("The integer number is "+ integerNumber);
    }
    //this method sets value for longNumber
    public void setLongNumber(){
        longNumber = 987654321012345678L;
    }
    //this method prints the long number
    public void printLongNumber(){
        System.out.println("The Long Number is "+ longNumber);
        System.out.println("Boolean "+ bool);
    }

}
