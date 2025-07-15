import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, order[], idx;
    static List<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 순서 입력
        order = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(isValidBFSOrder() ? 1 : 0);
    }

    static boolean isValidBFSOrder() {
        if (order[0] != 1) return false; // 시작이 1이 아니면 잘못된 순서

        visited = new int[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = 1;
        int idx = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // 현재 정점에서 방문할 수 있는 자식 노드들을 집합으로 저장
            Set<Integer> children = new HashSet<>();
            for (int next : graph[cur]) {
                if (visited[next] == 0) {
                    children.add(next);
                    visited[next] = 1;
                }
            }

            // 입력된 순서대로 자식 노드가 나오는지 확인
            for (int i = 0; i < children.size(); i++) {
                if (idx >= N || !children.contains(order[idx])) {
                    return false;
                }
                queue.offer(order[idx]);
                idx++;
            }
        }

        return true;
    }
}
