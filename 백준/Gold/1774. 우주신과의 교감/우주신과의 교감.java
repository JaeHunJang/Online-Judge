import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static class Edge {
        int to, from;
        double dist;
        Edge(int to, int from, double dist) {
            this.to = to;
            this.from = from;
            this.dist = dist;
        }
    }

    static class Pos {
        int r, c;
        Pos (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        Pos[] pos = new Pos[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            parents[i+1] = i+1;
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>((o1,o2) -> Double.compare(o1.dist, o2.dist));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            edges.offer(new Edge(to, from, 0));
            edges.offer(new Edge(from, to, 0));
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                double dist = getDist(pos[i], pos[j]);
                edges.offer(new Edge(i + 1, j + 1, dist));
                edges.offer(new Edge(j + 1, i + 1, dist));
            }
        }

        int cnt = 0;
        double totalDist = 0;
        while (!edges.isEmpty() && cnt <= N) {
            Edge e = edges.poll();

            if (union(e.to, e.from)) {
                totalDist += e.dist;
                cnt++;
            }
        }

        totalDist = Math.round(totalDist * 100) / 100d;

        System.out.printf("%.2f", totalDist);
    }

    static double getDist(Pos p1, Pos p2) {
        return Math.sqrt(Math.pow(Math.abs(p1.r-p2.r),2) + Math.pow(Math.abs(p1.c-p2.c),2));
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