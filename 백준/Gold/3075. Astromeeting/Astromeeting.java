import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, p, q, starts[];
    static long map[][];
    static class Edge {
        int from, d;

        public Edge(int from, int d) {
            this.from = from;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            starts = new int[p+1];
            for (int i = 0; i < n; i++) {
                starts[Integer.parseInt(br.readLine())]++;
            }
            map = new long[p+1][p+1];
            for (int i = 0; i <= p; i++) {
                Arrays.fill(map[i], n*p*q*100L);
                map[i][i] = 0;
            }
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                map[to][from] = Math.min(map[to][from],d);
                map[from][to] = Math.min(map[to][from],d);
            }
            floyd();
            calc();
        }
        System.out.println(sb);
    }

    static void calc() {
        long minDist = Long.MAX_VALUE;
        int minIdx = -1;
        for (int i = 1; i <= p; i++) {
            long dist = 0;
            for (int j = 1; j <= p; j++) {
                if (starts[j] == 0) continue;
                dist += map[j][i] * map[j][i] * starts[j];
//                System.out.println(i + "|" + j);
            }
            if (minDist > dist) {
                minDist = dist;
                minIdx = i;
            }
        }
        sb.append(minIdx).append(" ").append(minDist).append("\n");
    }

    static void floyd() {
        for (int k = 1; k <= p; k++) {
            for (int i = 1; i <= p; i++) {
                for (int j = 1; j <= p; j++) {
                    if (i == j) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }

}
