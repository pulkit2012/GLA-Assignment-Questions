package Assignment3;

import java.util.Scanner;
import java.util.Stack;

public class FormMinNumberofSequence {
    static void seqGen(String str){
        String result = "";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= str.length(); i++) {
            stack.push(i + 1);
            if(i == str.length() || str.charAt(i) == 'I'){
                while (!stack.isEmpty()){
                    result += String.valueOf(stack.peek());
                    stack.pop();
                }
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        String[] arr = in.nextLine().split(" ");
        for(String a : arr){
            seqGen(a);
        }
    }
}
