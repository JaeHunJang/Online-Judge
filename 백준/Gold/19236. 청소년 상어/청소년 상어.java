import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int map[][], maxSum;
    static Pos fishes[], shark;
    static int deltas[][] = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
    static class Pos {
        int r, c, d, sum;
        boolean isEat;

        public Pos(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.isEat = false;
        }

        public Pos(int r, int c, int d, int sum) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "sum=" + sum +
                    ", r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[4][4];
        fishes = new Pos[17];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int n = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                fishes[n] = new Pos(i, j, d-1, n);
            }
        }

        maxSum = 0;
        shark = new Pos(0, 0, fishes[map[0][0]].d, map[0][0]);
        fishes[map[0][0]].isEat = true;
//        moveFish();
//        for (int i = 0; i < 4; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println();
        dfs(shark, map, fishes);
        System.out.println(maxSum);
    }

    static void dfs(Pos shark, int[][] map, Pos[] fishes) {
        maxSum = Math.max(maxSum, shark.sum);

        Pos[] copyFishes = new Pos[17];
        for (int i = 1; i <= 16; i++) {
            if (fishes[i] != null) {
                copyFishes[i] = new Pos(fishes[i].r, fishes[i].c, fishes[i].d, fishes[i].sum);
                copyFishes[i].isEat = fishes[i].isEat;
            }
        }
        int[][] copyMap = new int[4][4];
        for (int i = 0; i < 4; i++) {
            copyMap[i] = map[i].clone();
        }
        moveFish(shark, copyFishes, copyMap);

        for (int step = 1; step <= 4; step++) {
            int nr = shark.r + deltas[shark.d][0] * step;
            int nc = shark.c + deltas[shark.d][1] * step;

            if (!isIn(nr, nc)) break;
            int target = copyMap[nr][nc];
            if (target == 0 || copyFishes[target].isEat) continue;

            Pos nextShark = new Pos(nr, nc, copyFishes[target].d, shark.sum + target);
            copyFishes[target].isEat = true;
            dfs(nextShark, copyMap, copyFishes);
            copyFishes[target].isEat = false;
        }
    }

    static boolean isIn(int r, int c) {
        return 0 <= r && r < 4 && 0 <= c && c < 4;
    }

    static void moveFish(Pos shark, Pos[] fishes, int[][] map) {
        for (int now = 1; now < fishes.length; now++) {
            if (fishes[now].isEat) continue;
            for (int j = 0; j < 8; j++) {
                int d = (fishes[now].d+j)%8;
                int nr = fishes[now].r + deltas[d][0];
                int nc = fishes[now].c + deltas[d][1];
                if (!isIn(nr, nc)) continue;
                if (shark.r == nr && shark.c == nc) continue;
                int swapFish = map[nr][nc];
                fishes[swapFish].r = fishes[now].r;
                fishes[swapFish].c = fishes[now].c;
                map[fishes[now].r][fishes[now].c] = swapFish;

                fishes[now].r = nr;
                fishes[now].c = nc;
                fishes[now].d = d;
                map[nr][nc] = now;
                break;
            }
        }

        for (int i = 1; i < fishes.length; i++) {
            map[fishes[i].r][fishes[i].c] = i;
        }
    }
}