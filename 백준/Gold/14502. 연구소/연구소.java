import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M, count, map[][], deltas[][] = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	static final int MAX_WALL = 3;
	static List<Pos> areaList;
	static List<Pos> virusList;
	static Pos[] walls;
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
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
		N = Integer.parseInt(st.nextToken()); // 연구소 크기
		M = Integer.parseInt(st.nextToken()); // 연구소 크기
		areaList = new ArrayList<>();
		virusList = new ArrayList<>();
		walls = new Pos[MAX_WALL];
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) areaList.add(new Pos(i, j));
				if (map[i][j] == 2) virusList.add(new Pos(i, j));
			}
		}
	}
	
	private static void solve() throws Exception {
		dfs(0, 0);
		sb.append(count);
	}
	
	private static void dfs(int cnt, int start) {
		if (cnt == MAX_WALL) {
			count = Math.max(bfs(new boolean[N][M]), count);
			return;
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				if (map[i][j] > 0) continue;
//				map[i][j] = 3;
//				walls[cnt] = new Pos(i, j);
//				dfs(cnt+1, i+1);
//				map[i][j] = 0;
//			}
//		}
		for (int i = start; i < areaList.size(); i++) {
			Pos cur = areaList.get(i);
			map[cur.r][cur.c] = 3;
			walls[cnt] = cur;
			dfs(cnt+1, i+1);
			map[cur.r][cur.c] = 0;
		}
	}
	
	private static int bfs(boolean[][] visited) {
		Queue<Pos> q = new ArrayDeque<>();
		for (Pos v : virusList) {
			q.offer(v);
			visited[v.r][v.c] = true; 
		}
		for (Pos w : walls) {
			visited[w.r][w.c] = true; 
		}
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nr = cur.r + deltas[d][0];
				int nc = cur.c + deltas[d][1];
				if (!isIn(nr, nc)) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc] == 1) {
					visited[nr][nc] = true;
					continue;
				}
				if (map[nr][nc] == 0) {
					visited[nr][nc] = true;
					q.offer(new Pos(nr, nc));
				}
			}
		}
		
		int areaCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 0) areaCnt++;
			}
		}
		 
		return areaCnt;
	}
	
	private static int[][] copyArr(int[][] map) {
		int temp[][] = new int[map.length][];
		for (int i = 0; i < map.length; i++) {
			temp[i] = map[i].clone();
		}
		return temp;
	}
	
	private static void printArr() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
	
	private static void printArr2(boolean[][] visited) {
		for (int i = 0; i < visited.length; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
		System.out.println();
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}