import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static PriorityQueue<Integer> q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(br.readLine()));
        }
        int result = 0;

        while (q.size() > 1) {
            int sum = q.poll() + q.poll();

            result += sum;
            q.offer(sum);
        }

        System.out.println(result);
    }
}
