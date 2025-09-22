import java.io.*;
import java.util.*;

public class Main {
    static class Class {
        int s, t;

        public Class(int s, int t) {
            this.s = s;
            this.t = t;
        }

        @Override
        public String toString() {
            return "Class{" +
                    "s=" + s +
                    ", t=" + t +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Class> pq = new PriorityQueue<>((o1, o2) -> {
            int comp = Integer.compare(o1.s, o2.s);
            if (comp == 0) {
                return Integer.compare(o1.t, o2.t);
            }
            return comp;
        });
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            pq.offer(new Class(s, t));
        }
//        System.out.println(pq);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int roomCnt = 0;
        while (!pq.isEmpty()) {
            Class c = pq.poll();

            if (!q.isEmpty() && q.peek() <= c.s) {
                q.poll(); // 수업 끝남
            }
            q.offer(c.t);
            roomCnt = Math.max(roomCnt, q.size());
//            System.out.println(roomCnt + " : " + q);
        }
        System.out.println(roomCnt);
    }
}
