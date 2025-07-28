import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, total;
    static int[][] map;
    static int[] parents;
    static List<Edge> list;
    static class Edge {
        int to, from, w;

        public Edge(int to, int from, int w) {
            this.to = to;
            this.from = from;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", from=" + from +
                    ", w=" + w +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        total = 0;
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = input.charAt(j);
                if (ch == '0') {
                    map[i][j] = 0;
                } else if (ch >= 'a' && ch <= 'z') {
                    map[i][j] = ch - 'a' + 1;
                } else {
                    map[i][j] = ch - 'A' + 27;
                }
                total += map[i][j];
                if (map[i][j] == 0 || i == j) continue;
                list.add(new Edge(i, j, map[i][j]));
                list.add(new Edge(j, i, map[i][j]));
            }
//            System.out.println(Arrays.toString(map[i]));
        }
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
        Collections.sort(list, (o1, o2) -> Integer.compare(o1.w, o2.w));
//        System.out.println(list);

        int min = 0, cnt = 0;
        for (Edge e : list) {
            if (union(e.to, e.from)) {
                min += e.w;
                cnt++;
            }

            if (cnt == N-1) break;
        }

        if (cnt != N-1) System.out.println(-1);
        else System.out.println(total - min);
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
