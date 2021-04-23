package chap13_ShortestPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra {
    public static void main(String[] args) {
        int[][] times = new int[10][];
        times[0] = new int[]{5,1,3};
        times[1] = new int[]{5,6,7};
        times[2] = new int[]{2,1,4};
        times[3] = new int[]{2,3,4};
        times[4] = new int[]{2,4,3};
        times[5] = new int[]{2,5,2};
        times[6] = new int[]{4,3,3};
        times[7] = new int[]{4,6,1};
        times[8] = new int[]{4,7,2};
        times[9] = new int[]{6,7,3};
        Map<Integer, Integer> hash = new HashMap<>(10);
        if(hash.getOrDefault(0, 100) > 10)
            System.out.println("dfdf");
        networkTime(times, 10, 2);
    }

    public static int networkTime(int[][] nodes, int capacity, int base) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] node : nodes) {
            if (!graph.containsKey(node[0])) {
                graph.put(node[0], new HashMap<>());
            }
            graph.get(node[0]).put(node[1], node[2]);
        }
        System.out.println("graph = " + graph);
        List<Integer> discovered = new ArrayList<>(capacity);
        Map<Integer, Integer> times = new HashMap<>();
        int cur = base;
        int curTime = 0;

        for (int n : graph.keySet()) {
            System.out.println("n = " + n);
            for (int m : graph.get(n).keySet()) {

            }
        }

        return 0;
    }

}
