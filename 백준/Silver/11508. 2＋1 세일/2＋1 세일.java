import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] items = new int[N];

        for (int i = 0; i < N; i++) {
            items[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(items);

        int sum = 0;
        for (int i = N-1, cnt = 0; i >= 0; i--, cnt++) {
            if (cnt % 3 == 2) continue;
            sum += items[i];
        }

        System.out.println(sum);
    }
}