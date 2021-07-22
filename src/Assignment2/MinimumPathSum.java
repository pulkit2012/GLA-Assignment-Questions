package Assignment2;

import java.util.Scanner;

public class MinimumPathSum {
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
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        in.nextLine();
        int[][] arr = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int i1 = 0; i1 < b; i1++) {
                arr[i][i1] = in.nextInt();
            }
        }
        System.out.println(solution(arr,0,0,a-1,b-1));

    }
}
