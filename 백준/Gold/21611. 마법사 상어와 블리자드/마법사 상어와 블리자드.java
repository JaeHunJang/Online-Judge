import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, mr, mc;
    static int[][] map, deltasBlizzard = {{0,0},{-1,0},{1,0},{0,-1},{0,1}}, deltas = {{0,-1},{1,0},{0,1},{-1,0}};
    static ArrayDeque<Integer> balls;
    static int[] bombBalls = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mr = N / 2;
        mc = mr;

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        balls = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            blizzard(d, s);
            getBalls();
            while (bomb());
            setBalls();
//            System.out.println("블리자드 이후");
//            for (int h = 0; h < N; h++) {
//                System.out.println(Arrays.toString(map[h]));
//            }
            balls.clear();
        }

        System.out.println(bombBalls[1] + bombBalls[2] * 2 + bombBalls[3] * 3);
    }

    static void setBalls() {
        ArrayDeque<Integer> readyBalls = new ArrayDeque<>();
        map = new int[N][N];

//        System.out.println(balls);
        if (balls.isEmpty()) return;
        int ball = balls.poll();
        int cnt = 1;
        while (!balls.isEmpty()) {
            if (ball != balls.peekFirst()) {
                readyBalls.offer(cnt);
                readyBalls.offer(ball);

//                if (!balls.isEmpty()) return;
                ball = balls.poll();
                cnt = 1;
            } else {
                cnt++;
                balls.poll();
            }
        }
        if (cnt > 0) {
            readyBalls.offer(cnt);
            readyBalls.offer(ball);
        }


        int dist = 0;
        int r = mr;
        int c = mc;
        int dir = 0;
        int dirCnt = 0;
        while (!readyBalls.isEmpty()) {
            if (dirCnt % 2 == 0) dist++;
            int nr = r;
            int nc = c;
            for (int size = 0; size < dist && !readyBalls.isEmpty(); size++) {
                nr += deltas[dir][0];
                nc += deltas[dir][1];
                map[nr][nc] = readyBalls.poll();
                if (nr == 0 && nc == 0) return;
            }
            r = nr;
            c = nc;
            dir = (dir + 1) % 4;
            dirCnt++;
        }
    }

    static boolean bomb() {
        ArrayDeque<Integer> temp = new ArrayDeque<>();
        if (balls.isEmpty()) return false;
        boolean isBomb = false;
        int ball = balls.poll();
        int cnt = 1;
        temp.offer(ball);
        while (!balls.isEmpty()) {
            if (ball != balls.peekFirst()) {
                if (cnt >= 4) {
                    isBomb = true;
                    bombBalls[ball] += cnt;
                    while (cnt > 0) {
                        temp.pollLast();
                        cnt--;
                    }
                }
                if (balls.isEmpty()) break;
                ball = balls.poll();
                cnt = 1;
            } else {
                cnt++;
                balls.poll();
            }
            temp.offer(ball);
        }
        if (cnt >= 4) {
            isBomb = true;
            bombBalls[ball] += cnt;
            while (cnt > 0) {
                temp.pollLast();
                cnt--;
            }
            while (!temp.isEmpty()) {
                balls.offerFirst(temp.pollLast());
            }
        }

        while (!temp.isEmpty()) {
            balls.offerFirst(temp.pollLast());
        }

        return isBomb;
    }

    static void blizzard(int d, int s) {
        int nr = mr;
        int nc = mc;
        for (int size = 0; size < s; size++) {
            nr += deltasBlizzard[d][0];
            nc += deltasBlizzard[d][1];

            if (!isIn(nr, nc)) continue;
            map[nr][nc] = 0;
        }
    }

    static void getBalls() {
        int dist = 0;
        int r = mr;
        int c = mc;
        int dir = 0;
        int dirCnt = 0;
        while (true) {
            if (dirCnt % 2 == 0) dist++;
            int nr = r;
            int nc = c;
            for (int size = 0; size < dist; size++) {
                nr += deltas[dir][0];
                nc += deltas[dir][1];
                if (map[nr][nc] > 0) balls.offer(map[nr][nc]);
                if (nr == 0 && nc == 0) return;
            }
            r = nr;
            c = nc;
            dir = (dir + 1) % 4;
            dirCnt++;
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
