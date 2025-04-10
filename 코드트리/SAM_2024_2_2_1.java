import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SAM_2024_2_2_1 {
    static int N, M; // 마을의 크기, 전사의 수
    static int[][] map; // 마을
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}}; // 이동방향
    static int[][] deltas2 = {{0,-1},{0,1},{-1,0},{1,0}}; // 이동방향
    static StringBuilder sb = new StringBuilder();
    static class Pos {
        int r, c;
        Pos (int r, int c) {
            this.r = r;
            this.c = c;
        }

        boolean isDupl(Pos pos) {
            return pos.r == this.r && pos.c == this.c;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
    static class Medusa extends Pos {
        List<Pos> history;
        Medusa(int r, int c) {
            super(r, c);
            this.history = new ArrayList<>();
        }
        Medusa(Pos pos) {
            super(pos.r, pos.c);
            this.history = new ArrayList<>();
        }
    }
    static class Warrior extends Pos {
        boolean isDeath, isStone;
        Warrior(int r, int c) {
            super(r, c);
            isDeath = false;
            isStone = false;
        }
    }
    static Medusa medusa;
    static Pos park;
    static Warrior[] warriors;
    static List<Pos> medusaRoute;
    public static void main(String[] args) throws Exception {
        init();
        medusaRoute = getRoute();
        if (medusaRoute == null) { // 공원으로 갈 수 없음.
            System.out.println(-1);
            return;
        }
        System.out.println(medusaRoute);
        for (Pos medusaPos : medusaRoute) {
            System.out.println(medusaPos);
            moveMedusa(medusaPos);
            watchMedusa(medusaPos);
        }

        System.out.println(sb);
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 마을의 크기
        M = Integer.parseInt(st.nextToken()); // 전사의 수

        st = new StringTokenizer(br.readLine());
        medusa = new Medusa(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 메두사 집 위치
        park = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 공원 위치

        st = new StringTokenizer(br.readLine());
        warriors = new Warrior[M]; // 전사들 위치
        for (int i = 0; i < M; i++) {
            warriors[i] = new Warrior(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        map = new int[N][N]; // 마을
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static List<Pos> getRoute() {
        Queue<Medusa> q = new ArrayDeque<>();
        q.offer(medusa);
        boolean[][] visited = new boolean[N][N];
        visited[medusa.r][medusa.c] = true;

        while (!q.isEmpty()) {
            Medusa now = q.poll();

            if (now.r == park.r && now.c == park.c) {
                return now.history;
            }

            for (int d = 0; d < deltas.length; d++) {
                int nr = now.r + deltas[d][0];
                int nc = now.c + deltas[d][1];
                if (!isIn(nr, nc) || visited[nr][nc] || map[nr][nc] == 1) continue;
                visited[nr][nc] = true;
                Medusa next = new Medusa(new Pos(nr, nc));
                next.history.addAll(now.history);
                next.history.add(next);
                q.offer(next);
            }
        }

        return null;
    }

    static void moveMedusa(Pos medusaPos) {
        for (int i = 0; i < M; i++) {
            if (medusaPos.isDupl(warriors[i])) {
                warriors[i].isDeath = true;
            }
        }
    }

    static void watchMedusa(Pos medusaPos) {
        int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}}; // 이동방향
        int[][][] deltasWatch = {
                {{-1,-1},{-1,1}}, // 상
                {{1,-1},{1,1}}, // 하
                {{1,-1},{-1,-1}}, // 좌
                {{1,1},{-1,1}}}; // 우

        int[][] warriorMap = new int[N][N];
        for (int i = 0; i < M; i++) { // 전사들 배치
            if (!warriors[i].isDeath) warriorMap[warriors[i].r][warriors[i].c]++;
        }
        System.out.println("현재 전사들 위치");
        for (int i = 0; i < warriorMap.length; i++) {
            System.out.println(Arrays.toString(warriorMap[i]));
        }

        int[][] maxVisited = new int[N][N];
        int maxCnt = 0;
        for (int d = 0; d < deltas.length; d++) {
            Pos now = new Pos(medusaPos.r, medusaPos.c);
            int[][] visited = new int[N][N];
            int cnt = 0;
            while (isIn(now.r, now.c) && visited[now.r][now.c] == 0) {
                visited[now.r][now.c] = 1;
                if (warriorMap[now.r][now.c] > 0) {
                    cnt += warriorMap[now.r][now.c];
                    hideWarriors(now, medusaPos, visited);
                }

                for (int d2 = 0; d2 < deltasWatch[d].length; d2++) {
                    int nr = now.r + deltasWatch[d][d2][0];
                    int nc = now.c + deltasWatch[d][d2][1];
                    while (isIn(nr, nc) && visited[nr][nc] == 0) {
                        visited[nr][nc] = 1;
                        if (warriorMap[nr][nc] > 0) {
                            cnt += warriorMap[nr][nc];
                            hideWarriors(new Pos(nr, nc), medusaPos, visited);
                        }
                        nr += deltasWatch[d][d2][0];
                        nc += deltasWatch[d][d2][1];
                    }
                }
                now.r += deltas[d][0];
                now.c += deltas[d][1];
            }

            System.out.println("현재 메두사 시점 " + Arrays.toString(deltas[d]) + " 잡은 전사 수" + cnt);
            System.out.println("메두사 위치 " + medusaPos);
            for (int i = 0; i < visited.length; i++) {
                System.out.println(Arrays.toString(visited[i]));
            }
            if (cnt > maxCnt) {
                maxCnt = cnt;
                for (int i = 0; i < visited.length; i++) {
                    maxVisited[i] = visited[i].clone();
                }
            }
        }

        moveWarriors(medusaPos, maxVisited);
    }

    static void hideWarriors(Pos warrior, Pos medusaPos, int[][] visited) {
        if (warrior.c == medusaPos.c) {
            if (warrior.r < medusaPos.r) {
                for (int i = warrior.r-1; i >= 0; i--) {
                    visited[i][warrior.c] = 2;
                }
            } else {
                for (int i = warrior.r+1; i < N; i++) {
                    visited[i][warrior.c] = 2;
                }
            }
        } else if (warrior.r == medusaPos.r) {
            if (warrior.c < medusaPos.c) {
                for (int i = warrior.c-1; i >= 0; i--) {
                    visited[warrior.r][i] = 2;
                }
            } else {
                for (int i = warrior.c+1; i < N; i++) {
                    visited[warrior.r][i] = 2;
                }
            }
        }

        if (warrior.r < medusaPos.r && warrior.c < medusaPos.c) {
            int[][] deltas = {{-1,0},{-1,-1}};
            hide(warrior, deltas, visited);
        } else if (warrior.r < medusaPos.r && warrior.c > medusaPos.c) {
            int[][] deltas = {{-1,0},{-1,1}};
            hide(warrior, deltas, visited);
        } else if (warrior.r > medusaPos.r && warrior.c < medusaPos.c) {
            int[][] deltas = {{1,0},{1,-1}};
            hide(warrior, deltas, visited);
        } else if (warrior.r > medusaPos.r && warrior.c > medusaPos.c) {
            int[][] deltas = {{1,0},{1,1}};
            hide(warrior, deltas, visited);
        }
    }

    static void hide(Pos warrior, int[][] deltas, int[][] visited) {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(warrior);

        while (!q.isEmpty()) {
            Pos now = q.poll();

            for (int d = 0; d < deltas.length; d++) {
                int nr = now.r + deltas[d][0];
                int nc = now.c + deltas[d][1];

                if (isIn(nr, nc)) {
                    visited[nr][nc] = 2;
                    q.offer(new Pos(nr, nc));
                }
            }
        }
    }

    static void moveWarriors(Pos medusaPos, int[][] visited) {
        int moveDist = 0;
        int attackCnt = 0;
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < M; i++) {
                if (!warriors[i].isDeath && !warriors[i].isStone) {
                    int midDir = -1;
                    int minDist = getDist(warriors[i].r, warriors[i].c, medusaPos.r, medusaPos.c);
                    int[][] nowDeltas = k == 0 ? deltas : deltas2; // 첫번째 이동 : 두번째 이동
                    for (int d = 0; d < nowDeltas.length; d++) {
                        int nr = warriors[i].r + nowDeltas[d][0];
                        int nc = warriors[i].c + nowDeltas[d][1];
                        if (isIn(nr, nc) && visited[nr][nc] == 1) { // 메두사가 보는 위치 조건 추가
                            int calcDist = getDist(nr, nc, medusaPos.r, medusaPos.c);
                            if (minDist > calcDist) {
                                minDist = calcDist;
                                midDir = d;
                            }
                        }
                    }
                    if (midDir != -1) {
                        warriors[i].r += nowDeltas[midDir][0];
                        warriors[i].c += nowDeltas[midDir][1];
                        moveDist++;
                        if (medusaPos.isDupl(warriors[i])) {
                            attackCnt++;
                            warriors[i].isDeath = true;
                        }
                    }
                }
            }
        }

        sb.append(moveDist).append(" ")
                .append(countStoneWarriors()).append(" ")
                .append(attackCnt).append("\n");
    }

    static int countStoneWarriors() {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (!warriors[i].isDeath && warriors[i].isStone) cnt++;
        }
        return cnt;
    }


    static int getDist(int r, int c, int tr, int tc) {
        return Math.abs(r - tr) + Math.abs(c - tc);
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
