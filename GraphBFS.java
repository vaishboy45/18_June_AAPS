import java.util.*;

public class GraphBFS {
    public static void main(String[] args) {
        int[][] pairs = {
            {1, 2},
            {1, 3},
            {2, 4},
            {3, 4}
        };

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : pairs) {
            int u = edge[0], v = edge[1];
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k -> new ArrayList<>()); // Optional for isolated nodes
        }

        int startNode = 1;
        bfs(startNode, adjList);
    }

    public static void bfs(int start, Map<Integer, List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}
