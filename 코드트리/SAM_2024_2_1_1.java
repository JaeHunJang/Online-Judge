import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SAM_2024_2_1_1 {
    static StringBuilder sb = new StringBuilder();
    static int N, M, F; // 공간 크기, 벽 크기, 이상현상 개수
    static int[][] map, timeMap;
    static Pos startSpacePos, endSpacePos, startTimePos, endTimePos;
    static Pos startTimeWall, endTimeWall;
    static Pos time0start, time0end, time1start, time1end, time2start, time2end, time3start, time3end, time4start, time4end;
    static Anomaly[] anomalies;
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        init();
        findTimeWallEscape();
        if (endTimePos == null) {
            System.out.println(-1);
            return;
        }

        List<Pos> timeWallRoute = getTimeWallRoute();
        if (timeWallRoute == null) {
            System.out.println(-1);
            return;
        }
        System.out.println(findEscape(timeWallRoute.size()));
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 공간 크기
        M = Integer.parseInt(st.nextToken()); // 벽 크기
        F = Integer.parseInt(st.nextToken()); // 이상현상 개수

        startTimeWall = new Pos(N, N);
        endTimeWall = new Pos(0, 0);
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 4) {
                    endSpacePos = new Pos(i, j);
                }
                if (map[i][j] == 3) { //시간의 벽 위치
                    startTimeWall.r = Math.min(startTimeWall.r, i);
                    startTimeWall.c = Math.min(startTimeWall.c, j);
                    endTimeWall.r = Math.max(endTimeWall.r, i);
                    endTimeWall.c = Math.max(endTimeWall.c, j);
                }
            }
        }

        // 시간의 벽 초기화
        timeMap = new int[M * 3][M * 3];
        for (int i = 0; i < timeMap.length; i++) {
            Arrays.fill(timeMap[i], 9);
        }

        // 동
        time0start = new Pos(M, M * 2);
        time0end = new Pos(M * 2 - 1, M * 3 - 1);
        for (int j = time0start.c; j <= time0end.c; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = time0end.r; i >= time0start.r; i--) {
                timeMap[i][j] = Integer.parseInt(st.nextToken());
                if (timeMap[i][j] == 2) {
                    startTimePos = new Pos(i, j);
                }
            }
        }

        // 서
        time1start = new Pos(M, 0);
        time1end = new Pos(M * 2 - 1, M - 1);
        for (int j = time1end.c; j >= time1start.c; j--) {
            st = new StringTokenizer(br.readLine());
            for (int i = time1start.r; i <= time1end.r; i++) {
                timeMap[i][j] = Integer.parseInt(st.nextToken());
                if (timeMap[i][j] == 2) {
                    startTimePos = new Pos(i, j);
                }
            }
        }

        // 남
        time2start = new Pos(M * 2, M);
        time2end = new Pos(M * 3 - 1, M * 2 - 1);
        for (int i = time2start.r; i <= time2end.r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = time2start.c; j <= time2end.c; j++) {
                timeMap[i][j] = Integer.parseInt(st.nextToken());
                if (timeMap[i][j] == 2) {
                    startTimePos = new Pos(i, j);
                }
            }
        }

        // 북
        time3start = new Pos(0, M);
        time3end = new Pos(M - 1, M * 2 - 1);
        for (int i = time3end.r; i >= time3start.r; i--) {
            st = new StringTokenizer(br.readLine());
            for (int j = time3end.c; j >= time3start.c; j--) {
                timeMap[i][j] = Integer.parseInt(st.nextToken());
                if (timeMap[i][j] == 2) {
                    startTimePos = new Pos(i, j);
                }
            }
        }

        // 윗면
        time4start = new Pos(M, M);
        time4end = new Pos(M * 2 - 1, M * 2 - 1);
        for (int i = time4start.r; i <= time4end.r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = time4start.c; j <= time4end.c; j++) {
                timeMap[i][j] = Integer.parseInt(st.nextToken());
                if (timeMap[i][j] == 2) {
                    startTimePos = new Pos(i, j);
                }
            }
        }

        anomalies = new Anomaly[F];
        for (int i = 0; i < F; i++) {
            st = new StringTokenizer(br.readLine());
            anomalies[i] = new Anomaly(
                    Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken()));
            map[anomalies[i].r][anomalies[i].c] = 5;
        }
    }

    static void findTimeWallEscape() {
        // 동쪽에서 시간의 벽 탈출
        for (int i = startTimeWall.r; i <= endTimeWall.r; i++) {
            if (endTimeWall.c + 1 < N && map[i][endTimeWall.c + 1] == 0) {
                startSpacePos = new Pos(i, endTimeWall.c + 1);
                endTimePos = new Pos(time0start.r + (i - M + 1), time0end.c);
            }
        }

        // 서쪽에서 시간의 벽 탈출
        for (int i = startTimeWall.r; i <= endTimeWall.r; i++) {
            if (startTimeWall.c - 1 >= 0 && map[i][startTimeWall.c - 1] == 0) {
                startSpacePos = new Pos(i, startTimeWall.c - 1);
                endTimePos = new Pos(time1start.r + (i - M + 1), time1start.c);
            }
        }

        // 남쪽에서 시간의 벽 탈출
        for (int i = startTimeWall.c; i <= endTimeWall.c; i++) {
            if (endTimeWall.r + 1 < N && map[endTimeWall.r + 1][i] == 0) {
                startSpacePos = new Pos(endTimeWall.r + 1, i);
                endTimePos = new Pos(time2end.r, time2start.c + (i - M + 1));
            }
        }

        // 북쪽에서 시간의 벽 탈출
        for (int i = startTimeWall.c; i <= endTimeWall.c; i++) {
            if (startTimeWall.r - 1 >= 0 && map[startTimeWall.r - 1][i] == 0) {
                startSpacePos = new Pos(startTimeWall.r - 1, i);
                endTimePos = new Pos(time3start.r, time3start.c + (i - M + 1));
            }
        }
    }

    static List<Pos> getTimeWallRoute() {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(startTimePos);
        int[][] visited = new int[M * 3][M * 3];
        int cnt = 1;
        visited[startTimePos.r][startTimePos.c] = cnt;
        cnt++;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Pos now = q.poll();

                if (now == null) continue;
                if (now.r == endTimePos.r && now.c == endTimePos.c) { // 시간의 벽 탈출 위치
                    return now.history;
                }

                if (now.r == 5 && now.c == 7) ;
                for (int d = 0; d < deltas.length; d++) {
                    int nr = now.r + deltas[d][0];
                    int nc = now.c + deltas[d][1];
                    if (!isInTimeMap(nr, nc) || timeMap[nr][nc] == 1 || visited[nr][nc] > 0) continue;
                    visited[nr][nc] = cnt;
                    Pos next = null;
                    if (timeMap[nr][nc] == 9) { // 방향을 돌려야함
                        int rotateDir = findTimeWallPosition(now.r, now.c);
                        if (rotateDir == 0) { // 동쪽
                            if (d == 2) { // 아래로 남쪽
                                next = moveE2SnW2N(now.r, now.c);
                            }
                            if (d == 3) { // 위로 북쪽
                                int gap = now.c - time0start.c + 1;
                                next = new Pos(now.r - gap, now.c - gap);
                            }
                        }
                        if (rotateDir == 1) { // 서쪽
                            if (d == 2) { // 아래로 남쪽
                                int gap = time1end.c - now.c + 1;
                                next = new Pos(now.r + gap, now.c + gap);
                            }
                            if (d == 3) { // 위로 북쪽
                                next = moveE2SnW2N(now.r, now.c);
                            }
                        }
                        if (rotateDir == 2) { // 남쪽
                            if (d == 0) { // 우측 동쪽
                                next = moveE2SnW2N(now.r, now.c);
                            }
                            if (d == 1) { // 좌측 서쪽
                                int gap = now.r - time2start.r + 1;
                                next = new Pos(now.r - gap, now.c - gap);
                            }
                        }
                        if (rotateDir == 3) { // 북쪽
                            if (d == 0) { // 우측 동쪽
                                int gap = time3end.r - now.r + 1;
                                next = new Pos(now.r + gap, now.c + gap);
                            }
                            if (d == 1) { // 좌측 서쪽
                                next = moveE2SnW2N(now.r, now.c);
                            }
                        }
                        if (next == null || !isInTimeMap(next.r, next.c) || timeMap[next.r][next.c] >= 1 || visited[next.r][next.c] > 0) {
                            continue;
                        }
                        visited[next.r][next.c] = cnt;
                    } else {
                        next = new Pos(nr, nc);
                    }
                    next.history.addAll(now.history); // 이전 위치 기록
                    next.history.add(new Pos(next.r, next.c)); // 현재 위치 기록
                    q.offer(next);
                }
            }
            cnt++;
        }

        return null;
    }

    static int findTimeWallPosition(int r, int c) {
        if (time0start.r <= r && r <= time0end.r && time0start.c <= c && c <= time0end.c) {
            return 0;
        } else if (time1start.r <= r && r <= time1end.r && time1start.c <= c && c <= time1end.c) {
            return 1;
        } else if (time2start.r <= r && r <= time2end.r && time2start.c <= c && c <= time2end.c) {
            return 2;
        } else if (time3start.r <= r && r <= time3end.r && time3start.c <= c && c <= time3end.c) {
            return 3;
        }
        return -1;
    }

    /**
     * 동 <-> 남, 서 <-> 북 좌표 swap
     */
    static Pos moveE2SnW2N(int r, int c) {
        return new Pos(c, r);
    }

    static boolean isInTimeMap(int r, int c) {
        return 0 <= r && r < M*3 && 0 <= c && c < M*3;
    }

    static boolean isInMap(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    static int findEscape(int time) {
        for (int t = 1; t <= time; t++) { // 시간의 벽 탈출동안 맵 변화
            expandAnomaly(t);
        }
        if (map[startSpacePos.r][startSpacePos.c] != 0) {
            return -1;
        }
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(startSpacePos);
        int[][] visited = new int[N][N];
        time++;
        visited[startSpacePos.r][startSpacePos.c] = time;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            expandAnomaly(time);
            for (int s = 0; s < size; s++) {
                Pos now = q.poll();

                if (now == null) continue;
                if (now.r == endSpacePos.r && now.c == endSpacePos.c && map[now.r][now.c] == 4) {
                    return time-1;
                }

                for (int d = 0; d < deltas.length; d++) {
                    int nr = now.r + deltas[d][0];
                    int nc = now.c + deltas[d][1];
                    if (!isInMap(nr, nc) || map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 5 || visited[nr][nc] > 0) continue;
                    visited[nr][nc] = time;
                    q.offer(new Pos(nr, nc));
                }
            }

        }

        return -1;
    }

    static void expandAnomaly(int time) {
        for (int i = 0; i < F; i++) {
            if (time % anomalies[i].v == 0) {
                int nr = anomalies[i].r + deltas[anomalies[i].d][0];
                int nc = anomalies[i].c + deltas[anomalies[i].d][1];
                if (isInMap(nr, nc) && (map[nr][nc] == 0 || map[nr][nc] == 3 || map[nr][nc] == 5)) { // 장애물만 아니면 확산함
                    anomalies[i].r = nr;
                    anomalies[i].c = nc;
                    map[nr][nc] = 5;
                }
            }
        }
    }

    static class Pos {
        int r, c;
        List<Pos> history;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
            history = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    static class Anomaly extends Pos {
        int d, v;

        Anomaly(int r, int c, int d, int v) {
            super(r, c);
            this.d = d;
            this.v = v;
        }

        @Override
        public String toString() {
            return "Anomaly{" +
                    "d=" + d +
                    ", v=" + v +
                    ", r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
