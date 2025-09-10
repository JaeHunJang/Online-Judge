import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static boolean[] stands;
    static Queue<int[]> karts = new ArrayDeque<>();
    static long answer = 0;

    static class Stand {
        int k;   // 계산대 번호
        int id;  // 고객 id
        int w;   // 계산 소요시간

        Stand(int k, int id, int w) {
            this.k = k;
            this.id = id;
            this.w = w;
        }
    }

    static class Cmp implements Comparator<Stand> {
        @Override
        public int compare(Stand a, Stand b) {
            return Integer.compare(a.w, b.w); // w 작은 순
        }
    }

    static class OutCmp implements Comparator<Stand> {
        @Override
        public int compare(Stand a, Stand b) {
            if (a.w == b.w) {
                return Integer.compare(b.k, a.k); // w 같으면 k 큰 순
            }
            return Integer.compare(a.w, b.w); // w 작은 순
        }
    }

    static void pay() {
        PriorityQueue<Stand> pq = new PriorityQueue<>(new Cmp());
        long cnt = 1;

        int k = 1;
        while (pq.size() < K && !karts.isEmpty()) {
            int[] cur = karts.poll();
            int id = cur[0];
            int w = cur[1];
            stands[k] = true;
            pq.offer(new Stand(k++, id, w));
        }

        PriorityQueue<Stand> outNum = new PriorityQueue<>(new OutCmp());

        while (pq.size() >= K) {
            Queue<Stand> temp = new ArrayDeque<>();
            Stand thisOut = pq.poll();
            stands[thisOut.k] = false;
            outNum.offer(new Stand(thisOut.k, thisOut.id, thisOut.w));

            int size = pq.size();
            while (size-- > 0) {
                Stand cur = pq.poll();
                if (cur.w == thisOut.w) {
                    stands[cur.k] = false;
                    outNum.offer(new Stand(cur.k, cur.id, cur.w));
                } else {
                    temp.offer(new Stand(cur.k, cur.id, cur.w - thisOut.w));
                }
            }

            while (!temp.isEmpty()) pq.offer(temp.poll());

            while (pq.size() < K && !karts.isEmpty()) {
                int[] cur = karts.poll();
                int id = cur[0];
                int w = cur[1];

                int i = 1;
                for (; i <= N; ++i)
                    if (!stands[i]) break;

                stands[i] = true;
                pq.offer(new Stand(i, id, w));

                if (karts.isEmpty()) break;
            }

            while (!outNum.isEmpty()) {
                answer += cnt++ * (long) outNum.poll().id;
            }

            if (karts.isEmpty()) break;
        }

        while (!pq.isEmpty()) {
            outNum.offer(pq.poll());
        }

        while (!outNum.isEmpty()) {
            answer += cnt++ * (long) outNum.poll().id;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stands = new boolean[N + 1];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            karts.offer(new int[]{id, w});
        }

        pay();

        System.out.println(answer);
    }
}
