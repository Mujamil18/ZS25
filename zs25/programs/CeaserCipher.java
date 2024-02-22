package com.zs25.programs;

public class CeaserCipher {
    public static void main(String[] args) {
        CeaserCipher ceaCip = new CeaserCipher();
        System.out.println(ceaCip.encryption("abcdefgh"));

    }
    public String encryption(String text){
        int n = 2, numTemp;
        String encryptedText = "";
        for(int i=0; i<text.length(); i++){
            if(i < n){
                System.out.println(i +" "+(int) text.charAt(i));
                numTemp = (text.charAt(i) + 26) - n ;
                System.out.println(numTemp);
                encryptedText += (char) numTemp;
            }
            else {
                numTemp = text.charAt(i) - n;
                encryptedText += (char) numTemp;
            }
        }
        return encryptedText;
    }
}
