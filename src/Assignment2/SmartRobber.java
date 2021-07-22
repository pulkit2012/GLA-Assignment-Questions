package Assignment2;

import java.util.Scanner;

public class SmartRobber {
    static int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp =new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=1;i<nums.length;i++) {
            dp[i+1] = Math.max(dp[i], nums[i]+dp[i-1]);
        }
        return dp[nums.length];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        in.nextLine();
        while (test > 0){
            int len = in.nextInt();
            in.nextLine();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(rob(arr));
            test--;
        }
    }
}
