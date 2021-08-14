package Assignment5;

import java.util.*;

public class DependentCources {
    HashMap<Integer, List<Integer>> directedGraph;

    private String topologicalSort(int[] indegree, int numOfCourses) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                count++;
            }
        }
        while (!q.isEmpty()) {
            int source = q.poll();
            if (directedGraph.get(source) != null) {
                for (int ele :
                        directedGraph.get(source)) {
                    if (indegree[ele] != 0) {
                        indegree[ele]--;
                        if (indegree[ele] == 0) {
                            q.add(ele);
                            count++;
                        }
                    }
                }
            }

        }
        return count == numOfCourses ? "Yes" : "No";
    }

    private int[] indegreeCreation() {
        int[] indegree = new int[max + 1];
        for (List<Integer> neighbours :
                directedGraph.values()) {
            for (int ele :
                    neighbours) {
                indegree[ele]++;
            }
        }
        return indegree;
    }

    int max = 0;

    private void createGraph(int src, int dest) {
        max = Math.max(max, Math.max(src, dest));
        List<Integer> neighbours = directedGraph.getOrDefault(src, new ArrayList<>());
        neighbours.add(dest);
        directedGraph.put(src, neighbours);
    }

    private void implementCreation(int[][] graph, int numCourses) {
        directedGraph = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            createGraph(graph[i][1], graph[i][0]);
        }
        int[] indegree = indegreeCreation();
        String answer = topologicalSort(indegree, numCourses);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCourses = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[m][2];
        for (int i = 0; i < m; i++) {
            graph[i][0] = sc.nextInt();
            graph[i][1] = sc.nextInt();
        }
        DependentCources obj = new DependentCources();
        obj.implementCreation(graph, numOfCourses);
    }
}
