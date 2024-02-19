import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class Coordinate {
		int x,y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int T, N, result, map[][], deltas[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static boolean[][] visited;
	private static Coordinate start;
	public static void main(String[] args) throws Exception {
		init();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			st = new StringTokenizer(br.readLine());
			N = 100;
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] == 2) start = new Coordinate(i, j);
				}
			}
			
			result = 0;
			solve();
			sb.append("\n");
		}
	}
	
	private static void solve() throws Exception {
		visited[start.x][start.y] = true;
		dfs(start.x, start.y);
//		bfs();
		
		sb.append(result);
	}
	
	private static void dfs(int x, int y) {
		for (int d = 0; d < deltas.length; d++) {
			int nx = deltas[d][0] + x;
			int ny = deltas[d][1] + y;
			
			if (!isIn(nx, ny)) continue;
			if (visited[nx][ny]) continue;
			if (map[nx][ny] == 0) {
				visited[nx][ny] = true;
				dfs(nx, ny);
				visited[nx][ny] = false;
			} else if (map[nx][ny] == 3) {
				result = 1;
				return;
			}
		}
		
	}
	
	private static void bfs() {
		Queue<Coordinate> q = new ArrayDeque<>();
		q.offer(start);
		visited[start.x][start.y] = true;
		
		while (!q.isEmpty()) {
			Coordinate current = q.poll();
//			System.out.println(current.x + "|" + current.y);
			for (int d = 0; d < deltas.length; d++) {
				int nx = deltas[d][0] + current.x;
				int ny = deltas[d][1] + current.y;
				
				if (!isIn(nx, ny)) continue;
				if (visited[nx][ny]) continue;
				if (map[nx][ny] == 0) {
					q.offer(new Coordinate(nx, ny));
					visited[nx][ny] = true;
				} else if (map[nx][ny] == 3) {
					result = 1;
					return;
				}
			}
		}
	}	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}