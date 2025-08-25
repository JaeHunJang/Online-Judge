import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long distances[];
    static List<Edge> list[];
    static class Edge {
        int to;
        long dist;

        public Edge(int to, long dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        distances = new long[N+1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }


        bfs(1);

    }

    static void bfs(int start) {
        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> Long.compare(o1.dist, o2.dist));
        q.offer(new Edge(start, 0));
        Arrays.fill(distances, Long.MAX_VALUE);
        distances[start] = 0;

        while (!q.isEmpty()) {
            Edge now = q.poll();

            for (Edge next : list[now.to]) {
                if (distances[next.to] > distances[now.to] + next.dist) {
                    distances[next.to] = distances[now.to] + next.dist;
                    q.offer(new Edge(next.to, distances[next.to]));
                }
            }
        }

        long maxDist = 0;
        for (int i = 1; i <= N; i++) {
            maxDist = Math.max(maxDist, distances[i]);
        }

        System.out.println(maxDist);
    }
}
