import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static List<Node>[] list;
    static class Node {
        int b, p, q;

        public Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        list = new List[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        long lcm = 1;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, p, q));
            list[b].add(new Node(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }

        long[] nums = new long[N];
        nums[0] = lcm;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        boolean[] visited = new boolean[N];
        visited[0] = true;
        while (!q.isEmpty()) {
            int now = q.poll();

            for (Node next : list[now]) {
                if (visited[next.b]) continue;
                visited[next.b] = true;
                nums[next.b] = nums[now] * next.q / next.p;
                q.offer(next.b);
            }
        }

        long gcd = nums[0];
        for (int i = 1; i < N; i++) {
            gcd = gcd(gcd, nums[i]);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(nums[i] / gcd + " ");
        }
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}