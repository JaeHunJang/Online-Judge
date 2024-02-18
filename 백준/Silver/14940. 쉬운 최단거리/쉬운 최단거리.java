import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Coordinate {
		int x, y, dist;

		public Coordinate(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, M, map[][], dp[][], deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	private static Coordinate start;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 

		map = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
				if (map[i][j] != 0) dp[i][j] = -1;
				if (map[i][j] == 2) start = new Coordinate(i, j, 0);
			}
		}
	}
	
	private static void solve() {
		bfs();
		printArr();
	}
	
	private static void bfs() {
		Queue<Coordinate> q = new ArrayDeque<>();
		q.offer(start);
		dp[start.x][start.y] = 0;
		while (!q.isEmpty()) {
			Coordinate current = q.poll();
			
			for (int d = 0; d < deltas.length; d++) {
				int nx = current.x + deltas[d][0];
				int ny = current.y + deltas[d][1];
				
				if (!isIn(nx, ny)) continue;
				if (dp[nx][ny] > 0) continue;
				if (map[nx][ny] == 1) {
					dp[nx][ny] = current.dist+1;
					q.offer(new Coordinate(nx, ny, current.dist+1));
				}
				if (map[nx][ny] == 0) {
					dp[nx][ny] = 0;
				}
			}
		}
	}
	
	private static void printArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(dp[i][j]).append(" ");
			}
			sb.append("\n");
		}
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}