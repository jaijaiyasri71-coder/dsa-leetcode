import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges,
                                double[] succProb,
                                int start, int end) {

        List<double[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            graph[u].add(new double[]{v, p});
            graph[v].add(new double[]{u, p});
        }

        double[] prob = new double[n];
        prob[start] = 1.0;

        PriorityQueue<double[]> pq =
            new PriorityQueue<>((a, b) ->
                Double.compare(b[1], a[1]));

        pq.offer(new double[]{start, 1.0});

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();

            int node = (int) curr[0];
            double probability = curr[1];

            if (node == end) {
                return probability;
            }

            if (probability < prob[node]) {
                continue;
            }

            for (double[] next : graph[node]) {
                int v = (int) next[0];
                double p = next[1];

                double newProb = probability * p;

                if (newProb > prob[v]) {
                    prob[v] = newProb;
                    pq.offer(new double[]{v, newProb});
                }
            }
        }

        return 0.0;
    }
}
