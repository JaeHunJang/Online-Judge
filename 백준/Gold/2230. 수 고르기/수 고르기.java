import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);

        int start = 0, end = 1;
        int result = Integer.MAX_VALUE;
        while (end < N) {
            int n = nums[end] - nums[start];
            if (n == M) {
                System.out.println(M);
                return;
            }

            if (n >= M) {
                result = Math.min(result, n);
                start++;
            } else {
                end++;
            }
        }
        System.out.println(result);
    }
}