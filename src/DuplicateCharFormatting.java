import java.util.Scanner;

public class DuplicateCharFormatting {
    static String stringFormatter(String str, int index){
        if(index + 1 >= str.length()){
            return str;
        }
        if(index+1 < str.length() && str.charAt(index) == str.charAt(index+1)){
            str = str.substring(0,index+1) + "*" + str.substring(index+1);
        }
        return stringFormatter(str,index+1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        System.out.println(stringFormatter(str,0));

    }
}
