import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 1238. 파티 / 분
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, X, minDistReverse[], minDist[];
    static List<Node>[] list;
    static boolean visited[];
    static final int INF = 1000 * 10000 * 100; // 마을 수 * 도로 수 * 최대시간

    static class Node {
        int to, w;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 마을 수
        M = Integer.parseInt(st.nextToken()); // 도로 수
        X = Integer.parseInt(st.nextToken()); // 도착마을

        list = new List[N+1];
        for (int i = 0; i <= N ; i++) {
            list[i] = new ArrayList<>();
        }
        
        int from, to, w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, w));
        }

        minDist = new int[N+1];


        solve();
        System.out.println(sb.toString());
    }

    static void solve() throws Exception {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.w, o2.w);
        });
        int dist[] = new int[N+1];
        for (int i = 1; i <= N; i++) {
            pq.clear();
            Arrays.fill(dist, INF);
            visited = new boolean[N+1];
            dist[i] = 0;
            pq.offer(new Node(i, 0));

            while(!pq.isEmpty()) {
                Node now = pq.poll();
                if (visited[now.to]) continue;
                visited[now.to] = true;

                for (Node next : list[now.to]) {
                    if (dist[next.to] > dist[now.to] + next.w) {
                        dist[next.to] = dist[now.to] + next.w;

                        pq.offer(new Node(next.to, dist[next.to]));
                    }
                }
            }

            minDist[i] = dist[X];
            if (i == X) {
                minDistReverse = dist.clone();
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, minDist[i] + minDistReverse[i]);
        }
        sb.append(answer);
    }

}