import java.util.*;
import java.io.*;

public class Main {
    static int N, M, A, B;
    static List<Edge>[] graph;
    static long[] distA, distB;
    static final long INF = Long.MAX_VALUE;

    static class Edge {
        int to;
        long cost;

        Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, c));
            graph[v].add(new Edge(u, c));
        }

        distA = dijkstra(A);
        distB = dijkstra(B);

        long shortest = distA[B];
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (distA[i] != INF && distB[i] != INF && distA[i] + distB[i] == shortest) {
                answer.add(i);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        StringBuilder sb = new StringBuilder();
        for (int city : answer) sb.append(city).append(" ");
        System.out.println(sb.toString().trim());
    }

    static long[] dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(e -> e.cost));
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int now = curr.to;
            long d = curr.cost;

            if (d > dist[now]) continue;

            for (Edge next : graph[now]) {
                if (dist[next.to] > dist[now] + next.cost) {
                    dist[next.to] = dist[now] + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }

        return dist;
    }
}
