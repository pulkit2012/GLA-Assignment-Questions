import java.util.Scanner;

public class AllIndices {
    static int[] allIndicesReturner(int[] arr, int x, int index) {
        if (index == arr.length) {
            return new int[0];
        }
        int[] tempArr = allIndicesReturner(arr, x, index + 1);
        if (arr[index] == x) {
            int[] thisAns = new int[tempArr.length + 1];
            thisAns[0] = index;
            for (int i = 0; i < tempArr.length; i++) {
                thisAns[i + 1] = tempArr[i];
            }
            return thisAns;
        } else {
            return tempArr;
        }
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
        int compare = in.nextInt();
        int[] printArr = allIndicesReturner(arr,compare,0);
        for (int i : printArr){
            System.out.print(i + " ");
        }
    }
}
