import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, map[][], dp[][];
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
		N = Integer.parseInt(st.nextToken()); // 삼각형의 크기
		map = new int[N][N+1];
		dp = new int[N][N+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
	
	private static void solve() throws Exception {
		dp[0][1] = map[0][1];
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= i+1; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1] + map[i][j], dp[i-1][j] + map[i][j]);
			}
		}
		int result = 0;
		for (int j = 1; j <= N; j++) {
			result = Math.max(result, dp[N-1][j]);
		}
		sb.append(result);
	}
}