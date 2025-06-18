import java.util.*;

public class GraphAdjacencyList {
    public static void main(String[] args) {
        int[][] pairs = {
            {1, 2},
            {1, 3},
            {2, 4},
            {3, 4}
        };

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : pairs) {
            int u = edge[0];
            int v = edge[1];

            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);

            adjList.computeIfAbsent(v, k -> new ArrayList<>());
        }

        for (int node : adjList.keySet()) {
            System.out.println(node + " → " + adjList.get(node));
        }
    }
}
