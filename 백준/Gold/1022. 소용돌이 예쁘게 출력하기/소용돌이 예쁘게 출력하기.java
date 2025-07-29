import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int r1, c1, r2, c2, map[][], maxNum;
    static final int N = 5000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken()) + N;
        c1 = Integer.parseInt(st.nextToken()) + N;
        r2 = Integer.parseInt(st.nextToken()) + N;
        c2 = Integer.parseInt(st.nextToken()) + N;

        map = new int[r2-r1+1][c2-c1+1];
        fillMap();
        int maxLength = getLength(maxNum);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                for (int k = 0; k < maxLength-getLength(map[i][j]); k++) {
                    sb.append(" ");
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int getLength(int n) {
        int cnt = 1;
        while (n >= 10) {
            n /= 10;
            cnt++;
        }
        return cnt;
    }

    static boolean isIn(int r, int c) {
        return 0 <= r-r1 && r-r1 <= r2-r1 && 0 <= c-c1 && c-c1 <= c2-c1;
    }

    static void print() {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    static void fillMap() {
        int[][] deltas = {{0,1},{-1,0},{0,-1},{1,0}};
        int n = 1;
        int size = 1;
        int r = N, c = N;
        if (isIn(r, c)) {
            map[r-r1][c-c1] = n;
            maxNum = Math.max(maxNum, n);
        }
        n++;
        while (n < (N*2+1)*(N*2+1)) {
            for (int d = 0; d < 4; d++) {
                for (int s = 0; s < size; s++) {
                    r = r + deltas[d][0];
                    c = c + deltas[d][1];
                    if (isIn(r, c)) {
                        map[r-r1][c-c1] = n;
                        maxNum = Math.max(maxNum, n);
                    }
                    n++;
                    if (n > (N*2+1)*(N*2+1)) return;
                }
                if (d % 2 == 1) size++;
            }
        }
    }
}
