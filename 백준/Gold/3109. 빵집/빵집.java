import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    static int R, C, maxCnt, deltas[][] = {{-1,1},{0,1},{1,1}};
    static char map[][];
    static boolean isGoal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            isGoal = false;
            map[i][0] = ((char) ('1' + i));
            dfs(i, 0, ((char) ('1' + i)));
        }

        System.out.println(maxCnt);
    }

    static void dfs(int r, int c, char mark) {
        if (c == C-1) {
            isGoal = true;
            maxCnt++;
            return;
        }

        for (int d = 0; d < deltas.length; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if (map[nr][nc] != '.') continue;
            map[nr][nc] = mark;
            dfs(nr, nc, mark);
            if (isGoal) return;
        }
    }
}