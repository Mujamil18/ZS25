package special.programs;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        ra.rotateArr(new int[]{1 , 2, 3, 4, 5, 6, 7}, 4);


    }
    public void rotateArr(int[] arr, int n){
        int temp;
        for(int i =0; i<n; i++){
            temp = arr[i];
            for(int j=0; j<arr.length; j++){
                if(j != arr.length - 1) {
                    arr[j] = arr[j + 1];
                }
                else {
                    arr[j] = temp;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
