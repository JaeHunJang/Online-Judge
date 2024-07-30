import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 나무 위의 빗물
public class Main {
    static int N, W;
    static double waters[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        waters = new double[N+1];
        waters[1] = W;

        List<Integer>[] list = new List[N+1];
        int u, v;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            if (list[u] == null) list[u] = new ArrayList<>();
            list[u].add(v);
            if (list[v] == null) list[v] = new ArrayList<>();
            list[v].add(u);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        boolean visited[] = new boolean[N+1];
        visited[1] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            int cnt = 0;
            for (int next : list[cur]) {
                if (!visited[next]) cnt++;
            }
            for (int next : list[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                waters[next] = waters[cur] / cnt;
                q.offer(next);
            }
            if (cnt > 0) {
                waters[cur] = 0;
            }
        }

        double sum = 0, cnt = 0;
        for (double water : waters) {
            if (water > 0) {
                sum += water;
                cnt++;
            }
        }
        System.out.println(sum / cnt);
    }
}