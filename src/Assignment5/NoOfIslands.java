package Assignment5;

import java.util.Scanner;

public class NoOfIslands {
    static int islands = 0;

    static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    countIsland(grid, visited, i, j);
                    islands += 1;
                } else
                    continue;
            }
        }
        return islands;
    }

    static void countIsland(char[][] grid, boolean[][] visited, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true || grid[i][j] == '0')
            return;
        visited[i][j] = true;
        countIsland(grid, visited, i - 1, j);
        countIsland(grid, visited, i, j + 1);
        countIsland(grid, visited, i, j - 1);
        countIsland(grid, visited, i + 1, j);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int b = in.nextInt();
        in.nextLine();
        char[][] M = new char[l][b];
        for (int i = 0; i < l; i++) {
            String s = in.nextLine();
            for (int j = 0; j < b; j++) {
                M[i][j] = s.charAt(j);
            }
        }
        System.out.println(numIslands(M));

    }
}
