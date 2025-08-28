import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, K, max, len;
    static Set<Integer> vistied;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = st.nextToken();
        len = input.length();
        N = Integer.parseInt(input);
        K = Integer.parseInt(st.nextToken());

        vistied = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);

        while (K-- > 0 && !q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                for (int i = 0; i < len; i++) {
                    for (int j = i+1; j < len; j++) {
                        int next = swap(cur, i, j);
                        if (String.valueOf(next).length() != len) continue;
                        if (vistied.contains(next)) continue;
                        vistied.add(next);
                        q.offer(next);
                    }
                }
            }
            vistied.clear();
        }

        max = -1;
        while (!q.isEmpty()) {
            int now = q.poll();
            max = Math.max(max, now);
        }


        System.out.println(max);
    }
    static int swap(int n, int i, int j) {
        sb.setLength(0);
        sb.append(n);
        char t = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, t);

        return Integer.parseInt(sb.toString());
    }
}