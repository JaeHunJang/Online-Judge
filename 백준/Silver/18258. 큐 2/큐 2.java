import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if ("push".equals(cmd)) {
                int n = Integer.parseInt(st.nextToken());
                q.offer(n);
                continue;
            } else if ("front".equals(cmd)) {
                if (q.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(q.peek());
                }
            } else if ("back".equals(cmd)) {
                if (q.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(q.peekLast());
                }
            } else if ("size".equals(cmd)) {
                sb.append(q.size());
            } else if ("empty".equals(cmd)) {
                if (q.isEmpty()) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            } else if ("pop".equals(cmd)) {
                if (q.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(q.poll());
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
