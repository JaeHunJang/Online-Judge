import java.io.*;
import java.util.*;

public class Main {
    static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, M, a[];
    static List<Node>[] list;
    static class Node {
        int n;
        long d;

        public Node(int n, long d) {
            this.n = n;
            this.d = d;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N];

        st = new StringTokenizer(br.readLine());
        list = new List[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list[a].add(new Node (b, t));
            list[b].add(new Node (a, t));
        }

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Long.compare(o1.d, o2.d));
//        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new Node (0, 0));
        long[] distances = new long[N];
        final long INF = Long.MAX_VALUE;
        Arrays.fill(distances, INF);
        distances[0] = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (distances[cur.n] < cur.d) continue;

            for (Node next : list[cur.n]) {
                if (a[next.n] == 1 && next.n != N-1) continue;
                if (distances[next.n] > next.d + distances[cur.n]) {
                    distances[next.n] = next.d + distances[cur.n];
                    q.offer(new Node(next.n, distances[next.n]));
                }
            }
        }

//        System.out.println(Arrays.toString(distances));
        if (distances[N-1] == INF) System.out.println(-1);
        else System.out.println(distances[N-1]);
    }
}
