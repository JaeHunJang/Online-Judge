import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int size = 0;
        for (int sr = 0; sr < N; sr++) {
            for (int sc = 0; sc < M; sc++) {
                for (int er = sr; er < N; er++) {
                    for (int ec = sc; ec < M; ec++) {
                        if ((map[sr][sc] == map[sr][ec]) && (map[sr][sc] == map[er][sc]) && (map[sr][sc] == map[er][ec]) && ((er-sr) == (ec-sc))) {
                            size = Math.max(size, (er - sr + 1) * (ec - sc + 1));
                        }
                    }
                }
            }
        }

        System.out.println(size);
    }
}