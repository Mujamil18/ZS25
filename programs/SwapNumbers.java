package special.programs;

public class SwapNumbers {
    public static void main(String[] args) {
        int a = 2, b = 1;
        if(a > b) {
            b += a -= b;
        }
        else{
            a += b -= a;
        }
        System.out.println(a);
        System.out.println(b);
    }
}
