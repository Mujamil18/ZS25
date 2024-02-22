package com.daily.questions;

public class PayPal implements PaymentApplication {
    private String mailId;
    PayPal(String mailId){
        this.mailId = mailId;
    }
    public boolean processPayment(double amount){
        boolean paymentProcessed;
        if(this.mailId.contains("@") && this.mailId.contains(".")){
            paymentProcessed = true;
        }
        else{
            System.out.println("Payment not processed. Check your PayPal Id.");
            paymentProcessed = false;
        }
        return paymentProcessed;
    }
}
