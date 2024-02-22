package com.zs25.programs;
public class StaticTest {
    public static void main(String[] args) {

    }
}
//    public static void main(String[] args) {
//        StaticTest test1 = new StaticTest();
//        StaticTest test2 = new StaticTest();
//        test1.x = 20;
//        System.out.print(test1.x + " ");
//        System.out.print(test2.x + " ");
//
//    }
//}


//    public static void main(String[] args){
//        display();
//    }
//    public static void display(){
//        show(2);
//        show(5);
//    }
//    public void show(int x){
//        System.out.println(x);
//    }


    //    public static void main(String[] args){
//        int x = 20;
//        System.out.println(x);
//    }
//    static{
//        int x = 10;
//        System.out.println(x);
//    }
//}









//public class StaticDemo {
//    public static void main(String[] args) {
//        Student s1 = new Student();
//        s1.displayStudentCount();
//        s1.displaySchoolName();
//
//        Student s2 = new Student();
//        s2.noOfStudents = 87;
//
//        StaticDemo demoObj = new StaticDemo();
//        demoObj.displayStudentDetails();
//
//    }
//    public void displayStudentDetails(){
//        System.out.println(Student.noOfStudents);
//        System.out.println(Student.schoolName);
//    }
//}
//class Student{
//    static int noOfStudents = 100;
//    static String schoolName = "Tech";
//    public void displayStudentCount(){
//        System.out.println(noOfStudents);
//        noOfStudents = 89;
//    }
//    public void displaySchoolName(){
//        System.out.println(schoolName);
//    }
//}

//class HelloWorld {
//    int id =0;
//    static int counter =0;
//    public static void create(){
//        id++;
//        counter++;
//        System.out.println(id + " "+ counter);
//    }
//    public static void main(String[] args) {
//        HelloWorld.create();
//        create();
//        HelloWorld hw = new HelloWorld();
//        hw.create();
//
//    }
//}
