import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, parents[];
    static long K;
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
                    "}\n";
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            q.offer(new Edge(i+1, N+1, Integer.parseInt(st.nextToken())));
        }
//        int[][] map = new int[N+1][N+1];
        HashMap<Integer, List<Integer>> edge = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
//            map[t][f] = -1;
            List<Integer> tmp = edge.getOrDefault(t, new ArrayList<>());
            tmp.add(f);
            edge.put(t, tmp);
        }

        parents = new int[N+2];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
//        System.out.println(q);

        for (int i = 1; i < N; i++) {
            List<Integer> brokenRoads = edge.get(i);
            if (brokenRoads == null || !brokenRoads.contains(i+1)) {
//            if (map[i][i+1] == 0) {
//                q.offer(new Edge(i, i+1, 0));
                union(i, i+1);
            }
        }

        List<Integer> brokenRoads = edge.get(N);

//        if (map[N][1] == 0) {
        if (brokenRoads == null || !brokenRoads.contains(1)) {
//            q.offer(new Edge(N, 1, 0));
            union(N, 1);
        }

        long k = 0;
        while (!q.isEmpty()) {
            Edge now = q.poll();
            if (k + now.w <= K && union(now.t, now.f)) {
//                System.out.println(now);
                k += now.w;
//                System.out.println(Arrays.toString(parents));
            }
        }
//        System.out.println(k);

        for (int i = 1; i < parents.length; i++) {
            find(i);
        }

        String answer = "YES";
        if (!isOne() && !isOne2()) answer = "NO";
//        System.out.println(Arrays.toString(parents));
        System.out.println(answer);
    }

    static boolean isOne() {
        for (int i = 2; i < parents.length; i++) {
            if (parents[1] != parents[i]) {
                return false;
            }
        }

        return true;
    }

    static boolean isOne2() {
        for (int i = 1; i < N; i++) {
            if (parents[i+1] != parents[i]) {
                return false;
            }
        }

        return true;
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
