import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Target {
        int total, now;

        public Target(int total, int now) {
            this.total = total;
            this.now = now;
        }

        @Override
        public String toString() {
            return "{" +
                    "t=" + total +
                    ", n=" + now +
                    '}';
        }
    }

    static int N, K, bullets[], positions[], maxScore, deltas[][] = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    static Target[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        maxScore = 0;
        map = new Target[N][N];
        bullets = new int[K];
        positions = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = new Target(n, n);
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            bullets[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(maxScore);
    }

    static void dfs(int cnt) {
        if (cnt == K) {
            Target[][] copy = copyArr(map);
            int score = 0;
            for (int i = 0; i < K; i++) {
                score += shoot(copy, positions[i], bullets[i]);
            }
            maxScore = Math.max(maxScore, score);
            return;
        }

        for (int i = 0; i < N; i++) {
            positions[cnt] = i;
            dfs(cnt + 1);
        }
    }

    static int shoot(Target[][] map, int pos, int bullet) {
        int score = 0;
        for (int i = 0; i < N; i++) {
            if (map[pos][i].now > 0) { // 표적 확인
                if (map[pos][i].now >= 10) { // 보너스 표적
                    score = map[pos][i].total; // 점수계산
                    map[pos][i].total = 0; // 표적 초기화
                    map[pos][i].now = 0; // 표적 초기화
                } else {
                    if (map[pos][i].now > bullet) { // 표적이 총알보다 체력이 높으면
                        map[pos][i].now -= bullet; // 체력만 감소
                    } else {
                        score = map[pos][i].total; // 점수계산
                        map[pos][i].total = 0; // 표적 초기화
                        map[pos][i].now = 0; // 표적 초기화

                        int newTarget = score / 4;
                        if (newTarget == 0) break; // 새로운 표적이 현재 체력이 0이면 탈출

                        for (int d = 0; d < deltas.length; d++) {
                            int nr = pos + deltas[d][0];
                            int nc = i + deltas[d][1];

                            if (nr >= N || nr < 0 || nc >= N || nc < 0) continue;
                            if (map[nr][nc].now > 0) continue;
                            map[nr][nc] = new Target(newTarget, newTarget);
                        }
                    }
                }
                break;
            }
        }

        return score;
    }

    static Target[][] copyArr(Target[][] map) {
        Target[][] copy = new Target[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = new Target(map[i][j].total,map[i][j].total);
            }
        }

        return copy;
    }

    static void printArr(Target[][] map) {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
}
