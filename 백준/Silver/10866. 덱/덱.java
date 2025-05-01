import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayDeque q = new ArrayDeque();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if ("push_front".equals(cmd)) {
                q.offerFirst(Integer.parseInt(st.nextToken()));
            } else if ("push_back".equals(cmd)) {
                q.offerLast(Integer.parseInt(st.nextToken()));
            } else if ("pop_front".equals(cmd)) {
                if (q.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(q.poll());
                }
                sb.append("\n");
            } else if ("pop_back".equals(cmd)) {
                if (q.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(q.pollLast());
                }
                sb.append("\n");
            } else if ("size".equals(cmd)) {
                sb.append(q.size()).append("\n");
            } else if ("empty".equals(cmd)) {
                sb.append(q.isEmpty() ? 1 : 0).append("\n");
            } else if ("front".equals(cmd)) {
                sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
            } else if ("back".equals(cmd)) {
                sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
            }
        }

        System.out.println(sb);
    }
}