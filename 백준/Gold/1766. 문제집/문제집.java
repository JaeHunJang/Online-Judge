import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, indegree[];
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            indegree[to]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int now = q.poll();
                sb.append(now).append(" ");

                for (int next : list[now]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
