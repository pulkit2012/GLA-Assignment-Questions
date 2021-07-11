import java.util.Scanner;

public class GenerateParanthesis {
    static void parenthesisPrinter(char[] str, int pos, int close, int open, int n){
        if(close == n){
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
            return;
        }
        else {
            if(open > close){
                str[pos] = ')';
                parenthesisPrinter(str,pos+1,close+1,open,n);
            }
            if(open < n){
                str[pos] = '(';
                parenthesisPrinter(str,pos+1,close,open+1,n);
            }
        }
    }
    static void printer(int n){
        char[] str = new char[n*2];
        if(n > 0){
            parenthesisPrinter(str,0,0,0,n);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printer(n);
    }
}
