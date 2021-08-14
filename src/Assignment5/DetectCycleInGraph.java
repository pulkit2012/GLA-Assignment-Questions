package Assignment5;

import java.util.*;

public class DetectCycleInGraph {
    HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

    private void createGraph(int u, int v) {
        List<Integer> uNeighbours = adjacencyList.getOrDefault(u, new ArrayList<>());
        uNeighbours.add(v);
        adjacencyList.put(u, uNeighbours);
        List<Integer> vNeighbours = adjacencyList.getOrDefault(v, new ArrayList<>());
        vNeighbours.add(u);
        adjacencyList.put(v, vNeighbours);
    }

    private int detectCycle(int startingNode, int numberOfNodes, Set<Integer> isVisited) {
        int[] parentsRecord = new int[numberOfNodes + 1];
        for (int i = 0; i < numberOfNodes; i++) {
            parentsRecord[i] = i;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(startingNode);
        while (!q.isEmpty()) {
            int parent = q.poll();
            isVisited.add(parent);
            if (adjacencyList.get(parent) != null) {
                for (int neighbours :
                        adjacencyList.get(parent)) {
                    if (!isVisited.contains(neighbours)) {
                        q.add(neighbours);
                        parentsRecord[neighbours] = parent;
                    } else if (neighbours != parentsRecord[parent]) {
                        return 1;
                    }

                }
            }

        }
        return 0;
    }

    private void runOverAllNodes(int V) {
        Set<Integer> isVisited = new HashSet<>();
        isVisited.clear();
        int cycleDetected = 0;
        for (int key : adjacencyList.keySet()) {
            if (!isVisited.contains(key)) {
                cycleDetected = detectCycle(key, V, isVisited);
                if (cycleDetected == 1) {
                    break;
                }
            }
        }
        if (cycleDetected == 1)

            System.out.println("yes");
        else{
            System.out.println("no");
        }
    }

    private void clearMap() {
        adjacencyList.clear();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int k = 0; k < q; k++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            DetectCycleInGraph obj = new DetectCycleInGraph();
            obj.clearMap();
            for (int i = 0; i < E; i++) {
                int src = sc.nextInt();
                int dest = sc.nextInt();
                obj.createGraph(src, dest);
            }
            obj.runOverAllNodes(V);
        }
    }
}
