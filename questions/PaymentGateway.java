package com.daily.questions;

import java.util.Scanner;

public class PaymentGateway {
    public static void main(String[] args) {

        PaymentApplication paymentMode;
        PaymentGateway payment = new PaymentGateway();

        int option;
        boolean isPaymentProcessed;
        String mailId, cardNumber, expiryDate;
        System.out.println("1.CreditCard\n2.PayPal");
        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();
        sc.nextLine();

        if (option == 1) {
            System.out.print("CreditCard number: ");
            cardNumber = sc.nextLine();
            System.out.print("Expiry Date: ");
            expiryDate = sc.nextLine();
            paymentMode = new CreditCard(cardNumber, expiryDate);
            isPaymentProcessed = payment.makePayment(1000.0, paymentMode);
            if(isPaymentProcessed) {
                System.out.println("CreditCard payment successful");
            }
        }
        else if(option == 2){
            System.out.print("PayPal Id: ");
            mailId = sc.nextLine();
            paymentMode = new PayPal(mailId);
            if(payment.makePayment(2000.0, paymentMode)) {
                System.out.println("PayPal payment successful");
            }
        }
        else{
            System.out.println("Invalid option");
        }
    }
    public boolean makePayment(double amount, PaymentApplication paymentApp){
        if(paymentApp.processPayment(amount)){
            System.out.println("Processing payment for the amount " + amount);
            return true;
        }
        return false;
    }
}
