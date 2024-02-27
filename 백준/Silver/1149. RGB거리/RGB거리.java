import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, rgbs[][], dp[][], result;
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
		N = Integer.parseInt(st.nextToken()); // 집 개수
		rgbs = new int[N][3];
		dp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgbs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = rgbs[0][0];
		dp[0][1] = rgbs[0][1];
		dp[0][2] = rgbs[0][2];
		
	}
	
	private static void solve() throws Exception {
		for (int i = 1; i < N; i++) {
				dp[i][0] = rgbs[i][0] +  Math.min(dp[i-1][1], dp[i-1][2]);
				dp[i][1] = rgbs[i][1] +  Math.min(dp[i-1][0], dp[i-1][2]);
				dp[i][2] = rgbs[i][2] +  Math.min(dp[i-1][1], dp[i-1][0]);
		}
		result = dp[N-1][0];
		for (int i = 1; i < 3; i++) {
			result = Math.min(dp[N-1][i], result);
		}
		System.out.println(result);
	}
}