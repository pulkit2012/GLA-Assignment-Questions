import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RecursionKeyPad {
    static ArrayList<String> list = new ArrayList<>();
    static int counter = 0;
    static void combinations(int num,String[] keys, String word){
        if(num == 0){
            list.add(word);
            counter++;
        }
        String temp = keys[num % 10];
        for (int i = 0; i < temp.length(); i++) {
            combinations(num/10,keys,temp.charAt(i) + word);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String[] keys = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wx","yz"};
        combinations(num,keys,"");
        Collections.sort(list);
        for(String i : list){
            System.out.print(i + " ");
        }
        System.out.println("\n" + counter);
    }
}
