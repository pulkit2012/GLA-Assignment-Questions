package Assignment5;

import java.util.*;

public class BeautifulVertices {
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    int[] isVisited = new int[100001];
    int[] childrenCount = new int[100001];
    int[] parent = new int[100001];

    private void createGraph(int u, int v) {
        List<Integer> uchilds = adjacencyList.getOrDefault(u, new ArrayList<>());
        uchilds.add(v);
        adjacencyList.put(u, uchilds);
        List<Integer> vchilds = adjacencyList.getOrDefault(v, new ArrayList<>());
        vchilds.add(u);
        adjacencyList.put(v, vchilds);
    }

    private void dfs(int u) {
        isVisited[u] = 1;
        if (adjacencyList.get(u) != null) {
            for (int ele :
                    adjacencyList.get(u)) {
                if (isVisited[ele] != 1) {
                    parent[ele] = u;
                    childrenCount[u] += 1;
                    dfs(ele);
                }
            }
        }

    }

    private void countAnswer(int n) {
        int c = 0;
        for (int i = 1; i <= n; i++) {
            if (parent[i] != 0 && childrenCount[parent[i]] < childrenCount[i]) {
                c++;
            }
        }
        System.out.println(c);
    }

    private void execute(int n) {
        for (int i = 0; i <= n; i++) {
            if (isVisited[i] != 1) {
                dfs(i);
            }
        }
        countAnswer(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        BeautifulVertices obj = new BeautifulVertices();
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            obj.createGraph(a, b);
        }
        obj.execute(V);
    }
}
