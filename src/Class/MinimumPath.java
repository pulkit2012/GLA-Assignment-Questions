package Class;

import java.util.Scanner;

public class MinimumPath {
    static int solution(int[][] arr, int cr, int cc, int fr, int fc){
        if(cr > fr || cc > fc){
            return Integer.MAX_VALUE;
        }
        if(cr == fr && cc == fc){
            return arr[cr][cc];
        }
        int c1 = solution(arr,cr,cc+1,fr,fc);
        int c2 = solution(arr,cr+1,cc,fr,fc);
        int minAns = Math.min(c1,c2);
        return arr[cr][cc] + minAns;
    }
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int[][] arr = {{}};
        int cr = arr.length;
        int cc = arr[0].length;
    }
}
