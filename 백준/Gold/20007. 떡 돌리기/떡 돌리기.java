import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, X, Y;
    static List<Pos>[] list;
    static class Pos {
        int to, dist;
        Pos (int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    static final int INF = 10000000 * 1001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        list = new List[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[from].add(new Pos(to, dist));
            list[to].add(new Pos(from, dist));
        }

//        System.out.println(Arrays.toString(dijkstra()));
        System.out.println(calcDays(dijkstra()));
    }

    static int calcDays(int[] distances) {
        PriorityQueue<Pos> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] * 2 > X || distances[i] == INF) return -1;
            q.offer(new Pos(i, distances[i]));
        }

        int days = 0;
        while (!q.isEmpty()) {
            int dist = X;
            while (!q.isEmpty() && q.peek().dist * 2 <= dist) {
                dist -= q.poll().dist * 2;
            }
            days++;
        }

        return days;
    }

    static int[] dijkstra() {
        PriorityQueue<Pos> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
        q.offer(new Pos(Y, 0));
        int[] distances = new int[N];
        Arrays.fill(distances, INF);
        distances[Y] = 0;
        while (!q.isEmpty()) {
            Pos now = q.poll();

            if (now.dist > distances[now.to]) continue;
            for (Pos next : list[now.to]) {
                if (distances[next.to] > next.dist + distances[now.to]) {
                    distances[next.to] = next.dist + distances[now.to];
                    q.offer(new Pos(next.to, distances[next.to]));
                }
            }
        }

        return distances;
    }
}