package com.zs25.programs;

public class ZohoSchools {
    private static int studentCount =0;
    private static int locationCount=0;
    String schoolLocation;
    public ZohoSchools(String location){
        schoolLocation = location;
        locationCount++;
    }
    public Student joinStudent(String stName, String schName){
        Student student = new Student(stName, schName);
        studentCount++;
        return student;
    }

    public static void main(String[] args) {
        ZohoSchools zsChennai = new ZohoSchools("Chennai");
        ZohoSchools zsTenkasi = new ZohoSchools("Tenkasi");

//        Student s1 = zsChennai.joinStudent(1);
//        Student s1 = zsChennai.joinStudent("abcd", "tech");
//        Student s2 =  zsTenkasi.joinStudent("xyz", "tech");
//        Student s3 = zsChennai.joinStudent("mno", "design");
//
//        System.out.println(s1.getStudentName()+ " " + s1.getSchoolName());
//        System.out.println(s2.getStudentName()+ " "+s2.getSchoolName());
//        System.out.println(s3.getStudentName()+ " "+s3.getSchoolName());

        System.out.println("No. of Students: "+ studentCount);
        System.out.println("No. of Locations: "+locationCount);
    }

}
class Student{
    String schoolName;
    String studentName;
    int studentId;
    public Student(int stId){
        studentId = stId;
    }
    public int getStudentId(){
        return studentId;
    }
    public Student(String stName , String schName){
        schoolName = schName;
        studentName = stName;
    }
    public String getSchoolName(){
        return schoolName;
    }
    public String getStudentName(){
        return studentName;
    }
}
