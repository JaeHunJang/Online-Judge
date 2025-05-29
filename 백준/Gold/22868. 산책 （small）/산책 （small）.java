import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, S, E;
    static List<Integer>[] list;
    static class Node {
        int to;
        List<Integer> h;

        public Node(int to) {
            this.to = to;
            this.h = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        for (int i = 0; i < list.length; i++) {
            Collections.sort(list[i]);
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N+1];
        List<Integer> history = bfs(S, E, visited);
        int dist = history.size();

        visited = new boolean[N+1];
        for (int n : history) {
            visited[n] = true;
        }
        dist += bfs(E, S, visited).size();
        System.out.println(dist);
    }


    static List<Integer> bfs(int s, int e, boolean[] visited) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(s));
        visited[s] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.to == e) {
                return now.h;
            }

            for (int next : list[now.to]) {
                if (visited[next]) continue;
                visited[next] = true;
                Node n = new Node(next);
                n.h.addAll(now.h);
                n.h.add(next);
                q.offer(n);
            }
        }

        return null;
    }
}