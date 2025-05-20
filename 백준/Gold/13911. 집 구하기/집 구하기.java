import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int V, E, M, x, S, y, homes[];
    static List<Node>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new List[V+1];
        homes = new int[V+1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
            list[v].add(new Node(u, w));
        }
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Long.compare(o1.w, o2.w));
        long[] mlist = new long[V+1];

        Arrays.fill(mlist, 300000*10000L+1);
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            q.offer(new Node(n, 0));
            mlist[n] = 0;
            homes[n] = 1;
        }
        dijkstra(q, mlist);


        q.clear();
        long[] slist = new long[V+1];
        Arrays.fill(slist, 300000*10000L+1);
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            int n = Integer.parseInt(st.nextToken());
            q.offer(new Node(n, 0));
            slist[n] = 0;
            homes[n] = 2;
        }
        dijkstra(q, slist);
        long answer = Long.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            if (homes[i] > 0) continue;
            if (mlist[i] <= x && slist[i] <= y) answer = Math.min(answer, mlist[i] + slist[i]);
        }
        
        if (answer == Long.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }

    static long[] dijkstra(PriorityQueue<Node> q, long[] weights) {
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.w > weights[now.to]) continue;

            for (Node next : list[now.to]) {
                if (weights[next.to] > next.w + weights[now.to]) {
                    weights[next.to] = next.w + weights[now.to];
                    q.offer(new Node(next.to, weights[next.to]));
                }
            }
        }

        return weights;
    }
    static class Node {
        int to;
        long w;

        public Node(int to, long w) {
            this.to = to;
            this.w = w;
        }
    }
}