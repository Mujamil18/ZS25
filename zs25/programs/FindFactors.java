package com.zs25.programs;

public class FindFactors {
    public static void main(String[] args) {
        FindFactors findObj = new FindFactors();
        long n = 10000;
        long number = 2 * n * n;
        System.out.println("Number: " +number + " n: "+ n);
        System.out.println("f(n) = " +findObj.findFactorsOfNumber(number, n));
        System.out.println("F(N) = "+ findObj.findCountOfFactors(n));


    }
    public long findFactorsOfNumber(long num, long n){
        long count=0;
        for(int i=1; i <= num; i++){
            if(num % i == 0 && i <= n) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println();
        return count;
    }
    public long findCountOfFactors(long n){
        long count=0;
        for(int i=1; i<=n; i++){
            System.out.print((2 * i * i) + " ");
            System.out.print("Factors: ");
            for(int j =1; j<=i; j++){
                if((2 * i * i) % j == 0) {
                    System.out.print(j + " ");
                    count++;

                }
            }
            System.out.println();
        }
        return count;
    }
}
