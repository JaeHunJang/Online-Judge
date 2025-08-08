import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] g;
    static List<int[]> empties = new ArrayList<>();
    static List<int[]> villages = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        g = new int[N][M];

        for (int r = 0; r < N; r++) {
            String line = br.readLine().trim();
            for (int c = 0; c < M; c++) {
                g[r][c] = line.charAt(c) - '0';
                if (g[r][c] == 0) empties.add(new int[]{r, c});
                else villages.add(new int[]{r, c});
            }
        }

        if (villages.isEmpty()) {
            System.out.println(0);
            return;
        }

        int E = empties.size();
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < E; i++) {
            int[] e1 = empties.get(i);
            for (int j = i + 1; j < E; j++) {
                int[] e2 = empties.get(j);

                int worst = 0;
                for (int[] v : villages) {
                    int d1 = Math.abs(v[0] - e1[0]) + Math.abs(v[1] - e1[1]);
                    int d2 = Math.abs(v[0] - e2[0]) + Math.abs(v[1] - e2[1]);
                    int bestForV = Math.min(d1, d2);
                    if (bestForV > worst) worst = bestForV;

                    // 가지치기
                    if (worst >= best) break;
                }
                if (worst < best) best = worst;
            }
        }

        System.out.println(best);
    }
}
