import java.util.Scanner;

public class AliceTeacher {
    static int count = 0;
    public static void classAssignment(int n, String ans) {
        if (ans.length() == n) {
            count++;
            return;
        }
        classAssignment(n, ans + 'a');
        if (ans.length() == 0 || ans.charAt(ans.length() - 1) != 'b') {
            classAssignment(n, ans + 'b');
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        while (num > 0) {
            int val = in.nextInt();
            classAssignment(val, "");
            System.out.println("#" + val + " : " + count);
            count = 0;
            num--;
        }
    }
}
