import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited, exitMap;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static String dir = "URDL";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        exitMap = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (exitMap[i][j]) cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean dfs(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= M) return true; // 바깥: 탈출 성공
        if (exitMap[r][c]) return true;                      // 이미 탈출 가능
        if (visited[r][c]) return false;                     // 순환 발견

        visited[r][c] = true;

        int d = dir.indexOf(map[r][c]);
        int nr = r + deltas[d][0];
        int nc = c + deltas[d][1];

        boolean canEscape = dfs(nr, nc);
        exitMap[r][c] = canEscape;
        return canEscape;
    }
}
