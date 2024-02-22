package com.zs25.programs;

import java.util.Arrays;

public class ArraySet {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,2, 3, 4};
        Set setA = new Set(new int[]{1, 2, 3, 4, 5, 7});
        Set setB = new Set(new int[]{6, 9, 4, 2, 5});
        setA.union(setB);
//        Set setA = new Set();
//        System.out.println(setA.getClass());
//        setA.union(new int[]{23, 56, 78, 70}, new int[]{20, 50, 78, 95});
//        Set[] set = {setA, setB};
    }
}
class Set{
    int[] data;
    public Set(){
        this.data = new int[]{1, 2, 3, 4, 5, 6, 7};
    }
    public Set(int[] data){
        this.data = data;
    }
    public String toString(){
        String res = "";
        if(data != null || data.length > 0) {
            for (int i = 0; i < data.length; i++) {
                res = "[ ";
                if (i != data.length - 1) {
                    res += data[i] + ", ";
                } else {
                    res += data[i] + " ]";
                }
            }
        }
        else{
            res = "[]";
        }
        return res;
    }
    public void union(Set obj){
        int temp;
        int[] finalArray;
        int[] arr = new int[data.length + obj.data.length];
        for(int i=0, j=0; i<arr.length; i++, j++){
            temp = (j < data.length) ? data[j] : obj.data[j - data.length];
            if(!isExists(arr, temp)) {
                arr[i] = temp;
            }
        }
//        System.out.println("After union of two sets, the array will be: ");
//        System.out.println(Arrays.toString(arr));
        finalArray = removeZeros(arr);
        System.out.println("Final output: ");
        System.out.println(Arrays.toString(finalArray));
    }
    public int[] removeZeros(int[] arr){
        int j=0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
//                arr[j++]  =  arr[i];
                j++;
            }
        }
        System.out.println(j);
        System.out.println(Arrays.toString(arr));
        int[] finalArray = new int[j];
        for(int i=0; i<finalArray.length; i++){
            finalArray[i] = arr[i];
        }
        return finalArray;

    }
    public boolean isExists(int[] arr, int value){
        boolean isThere = false;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == value){
                isThere = true;
                break;
            }
        }
        return isThere;
    }
    public void intersection(Set obj){
        int j=0, size=0;
       for(int i=0; i<data.length; i++){
           if(data[i] == obj.data[j]){
               size++;
           }
           else{
               continue;
           }
           j++;
       }
       int[] newArray = new int[size];

    }
}
