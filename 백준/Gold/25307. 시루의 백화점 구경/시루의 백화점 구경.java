import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    static int N, M, K, map[][], deltas[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static Pos start, end;
	static Queue<Pos> dolls;
	static class Pos {
		int r, c, before;

		public Pos(int r, int c, int b) {
			this.r = r;
			this.c = c;
			this.before = b;
		}

		@Override
		public String toString() {
			return "Pos{" +
					"r=" + r +
					", c=" + c +
					", before=" + before +
					'}';
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dolls = new ArrayDeque<>();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 4) {
					start = new Pos(i, j, 0);
					map[i][j] = 0;
				}
				if (map[i][j] == 3) dolls.offer(new Pos(i, j, 0));
			}
		}

		fillMap();
		System.out.println(simulation());
	}

	static void fillMap() {
		boolean[][] marked = new boolean[N][M];
		Queue<int[]> q = new ArrayDeque<>();

		for (Pos doll : dolls) {
			q.offer(new int[]{doll.r, doll.c, 0});
			marked[doll.r][doll.c] = true;
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0], c = now[1], depth = now[2];
			if (depth > K) continue;

			map[r][c] = 1;

			for (int[] d : deltas) {
				int nr = r + d[0], nc = c + d[1];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (marked[nr][nc]) continue;

				marked[nr][nc] = true;
				q.offer(new int[]{nr, nc, depth + 1});
			}
		}
	}

	static int simulation() {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(start.r, start.c, map[start.r][start.c]));
		int[][] visited = new int[N][M];
		int cnt = 1;
		visited[start.r][start.c] = cnt;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Pos now = q.poll();

				if (map[now.r][now.c] == 2) {
					return cnt - 1;
				}

				for (int[] d : deltas) {
					int nr = d[0] + now.r;
					int nc = d[1] + now.c;

					if (0 <= nr && nr < N && 0 <= nc && nc < M) {
						if (visited[nr][nc] > 0 || map[nr][nc] == 1 || map[nr][nc] == 3) continue;
						visited[nr][nc] = cnt;
						q.offer(new Pos(nr, nc, map[nr][nc]));
					}
				}
			}
//			System.out.println(q);
			cnt++;
		}

		return -1;
	}

}