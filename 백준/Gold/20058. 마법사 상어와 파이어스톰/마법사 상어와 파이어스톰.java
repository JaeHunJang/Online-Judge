import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, Q, len;
    static int[][] A;
    static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        len = (int) Math.pow(2, N);
        A = new int[len][len];

        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int L = Integer.parseInt(st.nextToken());
            conquor((int) Math.pow(2, L), 0, 0, len, len);
            melting();
        }

        int sumIce = 0;
        int maxIce = 0;
        boolean[][] visited = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (A[i][j] > 0) {
                    sumIce += A[i][j];
                    if (!visited[i][j]) {
                        maxIce = Math.max(maxIce, bfs(i, j, visited));
                    }
                }
            }
        }

        System.out.println(sumIce);
        System.out.println(maxIce);
    }

    static int bfs(int i, int j, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        int size = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < deltas.length; d++) {
                int nr = now[0] + deltas[d][0];
                int nc = now[1] + deltas[d][1];

                if (nr < 0 || nr >= len || nc < 0 || nc >= len || A[nr][nc] <= 0 || visited[nr][nc]) continue;
                size++;
                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc});
            }
        }
        return size;
    }

    static void melting() {
        int[][] tmp = new int[len][len];
        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                int cnt = 0;
                for (int d = 0; d < deltas.length; d++) {
                    int nr = r + deltas[d][0];
                    int nc = c + deltas[d][1];

                    if (nr < 0 || nr >= len || nc < 0 || nc >= len || A[nr][nc] <= 0) continue;
                    cnt++;
                }
                tmp[r][c] = A[r][c];
                if (cnt < 3) {
                    tmp[r][c]--;
                    if (tmp[r][c] <= 0) tmp[r][c] = 0;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            A[i] = tmp[i].clone();
        }
    }

    static void conquor(int len, int sr, int sc, int er, int ec) {
        if ((er - sr) == len) {
            rotate(sr, sc, er, ec);
            return;
        }
        int sr1 = sr;
        int sc1 = sc;
        int er1 = (sr + er) / 2;
        int ec1 = (sc + ec) / 2;

        int sr2 = sr;
        int sc2 = (sc + ec) / 2;
        int er2 = (sr + er) / 2;
        int ec2 = ec;

        int sr3 = (sr + er) / 2;
        int sc3 = sc;
        int er3 = er;
        int ec3 = (sc + ec) / 2;

        int sr4 = (sr + er) / 2;
        int sc4 = (sc + ec) / 2;
        int er4 = er;
        int ec4 = ec;

        conquor(len, sr1, sc1, er1, ec1);
        conquor(len, sr2, sc2, er2, ec2);
        conquor(len, sr3, sc3, er3, ec3);
        conquor(len, sr4, sc4, er4, ec4);

    }

    static void rotate(int sr, int sc, int er, int ec) {
        int len = er - sr;
        int[][] tmp = new int[len][len];

        for (int i = sr; i < er; i++) {
            for (int j = sc; j < ec; j++) {
                tmp[j-sc][(len-i-1)+sr] = A[i][j];
            }
        }
        for (int i = sr; i < er; i++) {
            for (int j = sc; j < ec; j++) {
                A[i][j] = tmp[i-sr][j-sc];
            }
        }
    }
}
