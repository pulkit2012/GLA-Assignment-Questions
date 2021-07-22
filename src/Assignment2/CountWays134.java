package Assignment2;

import java.util.Scanner;

public class CountWays134 {
    static long countWays(int n)
    {
        long DP[] = new long[n + 1];
        DP[0] = DP[1] = DP[2] = 1;
        DP[3] = 2;
        for (int i = 4; i <= n; i++)
            DP[i] = DP[i - 1] + DP[i - 3] + DP[i - 4];
        return DP[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(countWays(a));

    }
}
