import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
    static char[][] map;
    static final int ROW = 12, COL = 6;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[ROW][COL];
        visited = new boolean[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            String input = br.readLine();
            for (int j = 0; j < COL; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int cnt = 0;
        while (search()) {
            downBlock();
            cnt++;
        }

        System.out.println(cnt);
    }

    static boolean search() {
        visited = new boolean[ROW][COL];

        boolean isChain = false;
        for (int i = ROW-1; i >= 0; i--) {
            for (int j = 0; j < COL; j++) {
                if (map[i][j] != '.' && !visited[i][j]) {
                    if (bfs(i, j)) {
                        isChain = true;
                    }
                }
            }
        }
        return isChain;
    }

    static boolean bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        char color = map[i][j];
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {i, j});

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for (int d = 0; d < deltas.length; d++) {
                int nr = pos[0] + deltas[d][0];
                int nc = pos[1] + deltas[d][1];
                if (nr < 0 || nr >= ROW || nc < 0 || nc >= COL || visited[nr][nc] || map[nr][nc] != color || map[nr][nc] == '.') continue;
                visited[nr][nc] = true;
                list.add(new int[]{nr, nc});
                q.offer(new int[]{nr, nc});
            }
        }

        if (list.size() >= 4) {
            for (int[] pos : list) {
                map[pos[0]][pos[1]] = '.';
            }
            return true;
        }

        return false;
    }

    static void downBlock() {
        for (int j = 0; j < COL; j++) {
            Queue<Character> q = new ArrayDeque<>();
            for (int i = ROW-1; i >= 0; i--) {
                if (map[i][j] != '.') {
                    q.offer(map[i][j]);
                }
            }

            int i = ROW-1;
            while (!q.isEmpty()) {
                map[i][j] = q.poll();
                i--;
            }
            while (i >= 0) {
                map[i][j] = '.';
                i--;
            }
        }
    }
}
