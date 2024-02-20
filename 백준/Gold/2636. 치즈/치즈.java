import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, M, map[][], time, count, deltas[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static boolean visited[][];
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
		N = Integer.parseInt(st.nextToken()); // 사각판 세로
		M = Integer.parseInt(st.nextToken()); // 사각판 가로
		time = 0; // 치즈가 다 녹는 시간
		count = 0; // 다 녹기 전 치즈 조각 칸 개수
		
		visited = new boolean[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	private static void solve() throws Exception {
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < M; j++) {
				if (visited[i][j]) continue;
				else {
					bfs(i, j);
					countBoundary();
					i = 0; // 치즈가 다 없어질때까지 반복
					j = 0;
				}
			}
		}
		sb.append(time).append("\n").append(count);
	}
	
	private static void bfs(int r, int c) {
		Queue<Coordinate> q = new ArrayDeque<>();
		q.offer(new Coordinate(r, c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Coordinate cur = q.poll();
			
			for (int d = 0; d < deltas.length; d++) {
				int nr = cur.r + deltas[d][0];
				int nc = cur.c + deltas[d][1];
				
				if (!isIn(nr, nc)) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc] == 0) { // 공기층이면 계속 탐색
					visited[nr][nc] = true;
					q.offer(new Coordinate(nr, nc));
				} else if (map[nr][nc] == 1) { // 공기층에 맞닿은 치즈는 구분
					map[nr][nc] = 2;
				}
			}
		}
	}
	
	private static void countBoundary() {
		int cnt = 0; // 지금 치즈조각 칸의 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j]) continue;
				if (map[i][j] == 2) {
					cnt++;
					map[i][j] = 0;
				}
			}
		}
		if (cnt != 0) { 
			time++;
			count = cnt;
			initVisitedArr(); // 치즈가 하나라도 있으면 다시 진행하기 위해 방문배열 초기화
		}
	}
	
	private static void initVisitedArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	static class Coordinate {
		int r,c;

		public Coordinate(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
