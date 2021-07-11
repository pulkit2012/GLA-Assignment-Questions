
import java.util.Scanner;

public class AsciiSubsequence {
    static int counter = 0;

    static void asciiSubSequences(String str, String curr, int i) {
        if (i == str.length()) {
            if (curr.length() > 0) {
                System.out.print(curr + " ");
                counter++;
            }
            return;
        }
        char ch = str.charAt(i);
        asciiSubSequences(str, curr, i + 1);
        asciiSubSequences(str, curr + ch, i + 1);
        asciiSubSequences(str, curr + (int) ch, i + 1);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        System.out.print(" ");
        asciiSubSequences(str, "", 0);
        System.out.println("\n" + (counter + 1));
    }
}
