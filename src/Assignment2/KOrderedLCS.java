package Assignment2;


import java.util.Scanner;

public class KOrderedLCS {
    public static long korderedLCS(int[] a, int[] b, int i, int j, int k, long[][][] dp) {
        if (a.length == i || b.length == j) {
            return 0;
        }
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        long res = 0;
        if (a[i] == b[j]) {
            res = 1 + korderedLCS(a, b, i + 1, j + 1, k, dp);
        } else {
            if (k > 0) {
                res = 1 + korderedLCS(a, b, i + 1, j + 1, k - 1, dp);
            }

            res = Math.max(res, korderedLCS(a, b, i + 1, j, k, dp));
            res = Math.max(res, korderedLCS(a, b, i, j + 1, k, dp));
        }
        dp[i][j][k] = res;
        return res;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        int[] arr1 = new int[m];
        long[][][] dp = new long[n + 1][m + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int z = 0; z <= k; z++) {
                    dp[i][j][z] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr1[i] = kb.nextInt();
        }
        long a = korderedLCS(arr, arr1, 0, 0, k, dp);
        System.out.println(a);
    }
}
