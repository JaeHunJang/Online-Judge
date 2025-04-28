import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, min, max;
    static char map[][];
    static class Pos {
        int r, c, sum;
        char op;
        Pos (int r, int c, int sum) {
            this.r = r;
            this.c = c;
            this.sum = sum;
            op = '.';
        }
        Pos (int r, int c, int sum, char op) {
            this.r = r;
            this.c = c;
            this.sum = sum;
            this.op = op;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "r=" + r +
                    ", c=" + c +
                    ", sum=" + sum +
                    ", op=" + op +
                    '}';
        }
    }
    static int deltas[][] = {{1,0},{0,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
//            System.out.println(Arrays.toString(map[i]));
        }

        find();
        System.out.println(max + " " + min);
    }

    static void find() {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(0, 0, map[0][0]-'0'));
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        while (!q.isEmpty()) {

            int size = q.size();
//            System.out.println(q);
            for (int s = 0; s < size; s++) {

                Pos now = q.poll();

                if (now.r == N-1 && now.c == N-1) {
                    min = Math.min(min, now.sum);
                    max = Math.max(max, now.sum);
                }

                for (int d = 0; d < deltas.length; d++) {
                    int nr = now.r + deltas[d][0];
                    int nc = now.c + deltas[d][1];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
//                    visited[nr][nc] = true;
                    if (Character.isDigit(map[nr][nc])) {
                        int sum = now.sum;
                        int num = (map[nr][nc] - '0');
                        if (now.op == '+') {
                            sum += num;
                        } else if (now.op == '-') {
                            sum -= num;
                        } else if (now.op == '*') {
                            sum *= num;
                        }
                        q.offer(new Pos(nr, nc, sum));
                    } else {
                        q.offer(new Pos(nr, nc, now.sum, map[nr][nc]));
                    }
                }
            }
        }
    }
}