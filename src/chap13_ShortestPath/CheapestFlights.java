package chap13_ShortestPath;

import java.util.*;

public class CheapestFlights {

    public static void main(String[] args) {
        int[][] flights = new int[3][];
        flights[0] = new int[]{0,1,100};
        flights[1] = new int[]{1,2,100};
        flights[2] = new int[]{0,2,500};

        System.out.println(findCheapestPrice(3, flights, 0, 2, 0));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // pair<src_city, pair<dest_city, price>>
        Map<Integer, Map<Integer, Integer>> g = buildGraph(flights);

        Queue<Flight> q = new PriorityQueue<>(Comparator.comparingInt(f -> f.cost));

        q.add(new Flight(0, src, 0));

        while (!q.isEmpty()) {
            Flight f = q.poll();

            if (f.hops > K + 1) {
                continue;
            }

            if (f.to == dst) {
                return f.cost;
            }

            for (Map.Entry<Integer, Integer> u : g.getOrDefault(f.to, new HashMap<>()).entrySet()) {
                int to = u.getKey();

                int costSum = f.cost + u.getValue();
                q.add(new Flight(costSum, to, f.hops + 1));
            }
        }

        return -1;
    }

    static Map<Integer, Map<Integer, Integer>> buildGraph(int[][] flights) {
        Map<Integer, Map<Integer, Integer>> g = new HashMap<>();

        for (int[] edge : flights) {
            Map<Integer, Integer> u = g.getOrDefault(edge[0], new HashMap<>());
            u.put(edge[1], edge[2]);

            g.put(edge[0], u);
        }

        return g;
    }

    static class Flight {
        int cost;
        int to;
        int hops;

        Flight(int cost, int to, int hops) {
            this.cost = cost;
            this.to = to;
            this.hops = hops;
        }
    }


}
