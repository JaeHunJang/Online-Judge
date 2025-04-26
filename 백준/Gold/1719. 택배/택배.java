import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static List<Edge>[] list;
    static class Edge {
        int to, dist, next;
        Edge (int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
        Edge (int to, int dist, int next) {
            this.to = to;
            this.dist = dist;
            this.next = next;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list[from].add(new Edge(to, d));
            list[to].add(new Edge(from, d));
        }
//        System.out.println(Arrays.toString(list));

        for (int i = 1; i <= N; i++) {
            search(i);
        }
        System.out.println(sb);
    }

    static int[] search(int start) {
        int[] distances = new int[N+1];
        int[] nodes = new int[N+1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
//        pq.offer(new Edge(start, 0));
        distances[start] = 0;
//        for (Edge next : list[start]) {
//            if (distances[next.to] > distances[start] + next.dist) {
//                distances[next.to] = distances[start] + next.dist;
//                nodes[next.to] = next.to;
//                pq.offer(new Edge(next.to, distances[next.to], next.to));
//            }
//        }
        pq.offer(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.dist > distances[now.to]) continue;
            for (Edge next : list[now.to]) {
                if (distances[next.to] > distances[now.to] + next.dist) {
                    distances[next.to] = distances[now.to] + next.dist;
                    if (now.next == 0) {
                        nodes[next.to] = next.to;
                        pq.offer(new Edge(next.to, distances[next.to], next.to));
                    } else {
                        nodes[next.to] = now.next;
                        pq.offer(new Edge(next.to, distances[next.to], now.next));
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (nodes[i] == 0) sb.append("- ");
            else sb.append(nodes[i]).append(" ");
        }
        sb.append("\n");
        return distances;
    }
}