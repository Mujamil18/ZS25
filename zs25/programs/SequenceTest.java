package com.zs25.programs;

public class SequenceTest {
    public static void main(String[] args){
        Sequences seq = new Sequences();
        seq.definiteNumber = 3;
        seq.arithmeticSequence();
        seq.geometricSequence();

    }
}
class Sequences{
    int definiteNumber;
    public void arithmeticSequence(){
        int firstN=1;
        String apSeries="";
        apSeries += firstN +", "+ (firstN+definiteNumber)+", "+(firstN+2*definiteNumber)+", "+(firstN+3*definiteNumber)+" ,....";
//        String apSeries="1";
//        apSeries = apSeries + " + " + (1 + definiteNumber) + " + " +(1 + 2*definiteNumber)+ " ........" ;
        System.out.println("Arithemtic Sequence --> " +apSeries);
    }
    public void geometricSequence(){
        String gpSeries="";
        int firstN = 1;
        gpSeries = firstN+ ", "+(firstN*definiteNumber) +", "+(firstN*definiteNumber*definiteNumber)+",...";
        System.out.println("Geometric Series --> "+ gpSeries);
    }
}

