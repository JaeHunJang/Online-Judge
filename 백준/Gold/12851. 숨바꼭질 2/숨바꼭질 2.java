import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K, minTime = Integer.MAX_VALUE, count = 0;

    public static void main(String[] args) throws Exception {
        init();
        solve();
        print();
    }
    static void print() {
        System.out.println(sb.toString());
    }

    static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static void solve() throws Exception {
        bfs();
    }

    static void bfs() {
        int visited[] = new int[100001];
        Arrays.fill(visited, -1);
        visited[N] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);

        while(!q.isEmpty()) {
            int now = q.poll();
            if (now == K) {
                if (visited[now] < minTime) {
                    minTime = visited[now];
                    count = 1;
                } else if (minTime == visited[now]) {
                    count++;
                }
                continue;
            }


            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next > 100000) continue;

                if (visited[next] == -1 || visited[next] == visited[now] + 1) {
                    if (visited[next] == -1) {
                        q.offer(next);
                        visited[next] = visited[now] + 1;
                    } else {
                        q.offer(next);
                    }
                }
            }
        }

        sb.append(minTime).append("\n").append(count);
    }
}