package Assignment3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PrateekSirAndCoding {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        in.nextLine();
        Stack<String> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        while (queries > 0){
            String[] arr = in.nextLine().split(" ");
            if(Integer.parseInt(arr[0]) == 2) {
                stack.push(arr[1]);
            }else {
                System.out.println(stack.isEmpty() ? "No Code" : stack.pop());
            }
            queries--;
        }
    }
}
