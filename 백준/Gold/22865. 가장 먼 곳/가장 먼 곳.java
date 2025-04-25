import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, A, B, C, M;
    static List<Edge>[] list;
    static class Edge {
        int to, dist;
        Edge (int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            list[d].add(new Edge(e, l));
            list[e].add(new Edge(d, l));
        }
//        System.out.println(Arrays.toString(list));

        int[] distA = search(A);
        int[] distB = search(B);
        int[] distC = search(C);
        int rand = -1, maxDist = 0;
        for (int i = 1; i <= N; i++) {
            if (i == A || i == B || i == C) continue;
            int dist = Math.min(Math.min(distA[i], distB[i]), distC[i]);
            if (maxDist < dist) {
                rand = i;
                maxDist = dist;
            }
        }

        System.out.println(rand);
    }

    static int[] search(int start) {
        int[] distances = new int[N+1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
        pq.offer(new Edge(start, 0));
        distances[start] = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.dist > distances[now.to]) continue;
            for (Edge next : list[now.to]) {
                if (distances[next.to] > distances[now.to] + next.dist) {
                    distances[next.to] = distances[now.to] + next.dist;
                    pq.offer(new Edge(next.to, distances[next.to]));
                }
            }
        }

//        System.out.println(Arrays.toString(distances));
        return distances;
    }
}