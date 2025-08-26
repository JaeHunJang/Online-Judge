import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, V, K, deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};;
    static char map[][];
    static boolean visited[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        V = 0;
        K = 0;
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    find(i, j);
                }
            }
        }

        System.out.println(K + " " + V);
    }

    static void find(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j});
        visited[i][j] = true;
        int sheep = 0;
        int wolf = 0;

        if (map[i][j] == 'v') wolf++;
        else if (map[i][j] == 'k') sheep++;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] now = q.poll();

                for (int[] d : deltas) {
                    int nr = now[0] + d[0];
                    int nc = now[1] + d[1];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == '#') continue;
                    visited[nr][nc] = true;
                    if (map[nr][nc] == 'v') wolf++;
                    else if (map[nr][nc] == 'k') sheep++;
                    q.offer(new int[] {nr, nc});
                }
            }
        }

        if (sheep > wolf) wolf = 0;
        else sheep = 0;
        V += wolf;
        K += sheep;
    }
}
