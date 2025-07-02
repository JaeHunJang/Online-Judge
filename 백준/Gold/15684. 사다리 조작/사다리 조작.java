import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][] map;
    static int answer = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로선
        M = Integer.parseInt(st.nextToken()); // 이미 놓인 가로선 개수
        H = Integer.parseInt(st.nextToken()); // 가로선을 놓을 수 있는 행 수

        map = new int[H + 2][N + 2]; // 1-based 인덱스, 경계 허용

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 행
            int b = Integer.parseInt(st.nextToken()); // 열 (b ↔ b+1 연결)
            map[a][b] = 1;
        }

        dfs(0, 1, 1);

        System.out.println(answer == 4 ? -1 : answer);
    }

    static void dfs(int count, int row, int col) {
        if (count >= answer) return;

        if (isValid()) {
            answer = count;
            return;
        }

        if (count == 3) return;

        for (int i = row; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 0 && map[i][j - 1] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    dfs(count + 1, i, j); // 설치하고 다음 탐색
                    map[i][j] = 0;
                }
            }
        }
    }

    // 사다리 타기 시뮬레이션
    static boolean isValid() {
        for (int start = 1; start <= N; start++) {
            int pos = start;
            for (int i = 1; i <= H; i++) {
                if (map[i][pos] == 1) {
                    pos++; // 오른쪽으로 이동
                } else if (map[i][pos - 1] == 1) {
                    pos--; // 왼쪽으로 이동
                }
            }
            if (pos != start) return false;
        }
        return true;
    }
}
