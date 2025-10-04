import java.io.*;
import java.util.*;

public class Main {
    static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, M, k, A[], parents[];
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        A = new int[N+1];
        parents = new int[N+1];
        st = new StringTokenizer(br.readLine());
        list = new List[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[v].add(w);
            list[w].add(v);

            union(v, w);
        }

        for (int i = 0; i <= N; i++) {
            find(i);
        }


        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 1; i <= N; i++) {
            List<Integer> tmp = map.getOrDefault(parents[i], new ArrayList<>());
            tmp.add(i);
            map.put(parents[i], tmp);
        }

        int sum = 0;
        for (int key : map.keySet()) {
            int min = 10001;
            for (int v : map.get(key)) {
                min = Math.min(min, A[v]);
            }
            sum += min;
        }

        if (sum > k) {
            System.out.println("Oh no");
        } else {
            System.out.println(sum);
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
