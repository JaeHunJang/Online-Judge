import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, map[][], cnt0, cnt1, cnt2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][M];
        for (int i = 0; i < M; i++) {
            Arrays.fill(map[i], 1);
        }

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            cnt0 = Integer.parseInt(st.nextToken());
            cnt1 = Integer.parseInt(st.nextToken());
            cnt2 = Integer.parseInt(st.nextToken());
            for (int i = M-1; i > 0; i--) {
                map[i][0] += growSize();
//                System.out.println(i + "|" + 0);
            }
            for (int i = 0; i < M; i++) {
//                System.out.println(0 + "|" + i);
                map[0][i] += growSize();
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < M; j++) {
                map[i][j] = Math.max(map[i][j], Math.max(map[i][j-1], Math.max(map[i-1][j-1], map[i-1][j])));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int growSize() {
        if (cnt0 > 0) {
            cnt0--;
            return 0;
        } else if (cnt1 > 0) {
            cnt1--;
            return 1;
        } else {
            cnt2--;
            return 2;
        }
    }
}
