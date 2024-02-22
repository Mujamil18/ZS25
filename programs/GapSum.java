package special.programs;

import java.util.Scanner;

public class GapSum
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size");
        int n= in.nextInt();
        int[] arr= new int[n];
        int gap, sum;
        System.out.println("Enter the Gap");
        gap = in.nextInt();

        System.out.println("Enter the elements");
        for(int k=0; k<n; k++)
        {
            arr[k]= in.nextInt();
        }

        for(int i=0; i<gap; i++)
        {
            sum=0;
//           System.out.println("The sum is ");
            int size=0;
            int newArr[];
            for(int j=i; j<n; j=j+gap)
            {

                System.out.println(arr[j]);
                sum = sum + arr[j];
            }
            System.out.println(sum);
        }
    }
}