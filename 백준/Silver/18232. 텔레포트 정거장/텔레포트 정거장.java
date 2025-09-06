import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, S, E;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        System.out.println(move());
    }

    static int move() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(S);
        boolean[] visited = new boolean[N+1];
        visited[S] = true;

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == E) return time;

                if (cur-1 >= 1 && !visited[cur-1]) {
                    visited[cur-1] = true;
                    q.offer(cur-1);
                }
                if (cur+1 <= N && !visited[cur+1]) {
                    visited[cur+1] = true;
                    q.offer(cur+1);
                }
                for (int next : list[cur]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    q.offer(next);
                }
            }
            time++;
        }


        return -1;
    }
}
