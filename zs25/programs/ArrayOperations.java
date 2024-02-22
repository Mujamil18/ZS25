package com.zs25.programs;

public class ArrayOperations{
    int[] data;
    public ArrayOperations(){
        data = new int[]{1, 2, 3,4};
    }
    public ArrayOperations(int[] data){
        this.data = data;
    }

    public ArrayOperations add(int elementToAdd){
        int[] temp = new int[data.length+1];

        for(int i=0; i<data.length; i++){
            temp[i] = data[i];
        }
        temp[temp.length-1] = elementToAdd;
//        System.out.println(Arrays.toString(temp));
//        ArrayOperations arr = new ArrayOperations(temp);
        return new ArrayOperations(temp);
    }
    public ArrayOperations remove(int indexToRemove){
        int j=0, k=0;
        for(int i=0; i<data.length; i++){
            if(data[i] == indexToRemove){
                data[i] = 0;
            }
            else{
                j++;
            }
        }
        int[] newArray = new int[j];
        for(int i=0; i<data.length; i++){
            if(data[i] != 0){
               newArray[k++] = data[i];
            }
        }
        return new ArrayOperations(newArray);

    }
    public ArrayOperations modify(int indexToModify, int elementToModify){
        for(int i=0; i<data.length; i++){
            if( i == indexToModify){
                data[i] = elementToModify;
            }
        }
        return new ArrayOperations(this.data);

    }
    public String toString(){
        String res = "";
        if(data != null || data.length > 0) {
            res = "[ ";
            for (int i = 0; i < data.length; i++) {
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

    public static void main(String[] args) {
        ArrayOperations arrObj = new ArrayOperations();
        System.out.println("Actual array: "+ arrObj);
        arrObj = arrObj.add(5);
        System.out.println("Array after adding a value: "+arrObj);
        arrObj = arrObj.remove(3);
        System.out.println("Array after removing a value: "+ arrObj);
        arrObj = arrObj.modify(2, 3);
        System.out.println("Array after modifying a value: "+ arrObj);
        arrObj = arrObj.add(4);
        System.out.println("Added some value in array: "+ arrObj);

    }
}

















class User{
    String userName;
    int userId;
    public User(){
       userName = "";
       userId = 0;
    }
    public User(String userName, int userId){
        this.userName = userName;
        this.userId = userId;
    }
//    public String getUserName(){
//        return userName;
//    }
//    public void setUserName(String userName){
//        this.userName = userName;
//    }
//    public int getUserId(){
//        return userId;
//    }
//    public void setUserId(int userId){
//        this.userId = userId;
//    }

}
