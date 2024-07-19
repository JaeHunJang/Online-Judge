import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 숨바꼭질 3
public class Main {
    static int N, K, deltas[] = {1, -1, 2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        q.offer(N*2);
        int visited[] = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[N] = 0;
        if (N * 2 <= 100000) visited[N*2] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int d : deltas) {
                int next;
                if (d == 2) {
                    next = now * 2; // 순간이동
                    if (next <= 100000 && visited[next] > visited[now]) {
                        visited[next] = visited[now];
                        q.offer(next);
                    }
                } else {
                    next = now + d; // 1초 후 이동
                    if (next >= 0 && next <= 100000 && visited[next] > visited[now] + 1) {
                        visited[next] = visited[now] + 1;
                        q.offer(next);
                    }
                }
            }
        }
        System.out.println(visited[K]);
    }
}