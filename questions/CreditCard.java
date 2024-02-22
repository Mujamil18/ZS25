package com.daily.questions;

public class CreditCard implements PaymentApplication {
    private String cardNumber;
    private String expiryDate;

    CreditCard(String cardNumber, String expiryDate){
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }
    public boolean processPayment(double amount){
        boolean paymentProcessed;
        if((this.cardNumber != null && this.cardNumber.length() == 12) &&
                (this.expiryDate != null && this.expiryDate.length() == 5)){
            paymentProcessed = true;
        }
        else{
            System.out.println("Payment not processed. Check your card number and expiry date.");
            paymentProcessed = false;

        }
        return paymentProcessed;
    }
}
