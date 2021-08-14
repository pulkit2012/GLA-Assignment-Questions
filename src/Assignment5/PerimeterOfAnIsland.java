package Assignment5;

import java.util.*;

public class PerimeterOfAnIsland {
    HashMap<Integer, List<Integer>> adjacencyList;
    Queue<Integer> q;

    private void connectNode(int u, int v) {
        List<Integer> uNeighbours = adjacencyList.getOrDefault(u, new ArrayList<>());
        uNeighbours.add(v);
        adjacencyList.put(u, uNeighbours);
        if (u != v) {
            List<Integer> vNeighbours = adjacencyList.getOrDefault(v, new ArrayList<>());
            vNeighbours.add(u);
            adjacencyList.put(v, vNeighbours);
        }

    }

    private void createGraph(int n, int m, int[][] arr) {
        int value;
        adjacencyList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    value = m * i + j;
                    connectNode(value, value);
                    if (j != m - 1) {
                        if (arr[i][j + 1] == 1) {
                            connectNode(value, m * i + j + 1);
                        }
                    }
                    if (i != n - 1) {
                        if (arr[i + 1][j] == 1) {
                            connectNode(value, m * (i + 1) + j);
                        }
                    }
                }

            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
//            String[] oneRow = sc.next().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] =sc.nextInt();
            }
        }
        PerimeterOfAnIsland obj = new PerimeterOfAnIsland();
        obj.createGraph(n, m, arr);
        int perimeter=0;
        for (List<Integer> values:
                obj.adjacencyList.values()) {
            perimeter+=5-values.size();
        }
        System.out.println(perimeter);
    }

}
