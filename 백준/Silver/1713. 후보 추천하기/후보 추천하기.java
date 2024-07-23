import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 후보 추천하기
public class Main {
    static int N, M;
    static class Picture {
        int num, time, count;

        public Picture(int num, int time, int count) {
            this.num = num;
            this.time = time;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Picture{" +
                    "num=" + num +
                    ", time=" + time +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        PriorityQueue<Picture> frame = new PriorityQueue<>(new Comparator<Picture>() {
            @Override
            public int compare(Picture o1, Picture o2) {
                if (o1.count == o2.count) return Integer.compare(o1.time, o2.time);
                return Integer.compare(o1.count, o2.count);
            }
        });

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            Queue<Picture> temp = new ArrayDeque<>();
            boolean isContains = false;
            while (!frame.isEmpty()) {
                Picture now = frame.poll();
                if (now.num == n) {
                    now.count++;
                    isContains = true;
                }
                temp.offer(now);
            }
            while (!temp.isEmpty()) frame.offer(temp.poll());
            if (!isContains) {
                if (frame.size() >= N) {
                    frame.poll();
                }
                frame.offer(new Picture(n, i, 1));
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!frame.isEmpty()) {
            list.add(frame.poll().num);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}