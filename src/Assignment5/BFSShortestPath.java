package Assignment5;

import java.util.*;

public class BFSShortestPath {
    static class Graph {

        Map<Integer, List<Integer>> adjList;
        int numV;

        public Graph(int numV) {
            adjList = new HashMap<>();
            for (int i = 1; i < numV + 1; i++) {
                adjList.put(i, new ArrayList<>());
            }
            this.numV = numV;
        }

        private void addEdge(int u, int v) {

            List<Integer> uNeighbour = this.adjList.getOrDefault(u, new ArrayList<>());
            uNeighbour.add(v);
            this.adjList.put(u, uNeighbour);
            List<Integer> vNeighbour = this.adjList.getOrDefault(v, new ArrayList<>());
            vNeighbour.add(u);
            this.adjList.put(v, vNeighbour);
        }

        private Map<Integer, Integer> SP(int src) {

            Queue<Integer> bfs = new LinkedList<>();

            bfs.add(src);
            Map<Integer, Integer> dis = new HashMap<>();
            for (int vertex : adjList.keySet()) {
                dis.put(vertex, Integer.MAX_VALUE);
            }
            dis.put(src, 0);

            while (!bfs.isEmpty()) {
                int front = bfs.poll();

                List<Integer> neighbourList = this.adjList.get(front);

                for (int neighbour : neighbourList) {
                    if (dis.get(neighbour) == Integer.MAX_VALUE) {
                        bfs.add(neighbour);
                        int distance = dis.get(front) + 6;
                        dis.put(neighbour, distance);
                    }
                }
            }
            return dis;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Graph g = new Graph(n);
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                g.addEdge(u, v);
            }
            int src = sc.nextInt();
            Map<Integer, Integer> ans = g.SP(src);
            System.out.println();
            for (int e : ans.keySet()) {
                if (e == src) {
                    continue;
                } else if (ans.get(e) != Integer.MAX_VALUE) {
                    System.out.print(ans.get(e) + " ");
                } else {
                    System.out.print(-1 + " ");
                }
            }
            t--;
        }

    }

}
