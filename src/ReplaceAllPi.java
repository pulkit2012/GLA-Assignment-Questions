import java.util.Scanner;

public class ReplaceAllPi {
    static String piRemover(String str, int index){
        if(index + 1 >= str.length()){
            return str;
        }
        if(str.charAt(index) == 'p' && index+1 < str.length() && str.charAt(index+1) == 'i'){
            str = str.substring(0,index) + "3.14" + str.substring(index+2);
        }
        return piRemover(str,index+1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        while (len > 0){
            String str = in.nextLine().trim();
            System.out.println(piRemover(str,0));
            len--;
        }
    }
}
