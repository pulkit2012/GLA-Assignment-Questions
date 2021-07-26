package Assignment3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class FindGreaterElement {
    static void nestGreaterCircular(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        while (i < n*2){
            while (!stack.isEmpty() && arr[i % n] > stack.peek()){
                map.put(stack.pop(), arr[i % n]);
            }
            stack.push(arr[i % n]);
            i++;
        }
        for (int i1 = 0; i1 < arr.length; i1++) {
            System.out.print(map.getOrDefault(arr[i1],-1) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
    nestGreaterCircular(arr);
    }
}
