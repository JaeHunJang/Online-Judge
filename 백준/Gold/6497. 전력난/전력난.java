import java.io.*;
import java.util.*;

public class Main {
    static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int m, n;
    static int parents[];
    static Queue<int[]> viruses[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        do {
            PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
            int total = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                total += z;
                q.offer(new int[] {x, y, z});
            }

            parents = new int[m];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }

            int sum = 0, cnt = 0;
            while (!q.isEmpty()) {
//            System.out.println(Arrays.toString(q.peek()));
                int x = q.peek()[0];
                int y = q.peek()[1];
                int z = q.poll()[2];

                if (union(x, y)) {
                    sum += z;
                    cnt++;
                }

                if (cnt == m-1) break;
            }

            System.out.println(total - sum);
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
        } while (m != 0 && n != 0);
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
