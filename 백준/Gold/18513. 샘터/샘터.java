import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 샘터 / 50분
public class Main {
    static int N, K, deltas[] = {1, -1};
    static HashMap<Integer, Integer> map;
    static Queue<Integer> q;
    static long sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sum = 0;
        map = new HashMap<>();
        q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int pos = Integer.parseInt(st.nextToken());
            q.offer(pos);
            map.put(pos, 0);
        }

        bfs();

        System.out.println(sum);
    }

    static void bfs() {
        int cnt = 0;
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int d = 0; d < deltas.length; d++) {
                int next = now + deltas[d];
                if (!map.containsKey(next)) { // 샘물이나 집이 있음
                    map.put(next, map.get(now) + 1);
                    sum += map.get(next);
                    cnt++;
                    q.offer(next);
                    if (cnt == K) return;
                }
            }
        }
    }
}