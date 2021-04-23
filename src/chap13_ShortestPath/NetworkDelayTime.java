package chap13_ShortestPath;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = new int[3][];
        times[0] = new int[]{2,1,1};
        times[1] = new int[]{2,3,1};
        times[2] = new int[]{3,4,1};

        System.out.println(networkDelayTimeV2(times, 4, 2));
    }

    /**
     * For Dijlstra:
     *
     * put node number and temporary distance into priority queue.
     * distance array is used to store the final result
     * Visited array needs to be used to mark the visited nodes
     *
     * For BFS:
     *
     * put node number into queue
     * distance array is used to store the temporary result, updated during BFS search
     * No need to track visited nodes
     */

    static class intComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2){
            return o1[1] - o2[1];
        }
    }

    public static int networkDelayTimeV1(int[][] times, int N, int K) {
        //build graph
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int[] time : times) {
            if (!map.containsKey(time[0])) {
                map.put(time[0], new ArrayList<>());
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(time[1]);
            temp.add(time[2]);
            map.get(time[0]).add(temp);
        }

        //visited array + distance array + priority queue
        boolean[] visited = new boolean[N];
        int[] dists = new int[N];
        Arrays.fill(dists, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new intComparator());
        //<current node number, temporary distance>
        pq.offer(new int[] {K, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            //when one node is polled out from queue
            //the temporary distance is the final result
            if (visited[cur[0] - 1]) continue;
            dists[cur[0] - 1] = cur[1];
            visited[cur[0] - 1] = true;
            if (map.containsKey(cur[0])) {
                List<List<Integer>> nodes = map.get(cur[0]);
                for (List<Integer> node : nodes) {
                    if (visited[node.get(0) - 1]) continue;
                    pq.offer(new int[] {node.get(0), dists[cur[0] - 1] + node.get(1)});
                }
            }
        }
        int maxPath = 0;
        for (int i = 0; i < dists.length; i ++) {
            if (dists[i] == -1) {
                return -1;
            }
            maxPath = Math.max(maxPath, dists[i]);
        }
        return maxPath;
    }

    public static int networkDelayTimeV2(int[][] times, int N, int K) {
        // build graph
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int[] time : times) {
            if (!map.containsKey(time[0])) {
                map.put(time[0], new ArrayList<>());
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(time[1]);
            temp.add(time[2]);
            map.get(time[0]).add(temp);
        }

        //dists array to keep temporary results, needs to be updated during bfs
        int[] dists = new int[N];
        Arrays.fill(dists, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.offer(K);
        dists[K - 1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int dist = dists[cur - 1];
            if (map.containsKey(cur)) {
                List<List<Integer>> nodes = map.get(cur);
                for (List<Integer> node : nodes) {
                    //update dists
                    if (dists[node.get(0) - 1] <= dist + node.get(1)) continue;
                    dists[node.get(0) - 1] = dist + node.get(1);
                    q.offer(node.get(0));
                }
            }
        }
        int maxPath = 0;
        for (int i = 0; i < dists.length; i ++) {
            if (dists[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxPath = Math.max(maxPath, dists[i]);
        }
        return maxPath;
    }

}
