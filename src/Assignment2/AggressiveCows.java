package Assignment2;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    static boolean isPossible(int[] arr, int d, int cows){
        int pre = arr[0];
        int c = 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] - pre >= d){
                pre = arr[i];
                c++;
                if(c == cows){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int stalls = in.nextInt();
        int cows = in.nextInt();
        in.nextLine();
        int[] arr = new int[stalls];
        for (int i = 0; i < stalls; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int low = 0, high = arr[stalls-1],mid, max = -1;
        while (low < high){
            mid = (low + high)/2;
            if(isPossible(arr,mid,cows)){
                if(max < mid){
                    max = mid;
                }
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        System.out.println(max);
    }
}
