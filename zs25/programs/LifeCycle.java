package com.zs25.programs;

public class LifeCycle {
    float age; //age of the person

    //method to find the stage of the person respective to their age
    public String findStage(){
        String stage = "Invalid Age";
        if(age == 0){
            stage = "Foetus";
        }
        else if(age > 0 & age < 2){
            stage = "Infant";
        }
        else if(age > 2 & age < 12){
            stage = "Child";
        }
        else if(age > 12 && age < 20){
            stage = "Teenage";
        }
        else if(age > 20 && age < 60){
            stage = "Adult";
        }
        else if(age > 60 ){
            stage = "Senior Citizen";
        }
        return stage;
    }
    //method to check whether the person has voting eligibility or not
    //return true if eligible , returns false if not
    public boolean voteEligibility(){
        boolean isEligible = false;
        if(age >= 18) {
            isEligible = true;
        }
        return isEligible;
    }
    //method to check whether the person is senior citizen or not
    //return true if senior citizen , returns false if not
    public boolean seniorCitizen(){
        boolean isSenior = false;
        if(age > 60){
            isSenior = true;
        }
        return isSenior;
    }
    //main method
    public static void main(String[] args){
        LifeCycle person = new LifeCycle();
        person.age = 70; //setting value 70 in age variable
        System.out.println("Person is " +person.findStage());
        if(person.voteEligibility()){
            System.out.println("Person is ELIGIBLE to Vote");
        }
        else{
            System.out.println("Person is NOT ELIGIBLE to Vote");
        }
        if(person.seniorCitizen()){
            System.out.println("Person is a Senior Citizen");
        }
        else {
            System.out.println("Person is NOT a Senior Citizen");
        }
    }
}
