import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static int M;
	private static String[][] map;
	private static boolean[][] dp;
	private static int count;
	private static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws Exception {
		init();
		solve();
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		dp = new boolean[N][M];
		count = 0;
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}
	}

	private static void solve() throws Exception {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j].equals("I")) {
					dp[i][j] = true;
					bfs(i, j);
				}
			}
		}
		
		if (count == 0) sb.append("TT");
		else sb.append(count);
	}
	
	private static void bfs(int i, int j) {
		if (map[i][j].equals("P")) count++;
		
		for (int d = 0; d < deltas.length; d++) {
			int nx = i + deltas[d][0];
			int ny = j + deltas[d][1];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) 
				continue;
			if (map[nx][ny].equals("X")) {
				dp[nx][ny] = true;
				continue;
			}
			
			if (!dp[nx][ny]) {
				dp[nx][ny] = true;
				bfs(nx, ny);
			}
		}
	}
}