import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, S;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        for (int i = 0; i <= N; i++) {
            Collections.sort(list[i], Collections.reverseOrder());
        }
        bfs();
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(S);
        int cnt = 1;
        int[] visited = new int[N+1];
        visited[S] = cnt++;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : list[now]) {
                if (visited[next] == 0) {
                    visited[next] = cnt++;
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }
}