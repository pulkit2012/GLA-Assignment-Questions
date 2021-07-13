import java.util.Scanner;

public class MazePathD2 {
    static int counter = 0;
    static void pathFinder(String path, int l, int b, int i, int j, boolean[][] visited){
        if(i > l || j > b || i < 0 || j < 0){
            return;
        }
        if(i == l && j == b){
            System.out.print(path + " ");
            counter++;
            return;
        }
        visited[i][j] = true;
        pathFinder(path+'V',l,b,i+1,j,visited);
        pathFinder(path + 'H',l,b,i,j+1,visited);
        if(i == j || (i+j) == l) {
            pathFinder(path + 'D', l, b, i + 1, j + 1, visited);
        }
        visited[i][j] = false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        boolean[][] visited = new boolean[l][l];
        pathFinder("",l-1,l-1,0,0,visited);
        System.out.println("\n" + counter);
    }
}
