import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static List<Node>[] list;
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
        T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            list = new List[N+1];
            for (int i = 0; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                list[S].add(new Node(E, T));
                list[E].add(new Node(S, T));
            }
            for (int w = 0; w < W; w++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                list[S].add(new Node(E, -T));
            }
            bellmanFord(N);
        }

        System.out.println(sb);
    }

    static void bellmanFord(int N) {
        int[] distances = new int[N+1];
        int[] parents = new int[N+1];
//        Arrays.fill(distances, Integer.MAX_VALUE);
//        distances[start] = 0;

        for (int i = 1; i < N; i++) {
            for (int u = 1; u <= N; u++) {
                for (Node next : list[u]) {
                    if (distances[u] != Integer.MAX_VALUE && distances[next.to] > distances[u] + next.w) {
                        distances[next.to] = distances[u] + next.w;
                        parents[next.to] = u;
                    }
                }
            }
        }

        for (int u = 1; u <= N; u++) {
            for (Node next : list[u]) {
                if (distances[u] != Integer.MAX_VALUE && distances[next.to] > distances[u] + next.w) {
                    sb.append("YES\n");
                    return;
                }
            }
        }
        sb.append("NO\n");
    }
}