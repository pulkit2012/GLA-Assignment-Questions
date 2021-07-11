import java.util.Scanner;

public class FirstIndex {
    static int firstIndexReturner(int[] arr, int n, int index){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == n){
            return index;
        }
        return firstIndexReturner(arr,n,index+1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        int find = in.nextInt();
        System.out.println(firstIndexReturner(arr,find,0));
    }
}
