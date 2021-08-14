package Assignment5;

import java.util.Scanner;

public class MaximumAreaOfIsland {
    public static int dfs(int grid[][], int row, int col)
    {
        int m = grid.length;
        int n = grid[0].length;
        int area = 1;
        grid[row][col] = 0;
        int [] dir = {-1,0,1,0,-1};
        for (int i = 0; i < 4; i++)
        {
            int r = row+dir[i], c = col+dir[i+1];
            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1)
                area += dfs(grid, r, c);
        }
        return area;
    }

    public static int largestIsland(int grid[][],int m, int n)
    {
        int maxArea = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    maxArea = Math.max(maxArea, dfs(grid, i, j));

        return maxArea;
    }

    public static void main (String[] args)
    {
        Scanner s= new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int grid[][] = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j =0; j<n;j++ ){
                grid[i][j] =s.nextInt();
            }
        }
        System.out.print(largestIsland(grid,m,n));
    }

}
