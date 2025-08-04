import java.io.*;
import java.util.*;

public class Main {
    static int N, K, L;
    static int[][] map;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우, 하, 좌, 상
    static Map<Integer, Character> turns = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1; // 사과 위치
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            turns.put(X, C);
        }

        System.out.println(simulate());
    }

    static int simulate() {
        ArrayDeque<int[]> snake = new ArrayDeque<>();
        boolean[][] visited = new boolean[N + 1][N + 1];
        snake.offer(new int[]{1, 1});
        visited[1][1] = true;

        int time = 0;
        int d = 0; // 처음에는 오른쪽

        int r = 1, c = 1;

        while (true) {
            time++;
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            // 벽이나 자기자신에 부딪힘
            if (nr < 1 || nr > N || nc < 1 || nc > N || visited[nr][nc]) {
                return time;
            }

            // 머리 추가
            snake.offerLast(new int[]{nr, nc});
            visited[nr][nc] = true;

            if (map[nr][nc] == 1) {
                // 사과 있으면 꼬리 유지
                map[nr][nc] = 0;
            } else {
                // 사과 없으면 꼬리 제거
                int[] tail = snake.pollFirst();
                visited[tail[0]][tail[1]] = false;
            }

            // 방향 전환
            if (turns.containsKey(time)) {
                char turn = turns.get(time);
                if (turn == 'L') {
                    d = (d + 3) % 4;
                } else {
                    d = (d + 1) % 4;
                }
            }

            r = nr;
            c = nc;
        }
    }
}
