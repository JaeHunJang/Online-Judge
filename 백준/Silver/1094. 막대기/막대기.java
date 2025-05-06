import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(64);

        while (!q.isEmpty()) {
            int total = totalDist(q);
            if (total == X) {
                System.out.println(q.size());
                return;
            } else if (total > X) {
                int half = q.poll()/2;
                total = totalDist(q);
                if (total + half == X) {
                    System.out.println(q.size() + 1);
                    return;
                } else if (total + half > X) {
                    q.offer(half);
                } else {
                    q.offer(half);
                    q.offer(half);
                }
            }
        }
    }

    static int totalDist(PriorityQueue<Integer> q) {
        int sum = 0;
        for (int n : q) {
            sum += n;
        }
        return sum;
    }
}