import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, map[][];
    static List<Pos> blanks;
    static boolean solved;
    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 9;
        solved = false;
        map = new int[N][N];
        blanks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    blanks.add(new Pos(i, j));
                }
            }
        }

        if (blanks.size() > 0) dfs(0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    static void dfs(int idx) {
        if (solved) return;
        if (blanks.size() == idx) {
            solved = true;
            return;
        }

        Pos blank = blanks.get(idx);
        for (int num = 1; num <= 9; num++) {
            if (isValid(blank.r, blank.c, num)) {
                map[blank.r][blank.c] = num;
                dfs(idx + 1);
                if (solved) return;
                map[blank.r][blank.c] = 0;
            }
        }
    }

    static boolean isValid(int r, int c, int num) {
        for (int j = 0; j < N; j++) {
            if (map[r][j] == num) return false;
        }

        for (int i = 0; i < N; i++) {
            if (map[i][c] == num) return false;
        }

        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (map[i][j] == num) return false;
            }
        }

        return true;
    }
}
