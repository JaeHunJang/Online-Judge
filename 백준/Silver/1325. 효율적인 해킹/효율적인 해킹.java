import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, indegrees[];
    static List<Integer> list[], answer;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n+1];
        answer = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        indegrees = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
            indegrees[a]++;
        }
//        System.out.println(Arrays.toString(list));
//        System.out.println(Arrays.toString(indegrees));

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int now = bfs(i);
//            System.out.println(now);
            if (now > max) {
                answer.clear();
                max = now;
            }
            if (now == max) {
                answer.add(i);
            }
        }

        Collections.sort(answer);
        for (int c : answer) {
            System.out.print(c + " ");
        }
    }

    static int bfs(int c) {
        visited = new boolean[n+1];
        visited[c] = true;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(c);
        int cnt = 1;
        while (!q.isEmpty()) {
            int now = q.poll();

            for(int next : list[now]) {
                if (visited[next]) continue;
                visited[next] = true;
                cnt++;
                q.offer(next);
            }
        }

        return cnt;
    }
}
