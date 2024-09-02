import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 순회강연
public class Main {
    static int n;
    static class Pay {
        int p, d;

        public Pay(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Pay{" +
                    "p=" + p +
                    ", d=" + d +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Pay> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.p == o2.p) return Integer.compare(o2.d, o1.d);
            return Integer.compare(o2.p, o1.p);
        });
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new Pay(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int visited[] = new int[10001];
        Arrays.fill(visited, 0);
        while (!pq.isEmpty()) {
            Pay now = pq.poll();
            for (int j = now.d; j > 0; j--) {
                if (visited[j] == 0) {
                    visited[j] = now.p;
                    break;
                }
            }
        }


        int sum = 0;
        for(int p : visited) {
            sum += p;
        }
        System.out.println(sum);
    }
}
