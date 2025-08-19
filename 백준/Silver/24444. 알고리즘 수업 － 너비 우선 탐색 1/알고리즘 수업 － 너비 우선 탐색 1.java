import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, R;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new List[N+1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 0; i < list.length; i++) {
            Collections.sort(list[i]);
        }

        int cnt = 1;
        int[] visited = new int[N+1];
        visited[R] = cnt++;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(R);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : list[now]) {
                if (visited[next] > 0) continue;
                visited[next] = cnt++;
                q.offer(next);
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
//        System.out.println(Arrays.toString(visited));
        System.out.println(sb);
    }
}