import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int V, E, P;
    static List<Pos>[] list;
    static class Pos {
        int to, dist;
        Pos (int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        list = new List[V+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[from].add(new Pos(to, dist));
            list[to].add(new Pos(from, dist));
        }
        int[] distances = dijkstra(1);
        int[] minjun = dijkstra(P);
//        System.out.println(Arrays.toString(distances));
//        System.out.println(Arrays.toString(minjun));
        if (distances[P] + minjun[V] == distances[V]) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }

    static int[] dijkstra(int start) {
        int[] distances = new int[V+1];
        Arrays.fill(distances, 10000*5000+1);
        distances[start] = 0;
        PriorityQueue<Pos> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
        q.offer(new Pos(start, 0));
        while (!q.isEmpty()) {
            Pos now = q.poll();

            if (now.dist > distances[now.to]) continue;
            for (Pos next : list[now.to]) {
                if (distances[next.to] > distances[now.to] + next.dist) {
                    distances[next.to] = distances[now.to] + next.dist;
                    q.offer(new Pos(next.to, distances[next.to]));
                }
            }
        }
        return distances;

    }
}