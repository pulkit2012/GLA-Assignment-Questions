package Assignment3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Histogram {
    static void largestRectCalc(int[] heights){
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        //calculating min left
        stack.push(0);
        left[0] = 0;
        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                left[i] = stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        stack.clear();
        //calculating min Right
        right[heights.length-1] = heights.length - 1;
        stack.push(heights.length-1);
        for (int i = heights.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                right[i] = stack.pop();
            }
            right[i] = stack.isEmpty() ? heights.length - 1 : stack.peek() - 1;
            stack.push(i);
        }
        long maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            long area = (long) heights[i] * (right[i] - left[i] + 1);
            maxArea = Math.max(area,maxArea);
        }
        System.out.println(maxArea);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        int[] heights = new int[len];
        for (int i = 0; i < len; i++) {
            heights[i] = in.nextInt();
        }
        largestRectCalc(heights);
    }
}
