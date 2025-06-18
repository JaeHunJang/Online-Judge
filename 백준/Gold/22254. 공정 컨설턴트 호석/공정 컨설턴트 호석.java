import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, X, gift[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        gift = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gift[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1, right = N;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (simulation(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
//        System.out.println(right);
    }

    static boolean simulation(int n) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) q.offer(0);

        for (int i = 0; i < N; i++) {
            int now = q.poll() + gift[i];
            if (now > X) return false;
            q.offer(now);
        }

        return true;
    }
}