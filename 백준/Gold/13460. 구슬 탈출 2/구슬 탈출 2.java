import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
    static Pos redStart, blueStart;

    static class State {
        int rr, rc, br, bc, depth;

        State(int rr, int rc, int br, int bc, int depth) {
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;
            this.depth = depth;
        }
    }

    static class Pos {
        int r, c;
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    redStart = new Pos(i, j);
                    map[i][j] = '.';
                }
                if (map[i][j] == 'B') {
                    blueStart = new Pos(i, j);
                    map[i][j] = '.';
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<State> q = new ArrayDeque<>();
        visited = new boolean[N][M][N][M];
        q.offer(new State(redStart.r, redStart.c, blueStart.r, blueStart.c, 0));
        visited[redStart.r][redStart.c][blueStart.r][blueStart.c] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.depth >= 10) return -1;

            for (int d = 0; d < 4; d++) {
                int[] redMove = move(cur.rr, cur.rc, d);
                int[] blueMove = move(cur.br, cur.bc, d);

                int nr_r = redMove[0], nr_c = redMove[1], redCount = redMove[2];
                int nb_r = blueMove[0], nb_c = blueMove[1], blueCount = blueMove[2];

                // 파란 공이 구멍에 들어간 경우: 실패
                if (map[nb_r][nb_c] == 'O') continue;

                // 빨간 공만 구멍에 들어간 경우: 성공
                if (map[nr_r][nr_c] == 'O') return cur.depth + 1;

                // 둘 다 같은 위치에 있으면, 이동 횟수가 많은 공을 한 칸 뒤로
                if (nr_r == nb_r && nr_c == nb_c) {
                    if (redCount > blueCount) {
                        nr_r -= deltas[d][0];
                        nr_c -= deltas[d][1];
                    } else {
                        nb_r -= deltas[d][0];
                        nb_c -= deltas[d][1];
                    }
                }

                if (!visited[nr_r][nr_c][nb_r][nb_c]) {
                    visited[nr_r][nr_c][nb_r][nb_c] = true;
                    q.offer(new State(nr_r, nr_c, nb_r, nb_c, cur.depth + 1));
                }
            }
        }

        return -1;
    }

    static int[] move(int r, int c, int d) {
        int count = 0;
        while (true) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            if (map[nr][nc] == '#') break;
            r = nr;
            c = nc;
            count++;
            if (map[r][c] == 'O') break;
        }
        return new int[]{r, c, count};
    }
}
