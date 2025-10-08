import java.io.*;
import java.util.*;

public class Main {
    static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, M;
    static int[] parent;
    static boolean[] hasCycle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            parent = new int[N + 1];
            hasCycle = new boolean[N + 1];
            for (int i = 1; i <= N; i++) parent[i] = i;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            // 루트 정리
            for (int i = 1; i <= N; i++) find(i);

            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                int root = parent[i];
                if (!hasCycle[root]) set.add(root);
            }

            sb.append("Case ").append(T++).append(": ");
            if (set.size() == 0) sb.append("No trees.");
            else if (set.size() == 1) sb.append("There is one tree.");
            else sb.append("A forest of ").append(set.size()).append(" trees.");
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            hasCycle[pa] = true; // 사이클 발생
            return;
        }

        // 한쪽이 이미 사이클이면 부모로 올라가도 유지
        if (hasCycle[pa] || hasCycle[pb])
            hasCycle[pa] = hasCycle[pb] = true;

        parent[pb] = pa;
    }
}
