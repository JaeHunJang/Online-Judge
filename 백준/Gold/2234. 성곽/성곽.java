import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[][] deltas = {{0,-1},{-1,0},{0,1},{1,0}}; // 서 북 동 남
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
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int roomCount = 0;
        int maxRoomSize = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    roomCount++;
                    int size = bfs(new Pos(i, j), roomCount);
                    roomSizes.add(size);
                    maxRoomSize = Math.max(maxRoomSize, size);
                }
            }
        }

        int maxMergedSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 4; d++) {
                    int nr = i + deltas[d][0];
                    int nc = j + deltas[d][1];
                    if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                        if (visited[i][j] != visited[nr][nc]) {
                            int size = roomSizes.get(visited[i][j] - 1) + roomSizes.get(visited[nr][nc] - 1);
                            maxMergedSize = Math.max(maxMergedSize, size);
                        }
                    }
                }
            }
        }

        System.out.println(roomCount);
        System.out.println(maxRoomSize);
        System.out.println(maxMergedSize);
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
                    if (hasWall(d, map[now.r][now.c])) continue;
                    visited[nr][nc] = roomId;
                    q.offer(new Pos(nr, nc));
                    size++;
                }
            }
        }
        return size;
    }

    static boolean hasWall(int d, int cell) {
        return (cell & (1 << d)) != 0;
    }
}
