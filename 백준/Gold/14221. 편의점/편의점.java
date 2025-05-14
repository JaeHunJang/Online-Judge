import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, P, Q, homes[], convenients[], minDist, selectedHome;
    static List<Edge>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[from].add(new Edge(to, dist));
            list[to].add(new Edge(from, dist));
        }

        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        homes = new int[P];
        convenients = new int[Q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            homes[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            convenients[i] = Integer.parseInt(st.nextToken());
        }

        minDist = Integer.MAX_VALUE;
        selectedHome = Integer.MAX_VALUE;

        int[] distances = dijkstra();
        for (int home : homes) {
            if (minDist > distances[home] || (minDist == distances[home] && selectedHome > home)) {
                minDist = distances[home];
                selectedHome = home;
            }
        }

        System.out.println(selectedHome);
    }

    static int[] dijkstra() {
        int[] distances = new int[N + 1];
        Arrays.fill(distances, 100000 * 10000 + 1);
        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
        for (int c : convenients) {
            distances[c] = 0;
            q.offer(new Edge(c, 0));
        }

        while (!q.isEmpty()) {
            Edge now = q.poll();

            if (now.dist > distances[now.to]) continue;

            for (Edge next : list[now.to]) {
                if (distances[next.to] > next.dist + distances[now.to]) {
                    distances[next.to] = next.dist + distances[now.to];
                    q.offer(new Edge(next.to, distances[next.to]));
                }
            }
        }

//        System.out.println(Arrays.toString(distances));
        return distances;
    }

    static class Edge {
        int to, dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
}
