package special.programs;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[] arr = new int[]{4, 3, 2, 1};
        int resultNum = po.makeArrayPlusOne(arr);
        int[] resultArr = po.numToArray(resultNum, arr.length);
        for(int i : resultArr){
            System.out.print(i + " ");
        }
    }
    public int makeArrayPlusOne(int[] arr){
        int num = 0;
        for(int i=0; i<arr.length; i++){
            num = (num * 10) +arr[i];
        }
        return num+1;
    }
    public int[] numToArray(int num, int len){
        int rem =0;
        int[] arr = new int[len];
        int i = len;
        while(num > 0){
            rem = num % 10;
            arr[--len] = rem;
            num /= 10;
        }
        return arr;
    }
}
