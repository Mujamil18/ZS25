package com.zs25.programs;

public class EqualBraces {
    public static void main(String[] args) {
        String str = "(()))))(";
        EqualBraces obj = new EqualBraces();
        obj.checkEqualBraces(str);

    }
    public void checkEqualBraces(String str){
        int openBracesCount=0;
        int closeBracesCount =0;
        if(str.startsWith("(")) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    openBracesCount++;
                } else if (str.charAt(i) == ')') {
                    closeBracesCount++;
                    if (openBracesCount == closeBracesCount) {
                        System.out.println(i+1);
                        break;
                    }
                }
            }
        }
        else {
            System.out.println("Invalid");
        }
    }
}
