import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, S, E, parents[];
    static List<Edge> list[];
    static Edge[] edges;
    static class Edge {
        int from, to;
        long w;

        public Edge(int from, int to, long w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }

        public Edge(int to, long w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", w=" + w +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        parents = new int[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            parents[i] = i;
        }
        edges = new Edge[M];

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, w);
//            list[from].add(new Edge(to, w));
//            list[to].add(new Edge(from, w));
        }

        Arrays.sort(edges, (o1, o2) -> Long.compare(o2.w, o1.w));
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (union(edges[i].from, edges[i].to)) {
                cnt++;
                list[edges[i].from].add(new Edge(edges[i].to, edges[i].w));
                list[edges[i].to].add(new Edge(edges[i].from, edges[i].w));
            }
            if (cnt == N-1) break;
        }
//        System.out.println(Arrays.toString(parents));
//        for (int i = 0; i <= N; i++) {
//            System.out.println(list[i]);
//        }

        System.out.println(bfs());
    }

    static long bfs() {
        long min = 0;
        Queue<Edge> q = new ArrayDeque<>();
        q.offer(new Edge(S, Long.MAX_VALUE));
        boolean[] visited = new boolean[N+1];
        visited[S] = true;

        while (!q.isEmpty()) {
            Edge now = q.poll();

            if (now.to == E) {
                min = Math.max(min, now.w);
            }
            for (Edge next : list[now.to]) {
                if (visited[next.to]) continue;
                visited[next.to] = true;
                q.offer(new Edge(next.to, Math.min(now.w, next.w)));
            }
        }

        return min;
    }

    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;
        parents[pa] = pb;
        return true;
    }
}