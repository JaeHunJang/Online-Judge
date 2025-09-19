import java.io.*;
import java.util.*;

public class Main {
    static int N, E;
    static List<Node>[] graph;
    static final int INF = 200000000;

    static class Node {
        int to, w;
        Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        int result = Math.min(path1, path2);
        if (result >= INF) System.out.println(-1);
        else System.out.println(result);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0], cost = cur[1];
            if (dist[now] < cost) continue;

            for (Node next : graph[now]) {
                int nc = cost + next.w;
                if (dist[next.to] > nc) {
                    dist[next.to] = nc;
                    pq.offer(new int[]{next.to, nc});
                }
            }
        }
        return dist[end];
    }
}
