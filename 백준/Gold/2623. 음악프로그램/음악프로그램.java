import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N+1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        int degrees[] = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int m = Integer.parseInt(st.nextToken());
                list[n].add(m);
                degrees[m]++;
                n = m;
            }
        }
//        for (int i = 1; i <= N; i++) {
//            System.out.println(list[i]);
//        }

//        System.out.println(Arrays.toString(degrees));
//        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.d, o2.d));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < degrees.length; i++) {
            if (degrees[i] == 0) {
//                q.offer(new Node(i, 0));
                q.offer(i);
            }
        }
        if (q.isEmpty()) {
            System.out.println(0);
            return;
        }
        int cnt = 0;
//        System.out.println(q);
        while (!q.isEmpty()) {
//            Node now = q.poll();
            int now = q.poll();
            sb.append(now).append("\n");
            cnt++;
            for (int next : list[now]) {
                degrees[next]--;
                if (degrees[next] == 0) {
                    q.offer(next);
//                    q.offer(new Node(next, 0));
                }
            }
        }
//        System.out.println(Arrays.toString(degrees));
        if (cnt != N) {
            System.out.println(0);
            return;
        }
        System.out.println(sb);
    }
    static class Node {
        int to, d;

        public Node(int to, int d) {
            this.to = to;
            this.d = d;
        }
    }
}