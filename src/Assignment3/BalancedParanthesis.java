package Assignment3;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {
    static boolean balanceChecker(String str) {
        Stack<Character> stack = new Stack<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            }
            if (stack.empty()) {
                return false;
            }
            char checker;
            switch (current) {
                case ')':
                    checker = stack.pop();
                    if (checker == '{' || checker == '[') {
                        return false;
                    }
                    break;
                case '}':
                    checker = stack.pop();
                    if (checker == '(' || checker == '[') {
                        return false;
                    }
                    break;
                case ']':
                    checker = stack.pop();
                    if (checker == '{' || checker == '(') {
                        return false;
                    }
                    break;
            }
        }
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(balanceChecker(input) ? "Yes": "No");
    }
}
