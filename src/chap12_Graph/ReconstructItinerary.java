package chap12_Graph;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(new ArrayList<>());
        tickets.add(new ArrayList<>());
        tickets.add(new ArrayList<>());
        tickets.add(new ArrayList<>());
        tickets.get(0).add("MUC");
        tickets.get(0).add("LHR");
        tickets.get(1).add("JFK");
        tickets.get(1).add("MUC");
        tickets.get(2).add("SFO");
        tickets.get(2).add("SJC");
        tickets.get(3).add("LHR");
        tickets.get(3).add("SFO");

        System.out.println(findItineraryV2(tickets));

        List<List<String>> tickets2 = new ArrayList<>();
        tickets2.add(new ArrayList<>());
        tickets2.add(new ArrayList<>());
        tickets2.add(new ArrayList<>());
        tickets2.add(new ArrayList<>());
        tickets2.add(new ArrayList<>());
        tickets2.get(0).add("JFK");
        tickets2.get(0).add("SFO");
        tickets2.get(1).add("JFK");
        tickets2.get(1).add("ATL");
        tickets2.get(2).add("SFO");
        tickets2.get(2).add("ATL");
        tickets2.get(3).add("ATL");
        tickets2.get(3).add("JFK");
        tickets2.get(4).add("ATL");
        tickets2.get(4).add("SFO");

        System.out.println(findItineraryV2(tickets2));
        System.out.println(findItineraryV3(tickets2));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new ArrayList<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs(result, map, "JFK");

        return result;
    }

    public static void dfs(List<String> result, Map<String, List<String>> map, String a) {
        while (map.containsKey(a) && !map.get(a).isEmpty()) {
            System.out.println("a = " + a);
            dfs(result, map, map.get(a).remove(0));
        }
        result.add(a);
    }

    public static List<String> findItineraryV2(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            map.computeIfAbsent(from, (k) -> new ArrayList<>()).add(to);
        }
        map.forEach((f, t) -> Collections.sort(t, Collections.reverseOrder()));

        List<String> result = new ArrayList<>();
        dfsV2(map, "JFK", result);

        Collections.reverse(result);
        return result;
    }

    public static List<String> findItineraryV3(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String destination = ticket.get(1);

            graph.computeIfAbsent(origin, (k) -> new ArrayList<>()).add(destination);
        }
        graph.forEach((o, d) -> Collections.sort(d, Collections.reverseOrder()));

        List<String> itinerary = new ArrayList<>();
        topologicalSort(graph, "JFK", itinerary);

        Collections.reverse(itinerary);
        return itinerary;
    }

    private static void dfsV2(Map<String, List<String>> map, String from, List<String> result) {
        if (map.containsKey(from)) {
            List<String> to = map.get(from);
            while (!to.isEmpty()) {
                dfsV2(map, to.remove(to.size() - 1), result);
            }
        }
        result.add(from);
    }

    private static void topologicalSort(Map<String, List<String>> graph, String origin,
                                 List<String> itinerary) {
        if (graph.containsKey(origin)) {
            List<String> destinations = graph.get(origin);
            while (!destinations.isEmpty()) {
                topologicalSort(graph, destinations.remove(destinations.size() - 1), itinerary);
            }
        }
        itinerary.add(origin);
    }
}
