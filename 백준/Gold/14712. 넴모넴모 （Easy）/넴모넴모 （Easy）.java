import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 넴모넴모 (Easy) / 60분
public class Main {
    static int N, M, map[][], count;
    static boolean visited[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        count = 0;
        dfs(0);

        System.out.println(count);
    }

    static void dfs(int cnt) {
        if (!isValid()) {
            return;
        }

        if (cnt == N*M) {
            count++;
            return;
        }


        map[cnt / M][cnt % M] = 0;
        dfs(cnt + 1);
        map[cnt / M][cnt % M] = 1;
        dfs(cnt + 1);
        map[cnt / M][cnt % M] = 0;
    }

    static boolean isValid() {
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < M-1; j++) {
                if (map[i][j] == 1 && map[i][j+1] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1) return false; // 넴모 완성
            }
        }

        return true;
    }

    static void print() {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
}