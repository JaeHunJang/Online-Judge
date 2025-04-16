import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] A, visited;
    static int[][] deltas = {{0,-1},{1,0},{0,1},{-1,0}};
    static int[][][] deltas10 = {
            {{-1,-1},{1,-1}},
            {{1,-1},{1,1}},
            {{1,1},{-1,1}},
            {{-1,1},{-1,-1}}
    };
    static int[][][] deltas1 = {
            {{1,1},{-1,1}},
            {{-1,1},{-1,-1}},
            {{-1,-1},{1,-1}},
            {{1,-1},{1,1}}
    };
    static int[][][] deltas7 = {
            {{-1,0},{1,0}},
            {{0,-1},{0,1}},
            {{-1,0},{1,0}},
            {{0,-1},{0,1}}
    };
    static int[][][] deltas2 = {
            {{-2,0},{2,0}},
            {{0,2},{0,-2}},
            {{-2,0},{2,0}},
            {{0,2},{0,-2}}
    };
    static int[][][] deltas5 = {
            {{0,-2}},
            {{2,0}},
            {{0,2}},
            {{-2,0}}
    };
    static int outSend;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N+1][N+1];
        visited = new int[N+1][N+1];
        outSend = 0;
        A[2][2] = 100;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        int r = N / 2;
//        int c = N / 2;
        int x = N / 2 + 1;
        int y = N / 2 + 1;

        int dist = 1;
        boolean flag = false;
        int T = 0;
        int dir = 0;
        while (true) {
            int cnt = (T / 2) + 1;
            if (cnt >= N) cnt = N - 1;
            for (int c = 0; c < cnt; c++) {
                int nx = x + deltas[dir][0];
                int ny = y + deltas[dir][1];

                int originSend = A[nx][ny];
                moveSend(nx, ny, dir, deltas1, 1, originSend);
                moveSend(nx, ny, dir, deltas2, 2, originSend);
                moveSend(nx, ny, dir, deltas5, 5, originSend);
                moveSend(nx, ny, dir, deltas7, 7, originSend);
                moveSend(nx, ny, dir, deltas10, 10, originSend);

                int nnx = nx + deltas[dir][0];
                int nny = ny + deltas[dir][1];
                if (nnx < 1 || nnx >= N+1 || nny < 1 || nny >= N+1) {
                    outSend += A[nx][ny];
                } else {
                    A[nnx][nny] += A[nx][ny];
                }

                x = nx;
                y = ny;
            }

            if (x == 1 && y == 1) break;
            dir = (dir + 1) % 4;

            T++;
        }

//        while (true) {
//            for (int d = 0; d < 2; d++) {
//                int nowDist = 0;
//                while (nowDist < dist) {
//                    visited = new int[N][N];
//
//                    r += deltas[d][0];
//                    c += deltas[d][1];
//                    System.out.println("r : " + r + ", c : " + c );
//                    nowDist++;
////                    A[r][c] = dist;
//
//                    int originSend = A[r][c];
////                    printMap(dist);
//                    sb.append(dist).append("\n");
////                    moveSend(r, c, d, deltas1, 1, originSend);
////                    moveSend(r, c, d, deltas2, 2, originSend);
////                    moveSend(r, c, d, deltas5, 5, originSend);
////                    moveSend(r, c, d, deltas7, 7, originSend);
////                    moveSend(r, c, d, deltas10, 10, originSend);
//                    int nr  = r + deltas[d][0];
//                    int nc  = c + deltas[d][1];
//                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
//                        outSend += A[r][c];
//                    } else {
//                        A[nr][nc] += A[r][c];
//                    }
//                    A[r][c] = 0;
//                    if (r == 0 && c == 0) {
//                        flag = true;
//                        System.out.println(outSend);
//
//                        return;
//                    }
//                }
//                if (flag) break;
//            }
//            if (flag) break;
//            dist++;
//            for (int d = 2; d < deltas.length; d++) {
//                int nowDist = 0;
//                while (nowDist < dist) {
//                    visited = new int[N][N];
//
//                    r += deltas[d][0];
//                    c += deltas[d][1];
//                    System.out.println("r : " + r + ", c : " + c );
//                    nowDist++;
//                    int originSend = A[r][c];
//
////                    moveSend(r, c, d, deltas1, 1, originSend);
////                    moveSend(r, c, d, deltas2, 2, originSend);
////                    moveSend(r, c, d, deltas5, 5, originSend);
////                    moveSend(r, c, d, deltas7, 7, originSend);
////                    moveSend(r, c, d, deltas10, 10, originSend);
//                    int nr  = r + deltas[d][0];
//                    int nc  = c + deltas[d][1];
//                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
//                        outSend += A[r][c];
//                    } else {
//                        A[nr][nc] += A[r][c];
//                    }
//                    A[r][c] = 0;
//                }
//            }
//            dist++;
//        }

        System.out.println(outSend);
    }
    static void moveSend(int r, int c, int d, int[][][] deltas, float ratio, int originSend) {
        int send = (int) (originSend / 100d * ratio);
        if (send == 0) return;
        for (int i = 0; i < deltas[d].length; i++) {
            int nr = r + deltas[d][i][0];
            int nc = c + deltas[d][i][1];

            if (nr < 1 || nr >= N+1 || nc < 1 || nc >= N+1) {
                outSend += send;
            } else {
                A[nr][nc] += send;
            }
            A[r][c] -= send;
        }
    }

    static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
}
