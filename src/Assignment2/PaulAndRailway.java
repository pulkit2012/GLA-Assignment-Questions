package Assignment2;

import java.util.Arrays;
import java.util.Scanner;

public class PaulAndRailway {
    static int track(int[] n, int[] m, int l1, int l2, int[][] dp){
        if(l1 == 0 || l2 == 0){
            return 0;
        }
        if(dp[l1][l2] != -1){
            return dp[l1][l2];
        }
        if(n[l1-1] == m[l2-1]){
            return dp[l1][l2] = 1 + track(n,m,l1-1,l2-1,dp);
        }
        else {
            int c1 = track(n,m,l1,l2-1,dp);
            int c2 = track(n,m,l1-1,l2,dp);
            return dp[l1][l2] = Math.max(c1,c2);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        int[] nArr = new int[n];
        int[] mArr = new int[m];
        for (int i = 0; i < n; i++) {
            nArr[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            mArr[i] = in.nextInt();
        }
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(track(nArr,mArr,n,m,dp));
    }
}
