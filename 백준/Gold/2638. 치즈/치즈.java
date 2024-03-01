import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M, map[][], deltas[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static Queue<Cheeze> cheeze;
	static class Cheeze {
		int r, c, t;

		public Cheeze(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 모눈종이
		M = Integer.parseInt(st.nextToken()); // 모눈종이
		cheeze = new ArrayDeque<>();
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cheeze.offer(new Cheeze(i, j));
			}
		}
	}
	
	private static void solve() throws Exception {
		int time = 0;
		while(!cheeze.isEmpty()) {
			contactAir(bfsAir(new boolean[N][M]));
			meltingCheeze();
			time++;
		}
		sb.append(time);
	}
	
	private static void meltingCheeze() { // 치즈 녹이기
		int size = cheeze.size();
		for (int i = 0; i < size; i++) {
			Cheeze c = cheeze.poll();
			if (c.t >= 2) { // 녹을 치즈
				map[c.r][c.c] = 0; // 치즈 녹은 자리 공기층으로 변경
			} else {
				c.t = 0; // 닿는 면적 초기화
				cheeze.offer(c); // 안족은 치즈 다시 넣기
			}
		}
	}
	
	private static void contactAir(boolean[][] visited) { // 치즈별 닿는 면적 확인
		for (Cheeze cheeze : cheeze) {
			for (int d = 0; d < deltas.length; d++) {
				int nr = cheeze.r + deltas[d][0];
				int nc = cheeze.c + deltas[d][1];
				if (!isIn(nr, nc)) continue;
				if (visited[nr][nc]) cheeze.t++; // 닿는 면적 카운팅
			}
		}
	}
	
	private static boolean[][] bfsAir(boolean[][] visited) { // 처음 공기층 확인
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			
			for (int d = 0; d < deltas.length; d++) {
				int nr = cur[0] + deltas[d][0];
				int nc = cur[1] + deltas[d][1];
				if (!isIn(nr, nc)) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc] != 0) continue;
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
		return visited;
	}
	private static void printArr2(boolean[][] visited) {
		for (int i = 0; i < visited.length; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
		System.out.println();
	}
	
	private static void printArr() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}