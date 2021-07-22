package Assignment2;

import java.util.Scanner;

public class ZeroNnapsack {
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int dp[][] = new int[n + 1][W + 1];
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        return dp[n][W];
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int total = in.nextInt();
        in.nextLine();
        int[] val = new int[len];
        int[] cap = new int[len];
        for (int i = 0; i < len; i++) {
            cap[i] = in.nextInt();
        }
        in.nextLine();
        for (int i = 0; i < len; i++) {
            val[i] = in.nextInt();
        }
        System.out.println(knapSack(total,cap,val,len));
    }
}
