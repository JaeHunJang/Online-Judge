import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int n = input.charAt(i) - '0';
            while (!stack.isEmpty() && K > 0 && stack.peek() < n) {
                stack.pop();
                K--;
            }
            stack.push(n);
        }

        while (K > 0) {
            stack.pop();
            K--;
        }
        StringBuilder sb = new StringBuilder();
        for (int n : stack) {
            sb.append(n);
        }
        System.out.println(sb);
    }
}
