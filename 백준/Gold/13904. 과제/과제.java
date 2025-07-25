import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Report {
        int d, w;

        public Report(int d, int w) {
            this.d = d;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Report{" +
                    "d=" + d +
                    ", w=" + w +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Report> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.w, o1.w));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            q.offer(new Report(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

//        for (Report r : q) {
//            System.out.println(r);
//        }
        int[] scores = new int[1001];

        while (!q.isEmpty()) {
            Report r = q.poll();
            for (int i = r.d; i > 0; i--) {
                if (scores[i] < r.w) {
                    scores[i] = r.w;
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(scores));

        int totalScore = 0;
        for (int s : scores) {
            totalScore += s;
        }

        System.out.println(totalScore);
    }
}
