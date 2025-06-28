import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, inDegrees[], times[], answer[];
    static List<Integer> list[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        inDegrees = new int[N+1];
        times = new int[N+1];
        answer = new int[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                if (n == -1) break;
                inDegrees[i]++;
                list[n].add(i);
            }
        }


        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegrees[i] == 0) {
                answer[i] = times[i];
                q.offer(new int[] {i, answer[i]});
            }
        }
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int next : list[now[0]]) {
                if (inDegrees[next] > 0) {
                    inDegrees[next]--;
                    answer[next] = Math.max(answer[next], answer[now[0]]);
                    if (inDegrees[next] == 0) {
                        answer[next] += times[next];
                        q.offer(new int[]{next, answer[next]});
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }
}