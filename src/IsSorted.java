import java.util.*;

public class IsSorted {
    static boolean isSorted(int[] arr, int i){
        if(i == 1 || i == 0){
            return true;
        }
        if(arr[i-1] < arr[i-2]){
            return false;
        }
        return isSorted(arr,i-1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(isSorted(arr,arr.length));
    }
}
class test{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        while (a > 0){
            int n = in.nextInt();
            int k = in.nextInt();
            in.nextLine();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            int counter = 0;
            int sum = 0;
            int temp = 0;
            for (int i = n-1; i >= 0; i--) {
                if(temp == arr[i]){
                    sum += arr[i];
                }
                else if(counter == k){
                    break;
                }
                else {
                    temp = arr[i];
                    counter++;
                    sum += arr[i];
                }
            }
            System.out.println(sum);
            a--;
        }
    }
}
