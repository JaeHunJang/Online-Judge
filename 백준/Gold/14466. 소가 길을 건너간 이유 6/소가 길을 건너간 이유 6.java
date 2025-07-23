import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, R, deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}}, cnt, cows[];
    static List<Edge>[] list;
    static class Edge {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", w=" + w +
                    '}';
        }
    }
    static final int INF = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new List[N*N+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N*N; i++) {
            int r = i / N;
            int c = i % N;
//            System.out.println(i+ ": " + r + "|" + c);
            for (int d = 0; d < deltas.length; d++) {
                int nr = r + deltas[d][0];
                int nc = c + deltas[d][1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                int near = nr * N + nc;
                list[i+1].add(new Edge(near+1, 0));
            }
        }
//        for (int i = 0; i < list.length; i++) {
//            System.out.println(list[i]);
//        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int n1 = (r1-1) * N + c1;
            int n2 = (r2-1) * N + c2;
            for (Edge e : list[n1]) {
                if (e.to == n2) {
                    e.w = INF;
                }
            }
            for (Edge e : list[n2]) {
                if (e.to == n1) {
                    e.w = INF;
                }
            }
        }

//        for (int i = 0; i < list.length; i++) {
//            System.out.println(list[i]);
//        }
        cows = new int[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int n1 = (r1-1) * N + c1;
            cows[i] = n1;
        }

        for (int i = 0; i < K; i++) {
            cnt += dijkstra(cows[i]);
        }

        System.out.println(cnt / 2);
    }

    static int dijkstra(int cow) {
        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.w, o1.w));
        q.offer(new Edge(cow, 0));
        int[] distances = new int[N*N+1];
        Arrays.fill(distances, INF);
        distances[cow] = 0;

        while (!q.isEmpty()) {
            Edge e = q.poll();

            for (Edge next : list[e.to]) {
                if (distances[next.to] > distances[e.to] + next.w) {
                    distances[next.to] = distances[e.to] + next.w;
                    q.offer(new Edge(next.to, distances[next.to]));
                }
            }
        }
//        System.out.println(Arrays.toString(distances));

        int cnt = 0;
        for (int i = 0; i < K; i++) {
            if (cow == cows[i]) continue;
            if (distances[cows[i]] == INF) cnt++;
        }

        return cnt;
    }
}
