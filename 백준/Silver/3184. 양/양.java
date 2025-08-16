import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, sheep, wolf, deltas[][] = {{0,1},{-1,0},{0,-1},{1,0}};
    static char map[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        sheep = 0;
        wolf = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != '#') {
                    find(i, j);
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    static void find(int r, int c) {
        int sheepCnt = 0, wolfCnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        if (map[r][c] == 'o') sheepCnt++;
        else if (map[r][c] == 'v') wolfCnt++;
        map[r][c] = '#';

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] d : deltas) {
                int nr = now[0] + d[0];
                int nc = now[1] + d[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || map[nr][nc] == '#') continue;
                if (map[nr][nc] == 'o') sheepCnt++;
                else if (map[nr][nc] == 'v') wolfCnt++;
                map[nr][nc] = '#';
                q.offer(new int[] {nr, nc});
            }
        }

//        System.out.println(sheepCnt + " : " + wolfCnt);
//        print();
        if (wolfCnt >= sheepCnt) {
            wolf += wolfCnt;
        } else {
            sheep += sheepCnt;
        }
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
}
