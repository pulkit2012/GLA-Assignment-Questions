package Assignment2;

import java.util.Scanner;

public class LongestIncSubseq {
    static int longest(int arr[], int n) {
        int dp[] = new int[n];
        int i, j, max = 0;
        for (i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (max < dp[i])
                max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(longest(arr,n));
    }
}
