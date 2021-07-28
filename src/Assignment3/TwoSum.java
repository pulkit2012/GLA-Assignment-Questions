package Assignment3;


import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    static int[] targetGetter(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff) + 1,i + 1};
            }
            map.put(arr[i],i);
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        int target = in.nextInt();
        int[] ans = targetGetter(arr,target);
        if(ans == null){
            System.out.print("");
        }
        else {
            for (int c : ans) {
                System.out.print(c + " ");
            }
        }
    }
}
