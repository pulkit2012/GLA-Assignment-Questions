package Assignment3;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
     static void nextGreater(int[] arr)
    {
        Stack<Integer> stack = new Stack<>();
        int temp[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--)
        {
            if (!stack.empty())
            {
                while (!stack.empty() && stack.peek() <= arr[i])
                {
                    stack.pop();
                }
            }
            temp[i] = stack.empty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "," + temp[i]);
        }
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
            nextGreater(arr);
            test--;
        }
    }
}
