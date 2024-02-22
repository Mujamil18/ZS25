package com.zs25.concepts;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ExceptionDemo {
    public static void main(String[] args) {

    }
}
class ListOfNumber{
    private List<Integer> list;
    private static final int SIZE = 10;

    ListOfNumber(){
        list = new ArrayList<>(SIZE);
        for(int i=0; i<SIZE; i++){
            list.add(new Integer(i));
        }
    }

    public void writeListToFile(){
        PrintWriter pw = null;
        try {
            System.out.println("Entered try statement");
            FileWriter fw = new FileWriter("listToFile.txt");
            pw = new PrintWriter(fw);

            for (int i = 0; i < SIZE; i++) {
                pw.println(list.get(i));
            }
        }
        catch(IndexOutOfBoundsException ie){
            System.err.println(ie.getMessage());
        }
        catch(IOException ioe){
            System.err.println(ioe.getMessage());
        }
        pw.close();
    }
}
