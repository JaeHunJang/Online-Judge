import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static int[] graph;
    static boolean[] visited, done;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            graph = new int[N + 1];
            visited = new boolean[N + 1];
            done = new boolean[N + 1];
            result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) dfs(i);
            }

            sb.append(N - result).append("\n"); // 팀에 속하지 못한 학생 수
        }

        System.out.print(sb);
    }

    static void dfs(int cur) {
        visited[cur] = true;
        int next = graph[cur];

        if (!visited[next]) {
            dfs(next);
        } else if (!done[next]) {
            // 사이클 발견
            for (int i = next; i != cur; i = graph[i]) {
                result++;
            }
            result++; // 자기 자신 포함
        }

        done[cur] = true;
    }
}
