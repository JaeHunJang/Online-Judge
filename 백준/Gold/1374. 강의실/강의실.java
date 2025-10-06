import java.io.*;
import java.util.*;

public class Main {
    static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N;
    static class Class {
        int n;
        long s, e;

        public Class(int n, long s, long e) {
            this.n = n;
            this.s = s;
            this.e = e;
        }

        @Override
        public String toString() {
            return "Class{" +
                    "n=" + n +
                    ", s=" + s +
                    ", e=" + e +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        PriorityQueue<Class> q = new PriorityQueue<>((o1, o2) -> {
            if (Long.compare(o1.s, o2.s) == 0) {
                return Long.compare(o1.e, o2.e);
            }
            return Long.compare(o1.s, o2.s);
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            q.offer(new Class(n, s, e));
        }
        PriorityQueue<Long> room = new PriorityQueue<>((o1, o2) -> Long.compare(o1, o2));
        while (!q.isEmpty()) {
            Class c = q.poll();
            if (!room.isEmpty() && room.peek() <= c.s) room.poll();
            room.offer(c.e);
        }
        System.out.println(room.size());
    }
}
