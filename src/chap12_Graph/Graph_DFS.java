package chap12_Graph;

import chap09_Stack_Queue.Stack;

import java.util.*;

public class Graph_DFS {
    public static void main(String[] args) {
        HashMap<Integer, int[]> graph = new HashMap<>();
        graph.put(1, new int[]{2, 3});
        graph.put(2, new int[]{5});
        graph.put(3, new int[]{5});
        graph.put(4, new int[0]);
        graph.put(5, new int[]{6, 7});
        graph.put(6, new int[]{4});
        graph.put(7, new int[]{3});

        List<Integer> discovered = new ArrayList<>();
        recursive_dfs(graph, 1, discovered);
        System.out.println("discovered = " + discovered);

        Stack<Integer> stack = new Stack<>();

        List<Integer> iterative = iterative_dfs(graph, 1);
        System.out.println("iterative = " + iterative);

        iterative = iterative_bfs(graph, 1);
        System.out.println("iterative = " + iterative);
    }

    public static List<Integer> recursive_dfs(HashMap<Integer, int[]> graph, int value, List<Integer> discovered) {
        discovered.add(value);
        for(int v : graph.get(value))
            if(!discovered.contains(v))
                discovered = recursive_dfs(graph, v, discovered);
        return discovered;
    }

    public static List<Integer> iterative_dfs(HashMap<Integer, int[]> graph, int value) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> discovered = new ArrayList<>();
        stack.push(value);
        while (!stack.isEmpty()) {
            value = stack.pop();
            if (!discovered.contains(value)) {
                discovered.add(value);
                for (int v : graph.get(value)) {
                    stack.push(v);
                }
            }
        }
        return discovered;
    }

    public static List<Integer> iterative_bfs(HashMap<Integer, int[]> graph, int value) {
        List<Integer> discovered = new ArrayList<>();
        discovered.add(value);
        List<Integer> queue = new ArrayList<>();
        queue.add(value);
        while (!queue.isEmpty()) {
            int v = queue.remove(0);
            for (int w : graph.get(v)) {
                if (!discovered.contains(w)) {
                    discovered.add(w);
                    queue.add(w);
                }
            }
        }
        return discovered;
    }
}
