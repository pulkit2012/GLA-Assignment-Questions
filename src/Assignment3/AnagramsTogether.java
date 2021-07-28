package Assignment3;

import java.util.*;

public class AnagramsTogether {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String input = in.nextLine();
            char[] arr = input.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);
            if(map.containsKey(temp)){
                map.get(temp).add(input);
            }
            else {
                map.put(temp,new ArrayList<>());
                map.get(temp).add(input);
            }
        }
        for (List<String> c : map.values()){
            for(String a : c){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
