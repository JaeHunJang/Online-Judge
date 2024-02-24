import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int R, C, result, dp[][];
	private static char map[][];
	private static int deltas[][] = {{-1, 1}, {0, 1}, {1, 1}};
	private static boolean flag;
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
		R = Integer.parseInt(st.nextToken()); // 가로
		C = Integer.parseInt(st.nextToken()); // 세로
		
		map = new char[R][C];
		dp = new int[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		result = 0;
	}
	
	private static void solve() throws Exception {
		for (int r = 0; r < R; r++) {
			flag = false;
			map[r][0] = (char) ('0'+r);
			dfs(r, 0, (char) ((char)'0'+r));
		}
		
		sb.append(result);
	}
	
	private static void dfs(int row, int col, char marker) {
		if (col == C-1) {
			flag = true; // 한번 도착하면 더이상 진행안함
			result++;
			return;
		}
		
		for (int d = 0; d < deltas.length; d++) {
			int nr = row + deltas[d][0];
			int nc = col + deltas[d][1];
			if (!isIn(nr,nc)) continue;
			if (map[nr][nc] != '.') continue;
			map[nr][nc] = marker;
			dfs(nr, nc, marker);
			if (flag) return; // 도착했으면 재귀 종료
		}
	}
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
	
	private static void printArr() {
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
}