import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static long[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);
        long minSum = Long.MAX_VALUE;
        long[] answer = new long[3];

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum) < minSum) {
                    minSum = Math.abs(sum);
                    answer[0] = nums[i];
                    answer[1] = nums[left];
                    answer[2] = nums[right];
                }

                if (sum < 0) left++;
                else right--;
            }
        }

        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
