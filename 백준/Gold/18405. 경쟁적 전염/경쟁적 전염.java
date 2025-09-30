import java.io.*;
import java.util.*;

public class Main {
    static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, K, map[][], S, X, Y;
    static Queue<int[]> viruses[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        viruses = new Queue[K+1];
        for (int i = 0; i < viruses.length; i++) {
            viruses[i] = new ArrayDeque<>();
        }

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                viruses[map[i][j]].offer(new int[] {i, j});
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        while (S-- > 0) {
            for (int n = 1; n < viruses.length; n++) {
                int size = viruses[n].size();

                while (size-- > 0) {
                    int[] cur = viruses[n].poll();

                    for (int[] d : deltas) {
                        int nr = d[0] + cur[0];
                        int nc = d[1] + cur[1];

                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                        if (map[nr][nc] > 0) continue;
                        map[nr][nc] = n;
                        viruses[n].offer(new int[] {nr, nc});
                    }
                }
            }
        }

        System.out.println(map[X-1][Y-1]);
    }
}
