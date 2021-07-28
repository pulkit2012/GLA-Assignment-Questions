package Assignment3;

import java.util.*;

public class SortGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = in.nextInt();
        in.nextLine();
        int len = in.nextInt();
        in.nextLine();
        TreeMap<Integer, TreeSet<String>> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < len; i++) {
            String[] str = in.nextLine().split(" ");
            int salary = Integer.parseInt(str[1]);
            if(salary >= max) {
                if (map.containsKey(salary)) {
                   map.get(salary).add(str[0]);
                }
                else {
                    map.put(salary,new TreeSet<>());
                    map.get(salary).add(str[0]);
                }
            }
        }
        for(int i : map.keySet()){
            for(String str : map.get(i)){
                System.out.print(str + " " + i);
                System.out.println();
            }
        }
    }
}
