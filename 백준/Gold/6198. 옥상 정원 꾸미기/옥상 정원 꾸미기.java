import java.io.*;
import java.util.*;

public class Main {
    static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, heights[];
    static Queue<int[]> viruses[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        long answer = 0;

        for (int i = 0; i < N; i++) {
            int cur = heights[i];

            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }

            answer += stack.size();

            stack.push(cur);
        }

        System.out.println(answer);
    }
}
