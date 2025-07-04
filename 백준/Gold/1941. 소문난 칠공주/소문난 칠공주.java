import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int maxCnt, selected[], visited[][], deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        visited = new int[5][5];
        selected = new int[7];
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        maxCnt = 0;

        dfs(0, 0, 0, 0);

        System.out.println(maxCnt);
    }

    static void dfs(int start, int cnt, int ycnt, int scnt) {
        if (ycnt >= 4) return;
        if (cnt == 7 && scnt >= 4) {
            if (bfs()) {
                maxCnt++;
//                System.out.println(Arrays.toString(selected));
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;
            if (visited[r][c] > 0) continue;
            visited[r][c] = cnt;
            selected[cnt] = i;
            if (map[r][c] == 'S') {
                dfs(i+1, cnt+1, ycnt, scnt+1);
            } else {
                dfs(i+1, cnt+1, ycnt+1, scnt);
            }
            visited[r][c] = 0;
        }
    }

    static boolean bfs() {
        int r = selected[0] / 5;
        int c = selected[0] % 5;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        int[][] visited2 = new int[5][5];
        visited2[r][c] = 1;

        int cnt = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] d : deltas) {
                int nr = now[0] + d[0];
                int nc = now[1] + d[1];
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visited2[nr][nc] > 0) continue;
                visited2[nr][nc] = 1;
                if (visited[nr][nc] > 0) {
                    cnt++;
                    q.offer(new int[] {nr, nc});
                }
            }
        }

        return cnt == 7;
    }
}
