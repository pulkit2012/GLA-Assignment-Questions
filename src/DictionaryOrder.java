import java.util.*;

public class DictionaryOrder {
    static List<String> stringList = new LinkedList<>();

    static void printCombinations(String str, String ans) {
        if (str.length() == 0) {
            stringList.add(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            printCombinations(remaining, ans + character);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        printCombinations(str, "");
        Collections.sort(stringList);
        for (String i : stringList) {
            if (!i.equals(str)) {
                System.out.println(i);
            }
            else {
                break;
            }
        }
    }
}
