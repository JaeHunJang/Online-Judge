import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M, deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static char[][] map;
	static Pos S, H;
	static int[][] fishMap, homeMap;
	static final int INF = 1000 * 1000 + 1;
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			int j = 0;
			for (char ch : br.readLine().toCharArray()){
				map[i][j] = ch;
				if (map[i][j] == 'S') S = new Pos(i, j);
				if (map[i][j] == 'H') H = new Pos(i, j);
				j++;
			}
		}

		fishMap = bfs(S);
//		System.out.println("================================");
		homeMap = bfs(H);

		boolean isPossible = false;
		int minTime = INF;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'F' && fishMap[i][j] != INF && homeMap[i][j] != INF) {
					minTime = Math.min(minTime, fishMap[i][j] + homeMap[i][j]);
					isPossible = true;
				}
			}
		}

		if (!isPossible) {
			System.out.println(-1);
			return;
		}

		System.out.println(minTime);
	}

	static int[][] bfs(Pos start) {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(start);
		int[][] visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], INF);
		}
		int time = 0;
		visited[start.r][start.c] = time;

		while (!q.isEmpty()) {
			int size = q.size();
			time++;
			for (int s = 0; s < size; s++) {
				Pos now = q.poll();

				for (int[] d : deltas) {
					int nr = d[0] + now.r;
					int nc = d[1] + now.c;
					if (0 <= nr && nr < N && 0 <= nc && nc < M) {
						if (visited[nr][nc] != INF || map[nr][nc] == 'D') continue;
						visited[nr][nc] = time;
						q.offer(new Pos(nr, nc));
					}
				}
			}

//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
//			System.out.println();
		}

		return visited;
	}
}
