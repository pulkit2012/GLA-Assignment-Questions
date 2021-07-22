package Assignment2;

import java.util.Scanner;

public class UnboundedKnapsack {
    private static int unboundedKnapsack(int W, int n, int[] val, int[] wt)
    {
        int dp[] = new int[W + 1];
        for(int i = 0; i <= W; i++){
            for(int j = 0; j < n; j++){
                if(wt[j] <= i){
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        return dp[W];
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
        System.out.println(unboundedKnapsack(total,len,val,cap));
    }
}
