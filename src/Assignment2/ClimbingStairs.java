package Assignment2;

import java.util.Scanner;

public class ClimbingStairs {
    static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n == 1) return dp[1];
        dp[2] = 2;
        for (int i = 3; i <= n; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(climbStairs(n));
    }
}
