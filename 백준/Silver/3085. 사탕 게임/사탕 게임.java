import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 모든 위치에서 인접한 것과 swap
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 오른쪽과 바꾸기
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    check();
                    swap(i, j, i, j + 1); // 원상복구
                }
                // 아래쪽과 바꾸기
                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    check();
                    swap(i, j, i + 1, j); // 원상복구
                }
            }
        }

        System.out.println(max);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char tmp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = tmp;
    }

    static void check() {
        for (int i = 0; i < N; i++) {
            int rowCnt = 1;
            int colCnt = 1;
            for (int j = 1; j < N; j++) {
                // 가로 체크
                if (map[i][j] == map[i][j - 1]) {
                    rowCnt++;
                } else {
                    rowCnt = 1;
                }
                max = Math.max(max, rowCnt);

                // 세로 체크
                if (map[j][i] == map[j - 1][i]) {
                    colCnt++;
                } else {
                    colCnt = 1;
                }
                max = Math.max(max, colCnt);
            }
        }
    }
}
