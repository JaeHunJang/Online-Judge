import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] A;
    static int aircon1, aircon2;
    static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        A = new int[R][C];
        boolean found = false;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == -1) {
                    if (!found) { aircon1 = i; found = true; }
                    else aircon2 = i;
                }
            }
        }

        while (T-- > 0) {
            spread();
            clean();
        }

        System.out.println(getSum());
    }

    static void spread() {
        int[][] tmp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] > 0) {
                    int spreadCnt = 0;
                    int dust = A[i][j] / 5;
                    for (int[] d : deltas) {
                        int ni = i + d[0];
                        int nj = j + d[1];
                        if (ni < 0 || ni >= R || nj < 0 || nj >= C || A[ni][nj] == -1) continue;
                        tmp[ni][nj] += dust;
                        spreadCnt++;
                    }
                    tmp[i][j] += A[i][j] - dust * spreadCnt;
                } else if (A[i][j] == -1) {
                    tmp[i][j] = -1;
                }
            }
        }
        A = tmp;
    }

    static void clean() {
        for (int i = aircon1-1; i > 0; i--) A[i][0] = A[i-1][0];
        for (int j = 0; j < C-1; j++) A[0][j] = A[0][j+1];
        for (int i = 0; i < aircon1; i++) A[i][C-1] = A[i+1][C-1];
        for (int j = C-1; j > 1; j--) A[aircon1][j] = A[aircon1][j-1];
        A[aircon1][1] = 0;

        for (int i = aircon2+1; i < R-1; i++) A[i][0] = A[i+1][0];
        for (int j = 0; j < C-1; j++) A[R-1][j] = A[R-1][j+1];
        for (int i = R-1; i > aircon2; i--) A[i][C-1] = A[i-1][C-1];
        for (int j = C-1; j > 1; j--) A[aircon2][j] = A[aircon2][j-1];
        A[aircon2][1] = 0;
    }

    static int getSum() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] > 0) sum += A[i][j];
            }
        }
        return sum;
    }
}
