import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, parents[], distances[];
    static boolean visited[], inCycle[];
    static List<Integer> list[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        visited = new boolean[N+1];
        inCycle = new boolean[N+1];
        parents = new int[N+1];
        distances = new int[N+1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }


        dfs(1, -1);

        calcDist();


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(distances[i]).append(' ');
        System.out.println(sb);
    }

    static boolean dfs(int now, int parent) {
        visited[now] = true;
        for (int next : list[now]) {
            if (next == parent) continue;
            if (!visited[next]) {
                parents[next] = now;
                if (dfs(next, now)) return true;
            } else {
                markCycle(now, next);
                return true;
            }
        }

        return false;
    }

    static void markCycle(int now, int next) {
        inCycle[next] = true;
        int cur = now;
        while (cur != next) {
            inCycle[cur] = true;
            cur = parents[cur];
        }
    }

    static void calcDist() {
        Queue<Integer> q = new ArrayDeque<>();
        Arrays.fill(distances, -1);
        for (int i = 1; i <= N; i++) {
            if (inCycle[i]) {
                q.offer(i);
                distances[i] = 0;
            }
        }

        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int now = q.poll();
                for (int next : list[now]) {
                    if (distances[next] == -1) {
                        distances[next] = dist;
                        q.offer(next);
                    }
                }
            }
            dist++;
        }
    }
}
