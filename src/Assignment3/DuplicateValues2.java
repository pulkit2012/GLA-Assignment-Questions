package Assignment3;

import java.util.*;

public class DuplicateValues2 {
    static boolean dupliChecker2(int[] arr, int n, int target){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])){
                for (int k : map.get(arr[i])){
                    if(Math.abs(k - i) <= target){
                        return true;
                    }
                }
                map.get(arr[i]).add(i);
            }
            else {
                map.put(arr[i],new ArrayList<>());
                map.get(arr[i]).add(i);
            }
        }
        return false;
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
        System.out.println(dupliChecker2(arr,len,target));
    }
}
