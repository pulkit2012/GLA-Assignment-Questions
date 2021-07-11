import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] arr = new int[a];
        for (int i = a-1; i >= 0; i--) {
            arr[i] = in.nextInt();
            in.nextLine();
        }
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
