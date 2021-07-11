import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SubSequences {
    static ArrayList<String> list = new ArrayList<>();
    static void subSequences(String str,String curr){
       if(str.length() == 0){
           list.add(curr);
           return;
       }
       subSequences(str.substring(1),curr+str.charAt(0));
       subSequences(str.substring(1),curr);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        subSequences(str,"");
        Collections.reverse(list);
        for(String i : list){
            System.out.print(i + " ");
        }
        System.out.println("\n" + list.size());
    }
}
