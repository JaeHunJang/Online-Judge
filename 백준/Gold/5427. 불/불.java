import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, w, h, visited[][], deltas[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static char map[][];
    static Queue<int[]> nextFire;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            nextFire = new ArrayDeque<>();
            map = new char[h + 2][w + 2];
            for (int i = 0; i < map.length; i++) {
                Arrays.fill(map[i], '.');
            }
            int sr = 0, sc = 0;
            for (int i = 1; i <= h; i++) {
                String input = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = input.charAt(j - 1);
                    if (map[i][j] == '@') {
                        sr = i;
                        sc = j;
                    }
                    if (map[i][j] == '*') {
                        nextFire.offer(new int[] {i, j});
                    }
                }
            }

            int time = move(sr, sc);

            if (time == -1) System.out.println("IMPOSSIBLE");
            else System.out.println(time);
        }
    }

    static int move(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        int time = 0;
        visited = new int[h + 2][w + 2];
        visited[r][c] = time + 1;
        map[r][c] = '.';
        while (!q.isEmpty()) {
            int size = q.size();
            fire();

//            System.out.println("size : " + size);
            while (size-- > 0) {
                int[] cur = q.poll();

                if (cur[0] < 1 || cur[0] > h || cur[1] < 1 || cur[1] > w) {
                    return time;
                }
                for (int d = 0; d < deltas.length; d++) {
                    int nr = cur[0] + deltas[d][0];
                    int nc = cur[1] + deltas[d][1];

                    if (nr < 0 || nr > h + 1 || nc < 0 || nc > w + 1 || visited[nr][nc] > 0 || map[nr][nc] != '.')
                        continue;
                    visited[nr][nc] = time + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
            time++;
        }

        return -1;
    }

    static void fire() {
        Queue<int[]> q = new ArrayDeque<>();

        while (!nextFire.isEmpty()) {
            int[] cur = nextFire.poll();

            for (int d = 0; d < deltas.length; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];

                if (nr < 1 || nr > h || nc < 1 || nc > w || map[nr][nc] == '#' || map[nr][nc] == '*') continue;
                map[nr][nc] = '*';
                q.offer(new int[] {nr ,nc});
            }
        }

        nextFire.addAll(q);
    }
}
