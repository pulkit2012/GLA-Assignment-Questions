import java.util.Scanner;

public class SmartKeyPad {
    static void combinations(String num, String[] keys, String word) {
        if (num.length() == 0) {
            System.out.println(word);
            return;
        }
        char ch = num.charAt(0);
        String temp = num.substring(1);
        String code = keys[ch - '0'];
        for (int i = 0; i < code.length(); i++) {
            combinations(temp, keys, word + code.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        String[] keys = {" ", ".+@$", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combinations(num, keys, "");
    }
}
