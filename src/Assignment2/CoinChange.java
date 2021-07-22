package Assignment2;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    static long countWays(int arr[], int m, int n)
    {
        long[] table = new long[n+1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for (int i=0; i<m; i++)
            for (int j=arr[i]; j<=n; j++)
                table[j] += table[j-arr[i]];

        return table[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int len = in.nextInt();
        in.nextLine();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(countWays(arr,len,total));

    }
}
