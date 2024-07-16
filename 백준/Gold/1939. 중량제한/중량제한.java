import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 중량제한 / 60분
public class Main {
    static int N, M, parents[], weights[];
    static List<Edge> list;

    static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        int from, to, w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list.add(new Edge(from, to, w));
            list.add(new Edge(to, from, w));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());


        parents = new int[N+1];
        weights = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        Collections.sort(list, ((o1, o2) -> Integer.compare(o2.weight, o1.weight)));

        int answer = 0;
        int cnt = 0;
        for (Edge edge : list) {
            if (union(edge.from, edge.to)) {
                cnt++;
                answer = Math.max(answer, edge.weight);
            }
            if (find(A) == find(B)) {
                System.out.println(edge.weight);
                break;
            }
            if (cnt == N-1) break;
        }
    }

    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;
        parents[pa] = pb;
        return true;
    }
}