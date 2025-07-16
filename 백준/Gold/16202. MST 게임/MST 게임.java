import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, K, parents[], map[][];
    static class Edge {
        int to, from, w;

        public Edge(int from, int to, int w) {
            this.to = to;
            this.from = from;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", from=" + from +
                    ", w=" + w +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        map = new int[N+1][N+1];


        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));
        List<Edge> useEdges = new ArrayList<>();
        List<Edge> mstEdges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            q.offer(new Edge(from, to, i+1));
            q.offer(new Edge(to, from, i+1));
            map[from][to] = i+1;
            map[to][from] = i+1;
        }

        while (K > 0) {
            set();

            int score = 0;
            int cnt = 0;
            while (!q.isEmpty()) {
                Edge e = q.poll();
                if (map[e.from][e.to] >= 0 && union(e.from, e.to)) {
                    score += e.w;
                    mstEdges.add(e);
                    cnt++;
                } else {
                    useEdges.add(e);
                }

                if (cnt == N-1) break;
            }

            if (!checkMST()) break;

            q.addAll(mstEdges); // MST를 구성한 간선 추가
            mstEdges.clear();
            Edge removeEdge = q.poll(); // 최소 비용 간선 1개 삭제
            map[removeEdge.from][removeEdge.to] = -1;
            map[removeEdge.to][removeEdge.from] = -1;
            q.addAll(useEdges); // MST를 구성하지 못한 간선 추가
            useEdges.clear();

            sb.append(score).append(" ");
            K--;
        }

        while (K > 0) {
            sb.append(0).append(" ");
            K--;
        }

        System.out.println(sb);
    }

    static boolean checkMST() {
        for (int i = 1; i < parents.length; i++) {
            find(i);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < parents.length; i++) {
            set.add(parents[i]);
        }

        if (set.size() > 1) return false;
        return true;
    }

    static void set() {
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
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