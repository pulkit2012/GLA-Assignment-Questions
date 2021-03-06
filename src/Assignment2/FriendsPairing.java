package Assignment2;

import java.util.Scanner;

public class FriendsPairing {
    static long countFriendsPairings(int n)
    {
        long dp[] = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 2)
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        in.nextLine();
        while (a > 0){
            int b = in.nextInt();
            System.out.println(countFriendsPairings(b));
            a--;
        }
    }
}
