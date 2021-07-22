package Assignment2;

import java.util.Scanner;

public class CountNumberBinaryStrings {
    static long countStrings(int n)
    {
        long a[] = new long[n];
        long b[] = new long[n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++)
        {
            a[i] = a[i-1] + b[i-1];
            b[i] = a[i-1];
        }
        return a[n-1] + b[n-1];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        in.nextLine();
        while (test > 0){
            int n = in.nextInt();
            System.out.println(countStrings(n));
            test--;
        }
    }
}
