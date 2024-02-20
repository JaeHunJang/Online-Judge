import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, count1, count2, deltas[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static String[][] map;
	private static boolean[][] visited;
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
		N = Integer.parseInt(st.nextToken()); // 구역의 크기
		
		map = new String[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}
		
		count1 = 0; // 적록색약이 아닌 구역 개수
		count2 = 0; // 적록색약인 구역 개수
	}
	
	private static void solve() throws Exception {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) continue;
				dfs(i, j, map[i][j]); // 적록색약이 아닌 사람
				count1++;
			}
		}
		visited = new boolean[N][N]; // dfs를 2번 하기 때문에 visited 배열 다시 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) continue;
				if ("RG".contains(map[i][j])) // 적록색약인 사람
					dfs(i, j, "RG");
				else
					dfs(i, j, map[i][j]);
				count2++;
			}
		}
		sb.append(count1).append(" ").append(count2);
	}
	
	private static void dfs(int r, int c, String color) {
		visited[r][c] = true;
		
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if (!isIn(nr, nc)) continue;
			if (visited[nr][nc]) continue;
			if (color.contains(map[nr][nc])) {
				dfs(nr, nc, color);
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
