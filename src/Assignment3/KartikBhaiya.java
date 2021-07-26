package Assignment3;

import java.util.Scanner;
import java.util.Stack;

public class KartikBhaiya {
    static int celebChecker(int[][] arr, int n){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1){
            int a = stack.pop();
            int b = stack.pop();
            if(arr[a][b] == 1){
                stack.push(b);
            }else {
                stack.push(a);
            }
        }
        if(stack.isEmpty()){
            return -1;
        }
        int temp = stack.pop();
        for (int i = 0; i < n; i++) {
            if(i != temp && ((arr[temp][i] == 1) || !(arr[i][temp] == 1))){
                return -1;
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                arr[i][i1] = in.nextInt();
            }
        }
        int ans = celebChecker(arr,n);
        System.out.println(ans == -1 ? "No Celebrity" : ans);
    }
}
