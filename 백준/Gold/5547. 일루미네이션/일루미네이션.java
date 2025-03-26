import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int W, H, map[][], result[][];
//    (x, y) 기준 y가 세로축, x가 가로축 -> 배열에서는 좌표를 반대로 봐야함
//    y가 홀수 일 때, 아래쪽에 있는 정육각형의 좌표는 (x,y+1)이다.
//    y가 짝수 일 때, 오른쪽 아래에 있는 정육각형의 좌표는 (x,y+1)이다.
    static int[][] deltasOdd = {{-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
    static int[][] deltasEven = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, -1}, {1, 0}};
    static boolean visited[][];

    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H+2][W+2];
        result = new int[H+2][W+2];
        visited = new boolean[H+2][W+2];

        for (int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(new Pos(0, 0));

        int totalCnt = 0;
        for (int i = 0; i < H+2; i++) {
            for (int j = 0; j < W+2; j++) {
                totalCnt += result[i][j];
            }
        }

        System.out.println(totalCnt);
    }

    static void bfs(Pos start) {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(start);
        visited[start.r][start.c] = true;

        while (!q.isEmpty()) {
            Pos now = q.poll();

            int deltas[][] = (now.r % 2 == 1) ? deltasOdd : deltasEven;
            for (int d = 0; d < deltas.length; d++) {
                int nr = now.r + deltas[d][0];
                int nc = now.c + deltas[d][1];

                if (nr < 0 || nr >= H+2 || nc < 0 || nc >= W+2 || visited[nr][nc]) continue;
                if (map[nr][nc] == 1) {
                    result[now.r][now.c]++; // 경계선을 계산
                    continue;
                }
                visited[nr][nc] = true;
                q.offer(new Pos(nr, nc));
            }
        }
    }
}