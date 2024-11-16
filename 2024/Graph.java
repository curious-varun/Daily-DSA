import java.util.*;

public class Graph {
    public static void main(String[] args) {

    }

    public void topological(int node, List<List<Integer>> graph, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next])
                topological(next, graph, visited, st);
        }
        st.push(node);
    }
}