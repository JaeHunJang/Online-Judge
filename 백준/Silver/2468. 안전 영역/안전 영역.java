import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, map[][], deltas[][] = {{0,1},{-1,0},{0,-1},{1,0}};
    static boolean visited[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        print();
        int max = 1;
        for (int k = 1; k <= 100; k++) {
            visited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > k && !visited[i][j]) {
                        cnt++;
                        find(i, j, k);
    //                    print();
                    }
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    static void print() {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

    static void find(int r, int c, int depth) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] d : deltas) {
                int nr = now[0] + d[0];
                int nc = now[1] + d[1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] <= depth || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc});
            }
        }
    }
}