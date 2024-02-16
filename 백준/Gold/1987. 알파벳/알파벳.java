import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int R, C, maxCount;
	private static char map[][];
	private static boolean alpha[];
	private static int deltas[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
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
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		
		map = new char[R][C]; // 보드
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		alpha = new boolean[26]; // 방문여부
		maxCount = 0;
	}
	
	private static void solve() throws Exception {
		alpha[map[0][0]-'A'] = true;
		dfs(1, 0, 0);
		sb.append(maxCount);
	}
	
	private static void dfs(int cnt, int r, int c) {
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if (!isIn(nr, nc)) continue;
			if (alpha[map[nr][nc]-'A']) continue;
			else {
				alpha[map[nr][nc]-'A'] = true;
				dfs(cnt+1, nr, nc);
				alpha[map[nr][nc]-'A'] = false;
			}
		}
		maxCount = Math.max(maxCount, cnt);
	}
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}