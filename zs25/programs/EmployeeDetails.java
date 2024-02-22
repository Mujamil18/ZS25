package com.zs25.programs;
 // program did on Aug 21st
class Employee {
     private String empName;
     private int empId;
     private int empSalary;
     private String empMailId;

     public void setEmpName(String name) {
         empName = name;
     }

     public String getEmpName() {
         return empName;
     }

     public void setEmpId(int id) {
         empId = id;
     }

     public int getEmpId() {
         return empId;
     }

     public void setEmpSalary(int salary) {
         empSalary = salary;
     }

     public int getEmpSalary() {
         return empSalary;
     }

     public void setEmpMailId(String mailId) {
         empMailId = mailId;
     }

     public String getEmpMailId() {
         return empMailId;
     }
//    Team team;
     public Employee(){
         empName = "John";
         empId = 25;
         empSalary = 20000;
         empMailId = "john@xyz.com";
         System.out.println("Default Constructor");
     }
//     public Employee(String name, int id){
//         empName = name;
//         empId = id;
//         empSalary = 20000;
//     }
     public Employee(String name, int id, int salary){
         empName = name;
         empId = id;
         empSalary = salary;
     }
 }
 public class EmployeeDetails{
     public static void main(String[] args) {
         Employee emp1 = new Employee();
     }
}
