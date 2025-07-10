import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, parents[];
    static class Edge {
        int t, f, w;

        public Edge(int t, int f, int w) {
            this.t = t;
            this.f = f;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "t=" + t +
                    ", f=" + f +
                    ", w=" + w +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));

        parents = new int[N+1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        int C = 0, M = 0, cnt = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < i; j++) {
                int w = Integer.parseInt(st.nextToken());
                if (w < 0) {
                    C += Math.abs(w);
                    cnt++;
                    union(j, i);
                } else {
                    q.offer(new Edge(j, i, w));
                }
            }
        }

        List<Edge> list = new ArrayList<>();
        while (!q.isEmpty()) {
            Edge e = q.poll();
            if (union(e.t, e.f)) {
                C += Math.abs(e.w);
                list.add(e);
                M++;
            }
        }

        sb.append(C).append(" ").append(M).append("\n");
        for (Edge e : list) {
            sb.append(e.t).append(" ").append(e.f).append("\n");
        }
        System.out.println(sb);
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