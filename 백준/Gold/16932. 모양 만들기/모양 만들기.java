import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[][] deltas = {{0,-1},{-1,0},{0,1},{1,0}};
    static List<Integer> roomSizes = new ArrayList<>();

    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int roomId = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0 && map[i][j] == 1) {
                    roomId++;
                    int size = bfs(new Pos(i, j), roomId);
                    roomSizes.add(size);
                }
            }
        }

        int maxSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) continue;
                Set<Integer> set = new HashSet<>();
                for (int d = 0; d < 4; d++) {
                    int nr = i + deltas[d][0];
                    int nc = j + deltas[d][1];
                    if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                        if (visited[nr][nc] > 0) {
                            set.add(visited[nr][nc]);
                        }
                    }
                }
                int size = 1;
                for (int rid : set) {
                    size += roomSizes.get(rid-1);
                }
                maxSize = Math.max(maxSize, size);
            }
        }

        System.out.println(maxSize);
    }

    static int bfs(Pos start, int roomId) {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(start);
        visited[start.r][start.c] = roomId;
        int size = 1;

        while (!q.isEmpty()) {
            Pos now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r + deltas[d][0];
                int nc = now.c + deltas[d][1];
                if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                    if (visited[nr][nc] != 0) continue;
                    if (map[nr][nc] == 0) continue;
                    visited[nr][nc] = roomId;
                    q.offer(new Pos(nr, nc));
                    size++;
                }
            }
        }
        return size;
    }

}
