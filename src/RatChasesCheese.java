import java.util.Arrays;
import java.util.Scanner;

public class RatChasesCheese {
    //Test Case 3 Fails---------------------------
    static boolean pathExist = false;

    static void pathFinder(char[][] arr, int[][] visited, int i, int j, int l, int b) {
        if (i < 0 || i >= l || j >= b || j < 0 || arr[i][j] == 'X' || visited[i][j] == 1) {
            return;
        }
        if (i == l - 1 && j == b - 1) {
            visited[i][j] = 1;
            pathExist = true;
            for (int i1 = 0; i1 < l; i1++) {
                for (int i2 = 0; i2 < b; i2++) {
                    System.out.print(visited[i1][i2] + " ");
                }
                System.out.println();
            }
            return;
        }
        visited[i][j] = 1;
        pathFinder(arr, visited, i, j + 1, l, b);
        pathFinder(arr, visited, i, j - 1, l, b);
        pathFinder(arr, visited, i + 1, j, l, b);
        pathFinder(arr, visited, i - 1, j, l, b);
        visited[i][j] = 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int b = in.nextInt();
        in.nextLine();
        char[][] arr = new char[l][b];
        int[][] visited = new int[l][b];
        for (int i = 0; i < l; i++) {
            String temp = in.nextLine();
            for (int i1 = 0; i1 < temp.length(); i1++) {
                arr[i][i1] = temp.charAt(i1);
            }
        }
        pathFinder(arr, visited, 0, 0, l, b);
        if (!pathExist) {
            System.out.println("NO PATH FOUND");
        }
    }
}
//All test Case Passed-----------------------------------
class test2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        if (!findPath(arr, n, m)) {
            System.out.println("NO PATH FOUND");
        }

    }

    public static boolean findPath(char[][] maze, int n, int m) {
        int path[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                path[i][j] = 0;
            }

        }

        return findpath(maze, n, m, 0, 0, path);

    }

    public static boolean findpath(char[][] maze, int n, int m, int x, int y, int[][] path) {

        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }

        if (x == n - 1 && y == m - 1) {
            path[x][y] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(path[i][j] + " ");
                }
                System.out.println();
            }

            return true;
        }

        if (maze[x][y] == 'X' || path[x][y] == 1) {
            return false;
        }

        path[x][y] = 1;
        if (findpath(maze, n, m, x, y + 1, path)) {
            path[x][y] = 0;
            return true;
        }

        if (findpath(maze, n, m, x, y - 1, path)) {
            path[x][y] = 0;
            return true;
        }

        if (findpath(maze, n, m, x - 1, y, path)) {
            path[x][y] = 0;
            return true;
        }

        if (findpath(maze, n, m, x + 1, y, path)) {
            path[x][y] = 0;
            return true;
        }
        path[x][y] = 0;
        return false;

    }
}
