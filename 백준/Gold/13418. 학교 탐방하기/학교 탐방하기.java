import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge {
        int from, to, w;

        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", w=" + w +
                    '}';
        }
    }

    static int N, M, start, cnt, cnt2, parents[];
    static List<Edge> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cnt = 0;
        cnt2 = 0;
        parents = new int[N+1];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        start = w == 1 ? 0 : 1; // 입구에서 처음 도시까지

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list.add(new Edge(from, to, w));
            list.add(new Edge(to, from, w));
        }

        list.sort(((o1, o2) -> Integer.compare(o1.w, o2.w))); // 오르막으로 정렬
//        System.out.println(list);
        make();
        for (int i = 0; i < list.size(); i++) {
            if (union(list.get(i).from, list.get(i).to)) {
                cnt += list.get(i).w == 1 ? 0 : 1;
//                System.out.println(list.get(i));
            }
        }
//        System.out.println();
        make();
        for (int i = list.size()-1; i >= 0; i--) {
            if (union(list.get(i).from, list.get(i).to)) {
                cnt2 += list.get(i).w == 1 ? 0 : 1;
//                System.out.println(list.get(i));
            }
        }
//        System.out.println(cnt);
//        System.out.println(cnt2);
        System.out.println((int) (Math.pow(cnt + start, 2) - Math.pow(cnt2 + start, 2)));
    }

    static void make() {
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
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