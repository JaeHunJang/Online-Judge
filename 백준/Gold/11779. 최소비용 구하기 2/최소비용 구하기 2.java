import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, A, B;
    static List<Node>[] list;

    static class Node {
        int to, w;
        List<Integer> h;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
            h = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new List[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, w));
//            list[to].add(new Node(from, w));
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

//        System.out.println(A +"," + B);
        dijkstra(A);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));
        q.offer(new Node(start, 0));
        int[] weights = new int[N+1];
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[start] = 0;

        List<Integer> history = null;
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.w > weights[now.to]) continue;
            for (Node next : list[now.to]) {
                if (weights[next.to] > weights[now.to] + next.w) {
                    weights[next.to] = weights[now.to] + next.w;
                    Node n = new Node(next.to, weights[next.to]);
                    n.h.addAll(now.h);
                    n.h.add(next.to);
                    q.offer(n);
                }
            }
            if (now.h.size() > 0 && now.h.get(now.h.size()-1) == B) {
                history = now.h;
            }
        }

//        System.out.println(Arrays.toString(weights));
        System.out.println(weights[B]);
        System.out.println(history.size()+1);
//        System.out.println(history);
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        for (int i = 0; i < history.size(); i++) {
            sb.append(" ").append(history.get(i));
        }
        System.out.println(sb);
    }

    static boolean hasWall(int d, int cell) {
        return (cell & (1 << d)) != 0;
    }
}
