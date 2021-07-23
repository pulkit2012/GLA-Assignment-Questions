package Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class PainterPArtition {
    public static long getMax(ArrayList<Integer> C, int n){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(C.get(i) > max)
                max = C.get(i);
        }
        return max;
    }

    public static long getSum(ArrayList<Integer> C, int n){
        int total = 0;
        for(int i = 0; i < n; i++){
            total += C.get(i);
        }
        return total;
    }

    public static int getRequiredPainters(ArrayList<Integer> C, int n, int maxLengthPerPainter){
        int total = 0;
        int numPainters = 1;
        for(int i =0;i < n; i++){
            total += C.get(i);
            if(total > maxLengthPerPainter){
                total = C.get(i);
                numPainters++;
            }

        }
        return numPainters;
    }
    public static long partition(ArrayList<Integer> C, int n, int k){
        long lo = getMax(C, n);
        long hi = getSum(C, n);
        while(lo < hi){
            int mid = (int)(lo + (hi-lo)/2);
            int requiredPainters = getRequiredPainters(C, n, mid);
            if(requiredPainters <= k) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    public static int paint(int A, int B, ArrayList<Integer> C) {
        return (int)(partition(C, C.size(), A) * B % 10000003);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(in.nextInt());
        }

        System.out.println(paint(len,k,list));
    }
}
