import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int from, w;
        Node (int from, int w) {
            this.from = from;
            this.w = w;
        }
    }
    static final int INF = 10000*1000+1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] weights = new int[N+1];
        List<Node>[] list = new List[N+1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[to].add(new Node(from, w));
        }

        for (int i = 1; i <= N; i++) {
            weights[i] = bfs(i, list)[X];
        }
        int[] party = bfs(X, list);
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (i != X) answer = Math.max(answer, weights[i] + party[i]);
        }

        System.out.print(answer);
    }

    static int[] bfs(int start, List<Node>[] list) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));
        pq.offer(new Node(start, 0));
        int[] weights = new int[list.length];
        Arrays.fill(weights, INF);
        weights[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : list[now.from]) {
                if (next.w + weights[now.from] < weights[next.from]) {
                    weights[next.from] = next.w + weights[now.from];
                    pq.offer(new Node(next.from, weights[next.from]));
                }
            }
        }

        return weights;
    }
}
