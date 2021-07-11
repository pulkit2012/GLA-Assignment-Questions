import java.util.Scanner;

public class AliceTeacher {
    public static int assign(int n){
        if(n==1 || n==2)
            return(n+1);
        else
            return(assign(n-1)+assign(n-2));
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++){
            int k=sc.nextInt();
            int j=assign(k);
            System.out.println("#"+i+" : "+j);
        }
    }
}
//Warning-------------------this code is copied!!!!!!!!!!!!!
