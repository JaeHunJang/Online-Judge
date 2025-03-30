import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] students = new int[N+3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int sleep = Integer.parseInt(st.nextToken());
            students[sleep] = -1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int qrcode = Integer.parseInt(st.nextToken());
            if (students[qrcode] == -1) continue;
            for (int j = qrcode; j < students.length; j+=qrcode) {
                if (students[j] == -1) continue;
                students[j] = 1;
            }
        }

        int[] dp = new int[N+3];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1];
            if (students[i] <= 0) dp[i]++;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
            System.out.println(dp[end] - dp[start-1]);
        }
    }
}