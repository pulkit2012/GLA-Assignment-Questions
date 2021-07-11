import java.util.Scanner;

public class MoveAllXToEnd {
    static void xToEndMover(String str, int index, int len){
        if(index >= len){
            return;
        }
        char curr = str.charAt(index);
        if(curr != 'x'){
            System.out.print(curr);
        }
        xToEndMover(str,index+1,len);
        if(curr == 'x'){
            System.out.print('x');
        }
        return;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        xToEndMover(str,0,str.length());
    }
}
