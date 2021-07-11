import java.util.Scanner;

public class ConvertStringToInt {
    static int intConverter(String str){
        if(str.length() == 1){
            return (str.charAt(0) - '0');
        }
        int y = intConverter(str.substring(1));
        int x = str.charAt(0) - '0';
        x =(int)(x * Math.pow(10,str.length()-1) + y);
        return x;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        System.out.println(intConverter(str));
    }
}
