import java.io.*;
import java.util.*;

public class Main {
    static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 1 : stack.push(Integer.parseInt(st.nextToken())); break;
                case 2 : sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n"); break;
                case 3 : sb.append(stack.size()).append("\n"); break;
                case 4 : sb.append(stack.isEmpty() ? 1 : 0).append("\n"); break;
                case 5 : sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n"); break;
            }
        }

        System.out.println(sb.toString());
    }
}
