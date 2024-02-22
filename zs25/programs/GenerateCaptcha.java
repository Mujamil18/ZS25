package com.zs25.programs;

import java.util.Random;

public class GenerateCaptcha {
    public static void main(String[] args) {
        CaptchaGenerator capGen = new CaptchaGenerator();
        String captcha = capGen.generateCaptcha();
        System.out.println(captcha);
    }
}
class CaptchaGenerator {
    String alphaNumeric = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVSXYZ";

    public int generateLength(){
        return new Random().nextInt(7-4)+4;
    }
    public int generateIndex(){
        return new Random().nextInt(alphaNumeric.length());
    }
    public String generateCaptcha(){
        String captcha = "";
        int length = generateLength();
        int index;
        for(int i=0; i<length; i++){
            index = generateIndex();
            captcha += alphaNumeric.charAt(index);
        }
        System.out.println("Length: "+length);
        return captcha;
    }
}
