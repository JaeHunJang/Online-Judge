import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 합이 0
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long answer = 0;
        int num[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int sum = num[i] + num[left] + num[right];

                if (sum == 0) {
                    // 중복 처리
                    if (num[left] == num[right]) {
                        int count = right - left + 1;
                        answer += (long) count * (count - 1) / 2;
                        break;
                    } else {
                        int leftCount = 1;
                        int rightCount = 1;

                        while (left + 1 < right && num[left] == num[left + 1]) {
                            leftCount++;
                            left++;
                        }
                        while (right - 1 > left && num[right] == num[right - 1]) {
                            rightCount++;
                            right--;
                        }

                        answer += (long) leftCount * rightCount;
                        left++;
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(answer);
    }
}