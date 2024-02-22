package com.zs25.programs;

public class DatatypesDemo {
    public static void main(String[] args) {
        DatatypesDemo test = new DatatypesDemo();
        test.print(10);




    }
    public int print(int n){
        if(n==0){
            return 0;
        }
        else{
            System.out.println(n);
            return print(--n);
        }
    }

//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        sc.nextLine();
//        String numbers = sc.nextLine();
//        System.out.println(numbers);
//        System.out.println(num);


//        for (int i = 1; i <= 10; i++) {
//            if (i % 2 == 0) {
//                System.out.println("Even");
//            } else {
//                System.out.println("Odd");
//            }
//        }
//        Random r = new Random();
//
//        String captcha = "";
//        int length = r.nextInt(7-4)+4;
//        System.out.println(length);

//        int randomNum;
////        for(int i=0; i<length; i++){
////            randomNum = r.nextInt(alphabets.length());
////            captcha += alphabets.charAt(randomNum);
////        }
//        System.out.println(captcha);
//    public int generateLength(){
//
//    }
}
