package Assignment3;

import java.util.HashMap;
import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int temp = in.nextInt();
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        for(int c : map.keySet()){
            if(map.get(c) > (len/2)){
                System.out.println(c);
            }
        }
    }
}
