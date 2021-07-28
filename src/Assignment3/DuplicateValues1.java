package Assignment3;

import java.util.HashSet;
import java.util.Scanner;

public class DuplicateValues1 {
    static boolean dupliChecker(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])){
                return true;
            }
            else {
                set.add(arr[i]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(dupliChecker(arr));
    }
}
