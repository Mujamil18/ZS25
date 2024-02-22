package com.zs25.programs;

public class StringTest {
//    public static void test(String str) {
//        if (str == null || str.length() == 0) {
//            System.out.println("empty");
//        } else {
//            System.out.println("not empty");
//        }
//    }
    public static void main(String args[]) {
//        test(null);
        String str = "mujamil";
        System.out.println(str.hashCode());
        String str1 = "mujamil";
        str = "hello";
        System.out.println(str1.hashCode());
        System.out.println(str.hashCode());

//        String str = "welcome";
//        str.toUpperCase();
//        String s1 = str.replace('C', 'c');
//        s1 = s1 + " to Java";
//        System.out.println(s1);
//       int[] arr = {11, 12, 15, 14, 13};
//       int[] arr1 = arr;
//       arr = new int[3];
//       for(int i=0; i<arr.length; i++){
//           System.out.println(arr1[i]);
//       }
//        int position = Arrays.binarySearch(arr, 15);
//        System.out.println(position);

//        String[] cities = new String[]{"London", "Paris", "Newyork"};
//        String[] metros = new String[]{"London", "Paris", "Newyork"};
//        String[] capitals = cities;
//        System.out.println(cities.equals(capitals));
//        System.out.println(cities == metros);
//        System.out.println(Arrays.equals(cities, metros));
//        String s1 = new String("java");
//        String s2 = new String("java");
//        System.out.println(s2.compareTo(s1));
//        float number = 50f;
//        System.out.println(number);
        // String s1 = "Hello";
        // s1 = s1+2;
        // System.out.println(s1);
        // int number = 04;
        // int number2 = 4;
        // System.out.println(number==number2);

        //   String date = "26-07-2023";
        //   String date1 = date.replaceAll("-",".");
        //   System.out.println(date1);
        //   String date2 = date1.replace(".","/");
        //   System.out.println(date2);
        // String str = ".abcd.ghij.abcd.";
        // String str2 = str.replace("abcd", "0");
        // System.out.println(str2);
        // String myString = "   Horse         Cow\n\n   \r Camel \t\t Sheep \n Goat        ";
        // String regex = "\\s";
        // String replacement = "";
        // String newString = myString.replaceAll(regex, replacement);
        // System.out.println(newString);
    }
}
