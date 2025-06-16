import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] towers = new int[100001];
        int[] cnt = new int[100001];
        int[] near = new int[100001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack1 = new Stack<>(); // (높이, 인덱스)

        // 오른쪽 탐색
        for (int i = N; i >= 1; i--) {
            while (!stack1.isEmpty() && stack1.peek()[0] <= towers[i]) {
                stack1.pop();
            }
            cnt[i] += stack1.size();
            if (!stack1.isEmpty()) {
                near[i] = stack1.peek()[1];
            }
            stack1.push(new int[]{towers[i], i});
        }

        Stack<int[]> stack2 = new Stack<>(); // (높이, 인덱스)

        // 왼쪽 탐색
        for (int i = 1; i <= N; i++) {
            while (!stack2.isEmpty() && stack2.peek()[0] <= towers[i]) {
                stack2.pop();
            }
            cnt[i] += stack2.size();
            if (!stack2.isEmpty()) {
                if (near[i] == 0) {
                    near[i] = stack2.peek()[1];
                } else if (Math.abs(i - near[i]) >= Math.abs(i - stack2.peek()[1])) {
                    near[i] = stack2.peek()[1];
                }
            }
            stack2.push(new int[]{towers[i], i});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == 0) {
                sb.append("0\n");
            } else {
                sb.append(cnt[i]).append(" ").append(near[i]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
