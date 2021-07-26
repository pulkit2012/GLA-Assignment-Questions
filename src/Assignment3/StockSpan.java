package Assignment3;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    static void stockSpanCalc(int[] stock){
        int[] span = new int[stock.length];
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);
        for (int i = 1; i < stock.length; i++) {
            while (!stack.isEmpty() && stock[stack.peek()] <= stock[i]){
                stack.pop();
            }
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        for(int i : span){
            System.out.print(i + " ");
        }
        System.out.print("END");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        int[] stock = new int[len];
        for (int i = 0; i < len; i++) {
            stock[i] = in.nextInt();
        }
        stockSpanCalc(stock);

    }
}
