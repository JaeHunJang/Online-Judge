import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, six[], one[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        six = new int[M];
        one = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            six[i] = Integer.parseInt(st.nextToken());
            one[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(six);
        Arrays.sort(one);

        if ((six[0] / 6.0) > one[0]) {
            System.out.println(one[0] * N);
        } else {
            int s1 = six[0] * (N / 6) + one[0] * (N % 6);
            int s2 = six[0] * (N / 6) + six[0];
            System.out.println(Math.min(s1, s2));
        }

    }
}