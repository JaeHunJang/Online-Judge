import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        List<Integer>[] list = new List[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }
        System.out.println(simulate(a, b, n, list));
    }

    static int simulate(int start, int end, int n, List<Integer>[] list) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        int[] visited = new int[n+1];
        int turn = 1;
        visited[start] = turn++;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int now = q.poll();

                if (visited[end] != 0) return visited[end] - 1;

                for (int next : list[now]) {
                    if (visited[next] > 0) continue;
                    visited[next] = turn;
                    q.offer(next);
                }
            }
            turn++;
        }
        return -1;
    }
}
